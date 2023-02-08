package xyz.myeoru.realtimesubway.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideRealTimeStationArrivalApi() = ApiHelper.create(
        ReaTimeStationArrivalApi::class.java,
        "http://swopenAPI.seoul.go.kr"
    )

    @Singleton
    @Provides
    fun provideKakaoRestApi() = ApiHelper.create(
        KakaoRestApi::class.java,
        "https://dapi.kakao.com",
        listOf(Pair("Authorization", BuildConfig.KAKAO_REST_API_KEY))
    )
}
