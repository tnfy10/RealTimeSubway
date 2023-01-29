package xyz.myeoru.realtimesubway.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import xyz.myeoru.realtimesubway.domain.model.StationInfoModel
import xyz.myeoru.realtimesubway.domain.usecase.GetStationInfoUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getStationInfoUseCase: GetStationInfoUseCase) :
    ViewModel() {
    private val _stationInfo = MutableLiveData<StationInfoModel>()
    val stationInfo: LiveData<StationInfoModel>
        get() = _stationInfo

    private var receiveStationInfoJob: Job? = null

    private fun setReceiveStationInfoJob(stationName: String, startIdx: Int = 0, endIdx: Int = 5) {
        receiveStationInfoJob = viewModelScope.launch {
            while (true) {
                getStationInfoUseCase.getStationInfo(
                    startIdx,
                    endIdx,
                    stationName
                ).catch {
                    Log.e(javaClass.simpleName, it.message.toString())
                }.collect {
                    _stationInfo.postValue(it)
                }
                delay(5000)
            }
        }
    }

    fun startReceiveStationInfoJob(stationName: String) {
        if (receiveStationInfoJob == null) {
            setReceiveStationInfoJob(stationName)
        }
    }

    fun stopReceiveStationInfoJob() {
        if (receiveStationInfoJob != null) {
            receiveStationInfoJob!!.cancel()
            receiveStationInfoJob = null
        }
    }
}
