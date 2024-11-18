plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
}

android {
    namespace = "dev.smolyakoff.chucknorris.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "dev.smolyakoff.chucknorris.android"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.koin.android)
    implementation(libs.koin.compose.android)

    implementation(libs.coil.compose)

    implementation(libs.compose.navigation)
    implementation(libs.kotlinx.serilization.json)

    implementation(libs.icons.extended)
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
}