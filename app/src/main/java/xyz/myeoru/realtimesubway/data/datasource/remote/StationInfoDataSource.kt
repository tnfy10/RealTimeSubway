package xyz.myeoru.realtimesubway.data.datasource.remote

import retrofit2.http.Path
import xyz.myeoru.realtimesubway.data.entity.StationInfoEntity

interface StationInfoDataSource {
    suspend fun getRealTimeStationArrival(
        @Path("apiKey") apiKey: String,
        @Path("startIdx") startIdx: Int,
        @Path("endIdx") endIdx: Int,
        @Path("stationName") stationName: String
    ): Result<StationInfoEntity>
}
