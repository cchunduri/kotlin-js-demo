import app.app
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.document

fun main() {
    document.bgColor = "lightblue"

    render(document.getElementById("root")) {
        browserRouter {
            switch {
                route("/", exact = true) {
                    app()
                }
                route("/search") {
                    search()
                }
            }
        }
    }
}