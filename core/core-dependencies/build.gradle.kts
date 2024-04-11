plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.google.ksp)
}

android {
    namespace = "app.core.dependencies"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.10"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}

dependencies {
    api("androidx.core:core-ktx:1.12.0")
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.constraintlayout:constraintlayout:2.1.4")

    api("com.google.android.material:material:1.11.0")
    api("com.google.code.gson:gson:2.10.1")

    // Room components
    api("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    api("androidx.room:room-coroutines:2.1.0-alpha04")

    //NetWork
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-moshi:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    api("com.squareup.retrofit2:converter-scalars:2.9.0")
    // http logger
    api("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.5")

    // Dependency Injection
    // implementation 'io.insert-koin:koin-core:3.0.1'
    api("io.insert-koin:koin-android:2.0.1")
    api("io.insert-koin:koin-androidx-scope:2.0.1")
    api("io.insert-koin:koin-androidx-viewmodel:2.0.1")

    //Coroutine
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //Arch Components
//    implementation 'androidx.lifecycle:lifecycle-runtime:2.5.1'
//    implementation 'androidx.lifecycle:lifecycle-common:2.5.1'
//    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'
//    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    // Glide - https://github.com/bumptech/glide
    api("com.github.bumptech.glide:glide:4.14.2")
}