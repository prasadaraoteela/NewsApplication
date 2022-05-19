package com.test.news.ui

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.test.news.common.extension.isMainThread
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Prasada Rao on 10/04/22 6:05 PM
 **/
inline fun <reified Binding: ViewBinding> AppCompatActivity.viewBinding(
  noinline inflater: (LayoutInflater) -> Binding
): ActivityViewBindingDelegate<Binding> {
  return ActivityViewBindingDelegate(this, inflater)
}

class ActivityViewBindingDelegate<Binding : ViewBinding>(
  private val activity: AppCompatActivity,
  private val inflater: (LayoutInflater) -> Binding
) : ReadOnlyProperty<AppCompatActivity, Binding>, DefaultLifecycleObserver {

  private var _binding: Binding? = null

  init {
    activity.lifecycle.addObserver(this)
  }

  override fun onCreate(owner: LifecycleOwner) {
    super.onCreate(owner)
    if (_binding == null) {
      _binding = inflater(activity.layoutInflater)
    }
    activity.setContentView(_binding!!.root)
    activity.lifecycle.removeObserver(this)
  }

  override fun onDestroy(owner: LifecycleOwner) {
    super.onDestroy(owner)
    _binding = null
  }

  override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): Binding {
    if (_binding == null) {

      // This must be on the main thread only
      if (!isMainThread()) {
        throw IllegalThreadStateException("This cannot be called from other threads. It should be on the main thread only.")
      }

      _binding = inflater(activity.layoutInflater)
    }
    return _binding!!
  }
}