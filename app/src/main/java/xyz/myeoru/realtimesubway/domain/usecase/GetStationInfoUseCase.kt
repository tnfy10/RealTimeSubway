package xyz.myeoru.realtimesubway.domain.usecase

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import xyz.myeoru.realtimesubway.domain.repository.StationInfoRepositoryImpl
import javax.inject.Inject

class GetStationInfoUseCase @Inject constructor(private val repository: StationInfoRepositoryImpl) {

    suspend fun getStationInfo(startIdx: Int, endIdx: Int, stationName: String) = flow {
        repository.getRealTimeSubwayInfo(startIdx, endIdx, stationName).catch {
            throw it
        }.collect {
            emit(it)
        }
    }
}
