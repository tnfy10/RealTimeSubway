package xyz.myeoru.realtimesubway.data.model

data class SubwayModel(
    val subwayId: String, // 지하철호선ID
    val updnLine: String, // 상하행선 구분 - 2호선 : (내선:0,외선:1),상행,하행
    val trainLineNm: String, // 도착지방면
    val subwayHeading: String, // 내리는문 방향 - 오른쪽,왼쪽
    val statnFid: String, // 이전지하철역ID
    val statnTid: String, // 다음지하철역ID
    val statnId: String, // 지하철역ID
    val statnNm: String, // 지하철역명
    val tmsitCo: Int, // 환승노선수
)
