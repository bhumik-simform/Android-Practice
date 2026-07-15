plugins {
    alias(libs.plugins.android.application)
    //Plugin for kotlin Serialization
    alias(libs.plugins.kotlinSerialization)
    //Plugin for kotlin Parcelize
    alias(libs.plugins.kotlinParcelize)
}

android {
    namespace = "com.example.demo5mvvmarchitecture"
    compileSdk {
        version = release(37)

    }

    defaultConfig {
        applicationId = "com.example.demo5mvvmarchitecture"
        minSdk = 33
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //Retrofit dependencies
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    //Kotlin Serialzation dependency
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}