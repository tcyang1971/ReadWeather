package tw.edu.pu.csim.tcyang.readweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var BaseUrl = "http://api.openweathermap.org/"
    var AppId = "2e65127e909e178d0af311a81f39948c"
    //var City = "Taichung"
    var City = "Tokyo"
    var Units = "metric"
    var Lang = "zh_tw"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{ ReadData() }
    }

    fun ReadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JsonService::class.java)
        val call = service.getJsonData(City, AppId, Units, Lang)

        call.enqueue(object : Callback<JsonResponse> {
            override fun onResponse(call: Call<JsonResponse>, response: Response<JsonResponse>) {
                if (response.code() == 200) {
                    val Result = response.body()!!
                    var msg = City + " (國家：" + Result.sys?.country + ")"
                    msg += "\n經度：" + Result.coord?.lon.toString()
                    msg += "\n緯度：" + Result.coord?.lat.toString()

                    msg += "\n\n天氣：" + Result.weather[0].description
                    msg += "\n溫度：" + Result.main?.temp.toString()
                    msg += "\n最低溫：" + Result.main?.temp_min.toString()
                    msg += "\n最高溫：" + Result.main?.temp_max.toString()
                    txv.text = msg
                }
                else{
                    txv.text = "找不到檔案"
                }
            }

            override fun onFailure(call: Call<JsonResponse>, t: Throwable) {
                txv.text = t.message
            }
        })
    }

}