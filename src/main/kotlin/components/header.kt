package components

import kotlinx.css.paddingBottom
import kotlinx.css.paddingTop
import kotlinx.css.px
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv

class Header: RComponent<RProps, RState> () {
    override fun RBuilder.render() {
        styledDiv {
            css {
                paddingTop = 10.px
                paddingBottom = 10.px
            }
            attrs {
                classes = setOf("navbar", "navbar-expand-lg", "navbar-light", "bg-ligh")
            }
            + "Covid Dashboard"
        }
    }
}

fun RBuilder.appHeader() = child(Header::class) {}