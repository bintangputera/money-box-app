plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.bintangpoetra.moneybox"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bintangpoetra.moneybox"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
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

    //  MVVM
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    //  Fragment
    implementation("androidx.fragment:fragment-ktx:1.5.2")

    //  Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    //  Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.1")

    // Koin
    implementation("io.insert-koin:koin-core:3.2.0")
    implementation("io.insert-koin:koin-android:3.2.0")
    implementation("io.insert-koin:koin-androidx-compose:3.2.0")

    // Retrofit
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //   Ok Http
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Circle Image View
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.13.1")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Shimmer
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    // Coil
    implementation("io.coil-kt:coil-compose:2.2.2")


    implementation("androidx.room:room-runtime:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}