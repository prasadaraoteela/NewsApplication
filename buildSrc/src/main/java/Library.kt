/**
 * Created by Prasad Rao on 11-08-2020 10:01
 **/
object Library {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    }

    object Androidx { // All the AndroidX libraries
        const val appCompat = "androidx.appcompat:appcompat:${Version.support}"
        const val annotations = "androidx.annotation:annotation:${Version.support}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val kotlinExtensions = "androidx.core:core-ktx:1.2.0"
        const val multiDex = "com.android.support:multidex:1.0.3"
    }

    object Google {
        const val materialDesign = "com.google.android.material:material:1.1.0"
    }

    object JetPack {
        // Lifecycle library dependencies
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val annotations = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
        const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
        const val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycle}"
        const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Version.lifecycle}"
        const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Version.lifecycle}"
        const val fragmentViewModel = "androidx.fragment:fragment-ktx:1.2.2"

        // Google play update library
        const val playCore = "com.google.android.play:core:1.7.2"

        // Navigation view library
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

        // Room ORM library
        const val room = "androidx.room:room-runtime:${Version.room}"
        const val roomAnnotations = "androidx.room:room-compiler:${Version.room}"
        const val roomKotlinExtensions = "androidx.room:room-ktx:${Version.room}"

        // Work-manager library
        const val workManager = "androidx.work:work-runtime-ktx:2.3.4"

        // Paging library
        const val paging = "androidx.paging:paging-runtime:2.1.2"

        // Data binding library
        const val dataBinding = "com.android.databinding:compiler:2.3.1"
    }

    object Paging {
        private const val PAGING_VERSION = "3.0.1"

        const val CORE = "androidx.paging:paging-runtime:$PAGING_VERSION"
    }

    object Dagger {
        private const val DAGGER_VERSION = "2.40.5"

        const val CORE = "com.google.dagger:dagger:$DAGGER_VERSION"
        const val COMPILER = "com.google.dagger:dagger-compiler:$DAGGER_VERSION"
        const val ANDROID_CORE = "com.google.dagger:dagger-android:$DAGGER_VERSION"
        const val ANDROID_ANNOTATIONS = "com.google.dagger:dagger-android-processor:$DAGGER_VERSION"
    }

    object Hilt {
        // Version
        private const val hiltVersion = "2.28-alpha"
        private const val lifeCycleVersion = "1.0.0-alpha01"

        // Core dependencies
        const val core = "com.google.dagger:hilt-android:$hiltVersion"
        const val annotations = "com.google.dagger:hilt-android-compiler:$hiltVersion"

        // When using Kotlin with lifecycle.
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$lifeCycleVersion"
        const val viewModelAnnotations = "androidx.hilt:hilt-compiler:$lifeCycleVersion"

        // Hilt testing dependency
        const val test = "com.google.dagger:hilt-android-testing:$hiltVersion"

        // Make Hilt generate code in the androidTest folder
        const val testAnnotations = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    }

    object Retrofit {
        private const val retrofit_version = "2.8.1"
        private const val ok_http_version = "4.5.0"

        // Retrofit library dependencies
        const val core = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val jsonConverter = "com.squareup.retrofit2:converter-gson:$retrofit_version"
        const val okHttp = "com.squareup.okhttp3:okhttp:$ok_http_version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$ok_http_version"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val junitAndroid = "androidx.test.ext:junit:1.1.1"
        const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
        const val hamcrest = "org.hamcrest:hamcrest-all:1.3"
        const val robolectric = "org.robolectric:robolectric:4.3"
        const val mockito = "org.mockito:mockito-core:3.4.6"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.8"
    }

    object Glide {
        private const val version = "4.9.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val annotations = "com.github.bumptech.glide:compiler:$version"
    }

    /** All other miscellaneous library dependencies will come here */
    object Other {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }
}