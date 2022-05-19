package com.test.news.common.extension

import android.os.Looper

/**
 * Created by Prasada Rao on 10/04/22 6:16 PM
 **/
internal fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()