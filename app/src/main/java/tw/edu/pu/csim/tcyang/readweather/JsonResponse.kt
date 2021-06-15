package tw.edu.pu.csim.tcyang.readweather

import com.google.gson.annotations.SerializedName

class JsonResponse {
    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("sys")
    var sys: Sys? = null
    @SerializedName("weather")
    var weather = ArrayList<Weather>()
    @SerializedName("main")
    var main: Main? = null
}

class Coord {
    @SerializedName("lon")
    var lon: Float = 0.toFloat()
    @SerializedName("lat")
    var lat: Float = 0.toFloat()
}

class Sys {
    @SerializedName("country")
    var country: String? = null
}

class Weather {
    @SerializedName("description")
    var description: String? = null
}

class Main {
    @SerializedName("temp")
    var temp: Float = 0.toFloat()
    @SerializedName("temp_min")
    var temp_min: Float = 0.toFloat()
    @SerializedName("temp_max")
    var temp_max: Float = 0.toFloat()
}