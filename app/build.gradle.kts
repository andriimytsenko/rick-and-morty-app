import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

android {
    namespace = "com.rickandmorty.app"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.rickandmorty.app"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    /* AndroidX & Lifecycle */
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.lifecycle)

    /* Jetpack Compose */
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.compose.ui.tooling)

    /* Navigation3 */
    implementation(libs.bundles.navigation3)

    /* Kotlin Coroutines */
    implementation(libs.kotlinx.coroutines.android)

    /* Ktor */
    implementation(platform(libs.ktor.bom))
    implementation(libs.bundles.ktor)

    /* Room */
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    /* Coil */
    implementation(platform(libs.coil.bom))
    implementation(libs.bundles.coil)

    /* Koin */
    implementation(platform(libs.koin.bom))
    implementation(libs.bundles.koin)
}