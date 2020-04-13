package api

const val hostName = "https://chai-covid-dashboard.herokuapp.com";
const val worldDataApi = "$hostName/getWorldData"

val stateData = { stateName: String -> "$hostName/getLatestByState/${stateName}" }
val countryData = { countryName: String -> "$hostName/getLatestByCountry/${countryName}" }