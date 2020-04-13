package api

import kotlinext.js.jsObject
import kotlin.js.Promise

data class PlaceResponse (
    val numberOfDeaths: Number,
    val numberOfConfirmed: Number,
    val numberOfRecovered: Number,
    val nameOfThePlace: String
)

fun getConfigObj(apiUrl: String): AxiosConfigSettings {
    return jsObject { url = apiUrl }
}

fun getWorldData(): Promise<AxiosResponse<PlaceResponse>> {
    return axios(getConfigObj(worldDataApi));
}

fun getStateData(stateName: String): Promise<AxiosResponse<PlaceResponse>> {
    return axios(getConfigObj(stateData(stateName)));
}

fun getCountryData(countryName: String): Promise<AxiosResponse<PlaceResponse>> {
    return axios(getConfigObj(countryData(countryName)));
}