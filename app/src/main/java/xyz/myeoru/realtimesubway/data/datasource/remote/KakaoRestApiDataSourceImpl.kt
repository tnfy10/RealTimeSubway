package xyz.myeoru.realtimesubway.data.datasource.remote

import kotlinx.coroutines.flow.flow
import xyz.myeoru.realtimesubway.data.api.KakaoRestApi
import xyz.myeoru.realtimesubway.data.entity.KakaoCategorySearchResultEntity
import javax.inject.Inject

class KakaoRestApiDataSourceImpl @Inject constructor(private val api: KakaoRestApi) :
    KakaoRestApiDataSource {
    override suspend fun searchCategoryLocation(
        categoryGroupCode: String,
        longitude: Double,
        latitude: Double,
        radius: Int,
        page: Int,
        size: Int,
        sort: String
    ) = flow {
        val resp = api.searchCategoryLocation(
            categoryGroupCode,
            longitude,
            latitude,
            radius,
            page,
            size,
            sort
        )

        val data = resp.body() ?: throw Throwable("서버에서 받아온 데이터가 null임.")

        if (resp.isSuccessful) {
            emit(data)
        } else {
            throw Throwable("서버에서 데이터를 받아올 수 없음.")
        }
    }
}
