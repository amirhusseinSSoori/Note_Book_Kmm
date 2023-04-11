plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.amirhusseinSoori.notebookkmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.amirhusseinSoori.notebookkmm.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.1")
    implementation("androidx.compose.ui:ui-tooling:1.4.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.1")
    implementation("androidx.compose.foundation:foundation:1.4.1")
    implementation("androidx.compose.material:material:1.4.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")


    implementation ("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}


