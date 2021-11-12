buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Classpath.gradle)
        classpath(Classpath.kotlin)
        classpath(Classpath.hilt)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}