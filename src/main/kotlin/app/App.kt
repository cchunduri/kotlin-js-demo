package app

import appBody
import components.appHeader
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class App:RComponent<RProps, RState> () {
    override fun RBuilder.render() {
        appHeader()
        appBody()
    }
}

fun RBuilder.app() = child(App::class) {}