package xyz.myeoru.realtimesubway.domain.repository

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import xyz.myeoru.realtimesubway.BuildConfig
import xyz.myeoru.realtimesubway.data.datasource.remote.StationInfoDataSource
import xyz.myeoru.realtimesubway.domain.model.StationInfoModel
import javax.inject.Inject

class StationInfoRepositoryImpl @Inject constructor(private val dataSourceImpl: StationInfoDataSource) :
    StationInfoRepository {

    override suspend fun getRealTimeSubwayInfo(
        startIdx: Int,
        endIdx: Int,
        stationName: String
    ) = flow {
        dataSourceImpl.getRealTimeStationArrival(
            BuildConfig.STATION_INFO_API_KEY,
            startIdx,
            endIdx,
            stationName
        ).catch {
            throw it
        }.collect {
            emit(StationInfoModel(it.realtimeArrivalList))
        }
    }
}
