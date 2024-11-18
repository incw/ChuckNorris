plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.skie)
}

kotlin {


    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        commonMain.dependencies {

            implementation(libs.lifecycle.viewModel)

            implementation(libs.sqlite.bundled)
            implementation(libs.sqlite)

            implementation(libs.room.runtime)

            api(libs.koin.core)

            implementation(libs.coroutines.core)

            implementation(libs.ktor.core)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.content.negotation)
            implementation(libs.ktor.serialization.json)

        }
        androidMain.dependencies {
            implementation(libs.coroutines.android)
            implementation(libs.koin.compose.android)
            implementation(libs.ktor.engine.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.engine.darwin)
        }
    }
}

android {
    namespace = "dev.smolyakoff.chucknorris"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}


dependencies {

    listOf(
        "kspAndroid",
        "kspIosSimulatorArm64",
        "kspIosX64",
        "kspIosArm64"
    ).forEach {
        add(it, libs.room.compiler)
    }

}

room {
    schemaDirectory("$projectDir/schemas")
}

