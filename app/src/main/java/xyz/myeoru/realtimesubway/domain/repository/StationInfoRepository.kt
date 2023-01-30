package xyz.myeoru.realtimesubway.domain.repository

import xyz.myeoru.realtimesubway.BuildConfig
import xyz.myeoru.realtimesubway.data.datasource.remote.StationInfoDataSourceImpl
import xyz.myeoru.realtimesubway.domain.model.StationInfoModel
import javax.inject.Inject

class StationInfoRepository @Inject constructor(private val dataSourceImpl: StationInfoDataSourceImpl) {

    suspend fun getRealTimeSubwayInfo(
        startIdx: Int,
        endIdx: Int,
        stationName: String
    ) : StationInfoModel {
        val result = dataSourceImpl.getRealTimeStationArrival(
            BuildConfig.STATION_INFO_API_KEY,
            startIdx,
            endIdx,
            stationName
        )

        val data = result.getOrThrow()

       return StationInfoModel(data.realtimeArrivalList)
    }
}
