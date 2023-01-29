package xyz.myeoru.realtimesubway.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import xyz.myeoru.realtimesubway.data.entity.StationInfoEntity

interface ReaTimeStationArrivalApi {
    @GET("/api/subway/{apiKey}/json/realtimeStationArrival/{startIdx}/{endIdx}/{stationName}")
    suspend fun getRealTimeStationArrival(
        @Path("apiKey") apiKey: String,
        @Path("startIdx") startIdx: Int,
        @Path("endIdx") endIdx: Int,
        @Path("stationName") stationName: String
    ): Response<StationInfoEntity>
}
