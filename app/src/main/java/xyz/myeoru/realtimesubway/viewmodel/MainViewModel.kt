package xyz.myeoru.realtimesubway.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import xyz.myeoru.realtimesubway.data.model.SubwayModel
import xyz.myeoru.realtimesubway.data.repository.SubwayRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: SubwayRepository) :
    ViewModel() {
    private val TAG = this.javaClass.name

    private val _subwayInfo = MutableLiveData<SubwayModel>()
    val subwayInfo: LiveData<SubwayModel>
        get() = _subwayInfo

    private lateinit var subwayCurrentLocationJob: Job

    fun startFetchSubwayCurrentLocation(stationName: String, startIdx: Int = 0, endIdx: Int = 5) {
        subwayCurrentLocationJob = viewModelScope.launch {
            repository.fetchSubwayCurrentLocation(
                startIdx,
                endIdx,
                stationName
            ).catch {
                Log.e(TAG, "${it.message}")
            }.collect {
                _subwayInfo.postValue(it)
            }
        }
    }

    fun stopFetchSubwayCurrentLocation() {
        subwayCurrentLocationJob.cancel()
    }
}
