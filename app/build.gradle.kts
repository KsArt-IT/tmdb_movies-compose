plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = libs.versions.id.get()
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.compile.get().toInt()
        versionCode = libs.versions.code.get().toInt()
        versionName = libs.versions.name.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "33.0.1"
}

dependencies {
    implementation(libs.android.core.ktx)

    // SplashScreen on devices prior Android 12
    implementation(libs.android.core.splashscreen)

    implementation(libs.android.appcompat)

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

    // Coil
    implementation(libs.compose.coil)

    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.junit.espresso)

    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.test.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
