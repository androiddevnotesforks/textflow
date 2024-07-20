plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.mavenpublish)
    id("convention.jvm.toolchain")
}

android {
    namespace = "eu.wewox.textflow.material3"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs +
                "-Xexplicit-api=strict" +
                "-Xopt-in=androidx.compose.ui.text.ExperimentalTextApi"
    }
}

dependencies {
    implementation(project(":textflow-common"))

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}