package xyz.myeoru.realtimesubway.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.data.datasource.remote.KakaoRestApiDataSource
import xyz.myeoru.realtimesubway.data.datasource.remote.KakaoRestApiDataSourceImpl
import xyz.myeoru.realtimesubway.data.datasource.remote.StationInfoDataSource
import xyz.myeoru.realtimesubway.data.datasource.remote.StationInfoDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsStationInfoDataSource(stationInfoDataSourceImpl: StationInfoDataSourceImpl): StationInfoDataSource

    @Binds
    abstract fun bindsKakaoRestApiDataSource(kakaoRestApiDataSourceImpl: KakaoRestApiDataSourceImpl): KakaoRestApiDataSource
}
