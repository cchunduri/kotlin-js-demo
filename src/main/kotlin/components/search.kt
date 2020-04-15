import components.appHeader
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.header
import styled.styledDiv

class Search:RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        appHeader()
        styledDiv {
            +"Search"
        }
    }
}

fun RBuilder.search() = child(Search::class) {}