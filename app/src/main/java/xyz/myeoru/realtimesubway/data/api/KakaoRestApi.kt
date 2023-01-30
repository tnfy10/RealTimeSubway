package xyz.myeoru.realtimesubway.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.myeoru.realtimesubway.data.entity.KakaoCategorySearchResultEntity

interface KakaoRestApi {
    @GET("/v2/local/search/category.json")
    suspend fun searchCategoryLocation(
        @Query("category_group_code") categoryGroupCode: String,
        @Query("x") longitude: Double,
        @Query("y") latitude: Double,
        @Query("radius") radius: Int,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("sort") sort: String
    ): Response<KakaoCategorySearchResultEntity>
}
