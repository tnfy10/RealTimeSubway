package xyz.myeoru.realtimesubway.data.datasource.remote

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubway.data.entity.StationInfoEntity

interface StationInfoDataSource {
    suspend fun getRealTimeStationArrival(
        apiKey: String,
        startIdx: Int,
        endIdx: Int,
        stationName: String
    ): Flow<StationInfoEntity>
}
