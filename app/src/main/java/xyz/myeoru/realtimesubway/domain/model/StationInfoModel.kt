package xyz.myeoru.realtimesubway.domain.model

import xyz.myeoru.realtimesubway.data.entity.RealtimeArrival

data class StationInfoModel (
    val realtimeArrivalList: List<RealtimeArrival>
)
