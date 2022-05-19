/**
 * Created by Prasad Rao on 11-08-2020 10:01
 **/
object Library {
  object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.Core}"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.Coroutines}"
    const val coroutines =
      "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.Coroutines}"
  }

  object Androidx { // All the AndroidX libraries
    const val appCompat = "androidx.appcompat:appcompat:${Versions.Androidx.Appcompat}"
    const val annotations = "androidx.annotation:annotation:${Versions.Androidx.Annotation}"
    const val constraintLayout =
      "androidx.constraintlayout:constraintlayout:${Versions.Androidx.ConstraintLayout}"
    const val kotlinExtensions = "androidx.core:core-ktx:${Versions.Kotlin.AndroidExtensions}"
  }

  object Google {
    const val materialDesign =
      "com.google.android.material:material:${Versions.Google.MaterialDesign}"
  }

  object JetPack {
    // Lifecycle library dependencies
    const val viewModel =
      "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.Lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.Lifecycle}"
    const val annotations = "androidx.lifecycle:lifecycle-compiler:${Versions.Androidx.Lifecycle}"
    const val lifecycleSavedState =
      "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Androidx.Lifecycle}"
    const val lifecycleProcess =
      "androidx.lifecycle:lifecycle-process:${Versions.Androidx.Lifecycle}"
    const val lifecycleService =
      "androidx.lifecycle:lifecycle-service:${Versions.Androidx.Lifecycle}"
    const val fragmentViewModel = "androidx.fragment:fragment-ktx:${Versions.Androidx.Fragment}"

    // Google play update library
    const val playCore = "com.google.android.play:core:${Versions.Google.PlayCore}"
    const val playCoreKtx = "com.google.android.play:core-ktx:${Versions.Google.PlayCoreKtx}"

    // Navigation view library
    const val navigationFragment =
      "androidx.navigation:navigation-fragment-ktx:${Versions.Androidx.Navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.Androidx.Navigation}"

    // Room ORM library
    const val room = "androidx.room:room-runtime:${Versions.Androidx.Room}"
    const val roomAnnotations = "androidx.room:room-compiler:${Versions.Androidx.Room}"
    const val roomKotlinExtensions = "androidx.room:room-ktx:${Versions.Androidx.Room}"

    // Work-manager library
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.Androidx.Work}"
  }

  object Paging {
    const val Core = "androidx.paging:paging-runtime:${Versions.Androidx.Paging}"
  }

  object Hilt {
    // Core dependencies
    const val core = "com.google.dagger:hilt-android:${Versions.Androidx.Hilt}"
    const val annotations = "com.google.dagger:hilt-compiler:${Versions.Androidx.Hilt}"

    // Hilt testing dependency
    const val test = "com.google.dagger:hilt-android-testing:${Versions.Androidx.Hilt}"

    // Make Hilt generate code in the androidTest folder
    const val testAnnotations = "com.google.dagger:hilt-android-compiler:${Versions.Androidx.Hilt}"
  }

  object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.Core}"
    const val jsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.Core}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Retrofit.OkHttp}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.OkHttp}"
  }

  object Test {
    const val junit = "junit:junit:4.12"
    const val junitAndroid = "androidx.test.ext:junit:1.1.1"
    const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
    const val hamcrest = "org.hamcrest:hamcrest-all:1.3"
    const val robolectric = "org.robolectric:robolectric:4.6"
    const val mockito = "org.mockito:mockito-core:3.4.6"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.8"
  }

  object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.Glide}"
    const val annotations = "com.github.bumptech.glide:compiler:${Versions.Glide}"
  }

  /** All other miscellaneous library dependencies will come here */
  object Other {
    const val timber = "com.jakewharton.timber:timber:4.7.1"
  }
}