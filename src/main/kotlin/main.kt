import app.app
import kotlinext.js.requireAll
import kotlinext.js.require
import react.dom.render
import kotlin.browser.document

fun main() {
    document.bgColor = "lightblue"

    render(document.getElementById("root")) {
        app()
    }
}