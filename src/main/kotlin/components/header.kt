package components

import kotlinx.css.paddingBottom
import kotlinx.css.paddingTop
import kotlinx.css.px
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.navLink
import styled.*

class Header: RComponent<RProps, RState> () {
    override fun RBuilder.render() {
        styledNav {
            attrs {
                classes = setOf("navbar", "navbar-expand-lg", "navbar-light", "bg-light");
            }
            css {
                paddingTop = 10.px
                paddingBottom = 10.px
            }
            navLink("/", className = "nav-link") {
                + "Covid Dashboard"
            }

            styledUl {
                attrs {
                    classes = setOf("navbar-nav", "mr-auto mt-2", "mt-lg-0");
                }

                styledLi {
                    attrs {
                        classes = setOf("nav-item active");
                    }
                    navLink("search", className = "nav-link") {
                        +"Search"
                    }
                }
            }
        }
    }
}

fun RBuilder.appHeader() = child(Header::class) {}