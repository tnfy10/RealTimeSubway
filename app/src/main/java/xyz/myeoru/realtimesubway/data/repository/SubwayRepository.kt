package xyz.myeoru.realtimesubway.data.repository

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import xyz.myeoru.realtimesubway.BuildConfig
import xyz.myeoru.realtimesubway.data.api.SubwayApi

class SubwayRepository(private val api: SubwayApi) {
    private val TAG = this.javaClass.name

    fun fetchSubwayCurrentLocation(startIdx: Int, endIdx: Int, stationName: String) =
        flow {
            while (true) {
                val resp = api.getRealTimeStationArrival(
                    BuildConfig.API_KEY,
                    startIdx,
                    endIdx,
                    stationName
                )

                if (!resp.isSuccessful) {
                    Log.e(
                        TAG,
                        "실시간 지하철 정보를 불러오는데 실패 [Status Code: ${resp.code()}] [Error: ${resp.errorBody()}]"
                    )
                    delay(5000)
                    continue
                }

                val data = resp.body()

                if (data == null) {
                    Log.e(
                        TAG, "실시간 지하철 정보가 NULL임. [Body: ${
                            resp.body().toString()
                        }]"
                    )
                    delay(5000)
                    continue
                }

                emit(data)
                delay(10000)
            }
        }
}
