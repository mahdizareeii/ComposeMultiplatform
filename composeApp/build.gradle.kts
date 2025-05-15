import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {

    //add this into your gradle properties to avoid getting the following error
    //Incompatible 'embedAndSign' Task with Pod Dependencies
    //kotlin.apple.deprecated.allowUsingEmbedAndSignWithCocoaPodsDependencies=true

    //navigate to ios app of the project and do these commands
    //pod init
    //pod install
    cocoapods {
        version = "1.0.0"
        summary = "Shared framework for KMP app"
        homepage = ""
        //should be equal with
        //# platform :ios, '15.3' in Podfile and
        //ios minimum deployment in xcode
        //spec.ios.deployment_target in composeApp.podspec in the project
        ios.deploymentTarget = "15.3"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "SharedFramework"

            // Optional properties
            // Specify the framework linking type. It's dynamic by default.
            isStatic = false
            // Dependency export
            // Uncomment and specify another project module if you have one:
            // export(project(":<your other KMP module>"))
            //transitiveExport = false // This is default.
        }

        // Maps custom Xcode configuration to NativeBuildType
        //xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = NativeBuildType.DEBUG
        //xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = NativeBuildType.RELEASE


        pod("GoogleMaps") {
            version = "6.1.0"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.maps.compose)
            implementation(libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.koin.android.compose)
            implementation(libs.koin.android.viewmodel)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.content.negotiation)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }

    androidTarget { compilerOptions { jvmTarget.set(JvmTarget.JVM_11) } }
}

compose.resources {
    publicResClass = false
    packageOfResClass = libs.plugins.libsPackageName.get().pluginId + "resources"
    generateResClass = auto
}

android {
    namespace = libs.plugins.libsPackageName.get().pluginId
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.plugins.libsPackageName.get().pluginId
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    debugImplementation(compose.uiTooling)
}

