package xyz.myeoru.realtimesubway.data.datasource.remote

import xyz.myeoru.realtimesubway.data.entity.KakaoCategorySearchResultEntity

interface KakaoRestApiDataSource {
    suspend fun searchCategoryLocation(
        categoryGroupCode: String,
        longitude: Double,
        latitude: Double,
        radius: Int,
        page: Int = 1,
        size: Int = 15,
        sort: String = "distance"
    ): Result<KakaoCategorySearchResultEntity>
}
