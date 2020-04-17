package components

import api.PlaceResponse
import api.getCountryData
import api.getStateData
import api.getWorldData
import kotlinx.css.*
import react.*
import styled.*
import kotlin.random.Random

interface SectionState : RState {
    var placeData: PlaceResponse
}

interface SectionProps : RProps {
    var title: String
    var isState: Boolean
    var isCountry: Boolean
}

class Section(props: SectionProps) : RComponent<SectionProps, SectionState>(props) {

    override fun componentWillMount() {

        if (props.title != undefined) {
            if (props.title == "World") {
                getWorldData().then { res ->
                    setState {
                        this.placeData = res.data
                    }
                }
            } else if (props.isState) {
                getStateData(props.title).then { res ->
                    setState {
                        this.placeData = res.data
                    }
                }
            } else if (props.isCountry){
                getCountryData(props.title).then { res ->
                    setState {
                        this.placeData = res.data
                    }
                }
            }
        }
    }

    override fun RBuilder.render() {
        val placeResponse = getResponse();
        if (placeResponse != undefined) {
            styledDiv {

                css {
                    width = 50.pct
                    height = 100.pct
                    paddingLeft = 10.pct
                    paddingTop = 5.pct
                    color = Color.white
                    backgroundColor = generateColor();
                }

                styledH1 {
                    +props.title
                }

                styledH2 {
                    +"Number of Recovered ${placeResponse.numberOfRecovered}"
                }

                styledH3 {
                    +"Number of Confirmed ${placeResponse.numberOfConfirmed}"
                }

                styledSpan {
                    +"Number of Deaths ${placeResponse.numberOfDeaths}"
                }
            }
        }
    }

    private fun getResponse(): PlaceResponse {
        if (props.isState) {
            return state.placeData
        } else if (props.isCountry) {
            return state.placeData
        } else {
            return state.placeData
        }
    }

    fun generateColor(): Color {
        val VALUES = arrayOf(
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
        )
        val color = StringBuilder("#")
        for (i in 0..5) {
            val value = VALUES[Random.nextInt(VALUES.size)]
            color.append(value)
        }

        return Color(color.toString());
    }
}

fun RBuilder.appSection(handler: SectionProps.() -> Unit): ReactElement {
    return child(Section::class) {
        this.attrs(handler)
    }
}