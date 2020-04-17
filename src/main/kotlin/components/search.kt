import api.PlaceResponse
import api.getCountryData
import components.appHeader
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import styled.styledDiv
import styled.styledInput
import styled.styledP

interface SearchState: RState {
    var searchInput : String
    var placeData : PlaceResponse?
}

class Search:RComponent<RProps, SearchState>() {
    override fun RBuilder.render() {
        appHeader()
        styledDiv {
            styledInput {
                attrs {
                    type = InputType.text
                    placeholder = "Enter Country Name"
                    value = state.searchInput
                    onChangeFunction = { event ->
                        handleChange(event)
                    }
                }
            }

            if (state.placeData !=null) {
                styledDiv {
                    styledP {
                        + "Country: ${state.placeData?.nameOfThePlace}"
                    }
                    styledP {
                        + "Deaths: ${state.placeData?.numberOfDeaths}"
                    }
                    styledP {
                        + "Recovered: ${state.placeData?.numberOfRecovered}"
                    }
                    styledP {
                        + "Confirmed: ${state.placeData?.numberOfConfirmed}"
                    }
                }
            }
        }
    }

    private fun handleChange(event: Event) {
        val target = event.target as HTMLInputElement
        if (target.value.length > 3) {
            getCountryData(target.value).then { res ->
                setState {
                    this.placeData = res.data
                }
            }.catch { error -> console.error(error) }
        }
    }
}

fun RBuilder.search() = child(Search::class) {}