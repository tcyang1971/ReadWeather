package tw.edu.pu.csim.tcyang.readweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonService {
    @GET("data/2.5/weather?")
    fun getJsonData(@Query("q") City: String,
                              @Query("appid") AppId: String,
                              @Query("units") Units: String,
                              @Query("lang") Lang: String): Call<JsonResponse>
}