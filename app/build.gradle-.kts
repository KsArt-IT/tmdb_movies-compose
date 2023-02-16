plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "pro.ksart.tmdbmoviescompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "pro.ksart.tmdbmoviescompose"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "33.0.0"
}

dependencies {
    implementation(libs.android.core.ktx)
    implementation(libs.android.appcompat)

    // SplashScreen on devices prior Android 12
    implementation(libs.android.core.splashscreen)

    // Lifecycle KTX
    implementation(libs.android.lifecycle.runtime)
    implementation(libs.android.lifecycle.viewmodel)
    implementation(libs.android.lifecycle.viewmodel.savedstate)

    // Compose
    implementation(libs.compose.bom)
    androidTestImplementation(libs.compose.bom)

    implementation(libs.compose.compiler)
    implementation(libs.compose.activity)
    implementation(libs.bundles.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.material3)
    implementation(libs.compose.lifecycle.viewmodel)
    implementation(libs.compose.lifecycle.runtime)
    implementation(libs.compose.navigation)

    // Coroutines and Flow
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.compose.navigation)
    kapt(libs.hilt.compose.compiler)

    testImplementation(libs.assertj)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.junit.espresso)

    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.test.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
