package xyz.myeoru.realtimesubway.domain.repository

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubway.domain.model.StationInfoModel

interface StationInfoRepository {
    suspend fun getRealTimeSubwayInfo(
        startIdx: Int,
        endIdx: Int,
        stationName: String
    ): Flow<StationInfoModel>
}