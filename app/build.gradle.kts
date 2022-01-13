plugins {
    id(Plugin.application)
    kotlin(Plugin.android)
    kotlin(Plugin.androidExtensions)
    kotlin(Plugin.kapt)
}

android {
    compileSdkVersion(ApplicationConfig.compileSdkVersion)
    buildToolsVersion(ApplicationConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(ApplicationConfig.minSdkVersion)
        targetSdkVersion(ApplicationConfig.targetSdkVersion)
        versionCode = ApplicationConfig.versionCode
        versionName = ApplicationConfig.versionName
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = ApplicationConfig.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    // Android + Kotlin dependencies
    implementation(Library.Kotlin.stdLib)
    implementation(Library.Kotlin.core)
    implementation(Library.Kotlin.coroutines)

    // Androidx dependencies
    implementation(Library.Androidx.appCompat)
    implementation(Library.Androidx.constraintLayout)
    implementation(Library.Androidx.kotlinExtensions)
    implementation(Library.Androidx.multiDex)
    kapt(Library.Androidx.annotations)

    // Google dependencies
    implementation(Library.Google.materialDesign)

    // Jet Pack library dependencies
    implementation(Library.JetPack.navigationFragment)
    implementation(Library.JetPack.navigationUi)
    implementation(Library.JetPack.playCore)

    // Room database library
    implementation(Library.JetPack.room)
    implementation(Library.JetPack.roomKotlinExtensions)
    kapt(Library.JetPack.roomAnnotations)

    // Work manager library
    implementation(Library.JetPack.workManager)

    // Lifecycle library dependencies
    implementation(Library.JetPack.viewModel)
    implementation(Library.JetPack.liveData)
    kapt(Library.JetPack.annotations)
    implementation(Library.JetPack.lifecycleExtension)
    implementation(Library.JetPack.lifecycleSavedState)
    implementation(Library.JetPack.lifecycleProcess)
    implementation(Library.JetPack.lifecycleService)
    implementation(Library.JetPack.fragmentViewModel)

    // Paging library
    implementation(Library.JetPack.paging)

    // Data Binding library
//    implementation(Library.JetPack.dataBinding)

    // Retrofit network library dependencies
    implementation(Library.Retrofit.core)
    implementation(Library.Retrofit.okHttp)
    implementation(Library.Retrofit.jsonConverter)
    implementation(Library.Retrofit.logging)

    // Dagger dependency injection library
    implementation(Library.Dagger.CORE)
    kapt(Library.Dagger.COMPILER)
    implementation(Library.Dagger.ANDROID_CORE)
    kapt(Library.Dagger.ANDROID_ANNOTATIONS)

    // Glide library dependencies
    implementation(Library.Glide.glide)
    kapt(Library.Glide.annotations)

    // Test dependencies
    testImplementation(Library.Test.junit)
    testImplementation(Library.Test.robolectric)
    testImplementation(Library.Test.mockito)
    testImplementation(Library.Test.coroutines)
    testImplementation(Library.Test.hamcrest)

    // Instrumentation test dependencies
    androidTestImplementation(Library.Test.junitAndroid)
    androidTestImplementation(Library.Test.espresso)

    // Logging
    implementation(Library.Other.timber)

    // Paging
    implementation(Library.Paging.CORE)
}
