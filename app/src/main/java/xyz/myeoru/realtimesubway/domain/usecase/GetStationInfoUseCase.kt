package xyz.myeoru.realtimesubway.domain.usecase

import kotlinx.coroutines.flow.flow
import xyz.myeoru.realtimesubway.domain.repository.StationInfoRepository
import javax.inject.Inject

class GetStationInfoUseCase @Inject constructor(private val repository: StationInfoRepository) {

    suspend fun getStationInfo(startIdx: Int, endIdx: Int, stationName: String) = flow {
        val data = repository.getRealTimeSubwayInfo(startIdx, endIdx, stationName)
        emit(data)
    }
}
