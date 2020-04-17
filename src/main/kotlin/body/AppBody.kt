import components.appSection
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import styled.StyleSheet
import styled.css
import styled.styledDiv

class AppBody : RComponent<RProps, RState>() {
    object ComponentStyles : StyleSheet("ComponentStyles") {
        val diSectionContainer by css {
            display = Display.flex
            flexDirection = FlexDirection.row
            height = 50.vh
        }
    }

    override fun RBuilder.render() {
        div {

            styledDiv {
                css {
                    +ComponentStyles.diSectionContainer
                }
//                appSection {
//                    title = "World"
//                    isState = false
//                    isCountry = false
//                }

                appSection {
                    title = "India"
                    isState = false
                    isCountry = true
                }
            }


            styledDiv{
                css {
                    +ComponentStyles.diSectionContainer
                }
                appSection {
                    title = "Telengana"
                    isState = true
                    isCountry = false
                }

                appSection {
                    title = "Andhra Pradesh"
                    isState = true
                    isCountry = false
                }
            }
        }
    }

}


fun RBuilder.appBody() = child(AppBody::class) {}
