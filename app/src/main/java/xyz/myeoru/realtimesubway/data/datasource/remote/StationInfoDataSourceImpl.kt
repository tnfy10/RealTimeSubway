package xyz.myeoru.realtimesubway.data.datasource.remote

import xyz.myeoru.realtimesubway.data.api.ReaTimeStationArrivalApi
import xyz.myeoru.realtimesubway.data.entity.StationInfoEntity
import javax.inject.Inject

class StationInfoDataSourceImpl @Inject constructor(private val api: ReaTimeStationArrivalApi) :
    StationInfoDataSource {

    override suspend fun getRealTimeStationArrival(
        apiKey: String,
        startIdx: Int,
        endIdx: Int,
        stationName: String
    ): Result<StationInfoEntity> {
        val resp = api.getRealTimeStationArrival(apiKey, startIdx, endIdx, stationName)

        val data = resp.body() ?: return Result.failure(Throwable("서버에서 받아온 데이터가 null임."))

        return if (resp.isSuccessful) {
            Result.success(data)
        } else {
            Result.failure(Throwable("서버에서 데이터를 받아올 수 없음."))
        }
    }
}
