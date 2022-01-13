buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpath.gradle)
        classpath(Classpath.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}