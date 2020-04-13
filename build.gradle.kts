import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.COMMONJS

plugins {
    id("org.jetbrains.kotlin.js") version "1.3.71"
}

group = "com.chai.kjs"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains:kotlin-react:16.13.0-pre.94-kotlin-1.3.70")
    implementation("org.jetbrains:kotlin-react-dom:16.13.0-pre.94-kotlin-1.3.70")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    implementation(npm("@jetbrains/kotlin-css", "^1.0.0-pre.91"))
    implementation(npm("@jetbrains/kotlin-css-js", "^1.0.0-pre.91"))
    implementation(npm("@jetbrains/kotlin-styled", "^1.0.0-pre.91"))

    implementation(npm("inline-style-prefixer", "^6.0.0"))
    implementation(npm("styled-components", "^5.1.0"))

    implementation(npm("axios", "^0.19.2"))
    implementation(npm("bootstrap", "^4.4.1"))
    implementation(npm("jquery","^3.4.1"))

    implementation(npm("css-loader", "3.5.2"))
    implementation(npm("style-loader", "1.1.3"))

    implementation(npm("karma", "4.4.1"))
}

kotlin.target {
    useCommonJs()
    browser {
        webpackTask {
            output.libraryTarget = COMMONJS
        }
    }
}