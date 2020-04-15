import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.COMMONJS
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    id("org.jetbrains.kotlin.js") version "1.3.71"
}

group = "com.chai.kjs"
version = "1.0-SNAPSHOT"

val kotlin_react_version = "16.13.0-pre.94-kotlin-1.3.70"
val kotlin_version = "pre.94-kotlin-1.3.70"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains.kotlinx:kotlinx-html:0.6.12")
    implementation("org.jetbrains:kotlin-react:16.13.0-$kotlin_version")
    implementation("org.jetbrains:kotlin-react-dom:16.13.0-$kotlin_version")
    implementation("org.jetbrains:kotlin-react-router-dom:4.3.1-$kotlin_version")
    implementation("org.jetbrains:kotlin-styled:1.0.0-$kotlin_version")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-$kotlin_version")
    implementation("org.jetbrains:kotlin-css-js:1.0.0-$kotlin_version")

    implementation(npm("react", "16.13.0"))
    implementation(npm("react-dom", "16.13.0"))
    implementation(npm("react-router-dom", "5.1.2"))
    implementation(npm("react-is", "16.13.0"))
    implementation(npm("inline-style-prefixer", "5.1.0"))
    implementation(npm("styled-components", "4.3.2"))

    implementation(npm("axios", "^0.19.2"))
    implementation(npm("bootstrap", "^4.4.1"))
    implementation(npm("jquery", "^3.4.1"))

    implementation(npm("css-loader", "3.5.2"))
    implementation(npm("style-loader", "1.1.3"))
    implementation(npm("file-loader", "6.0.0"))

    implementation(npm("karma", "4.4.1"))
}

kotlin.target {
    useCommonJs()
    nodejs()
    browser {
        runTask {
            devServer = KotlinWebpackConfig.DevServer(
                port = 3000,
                contentBase = listOf("$buildDir/processedResources/Js/main")
            )
        }

        webpackTask {
            output.libraryTarget = COMMONJS
        }
    }
}