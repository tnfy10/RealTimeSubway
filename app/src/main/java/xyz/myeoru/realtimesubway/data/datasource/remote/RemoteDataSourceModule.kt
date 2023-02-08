package xyz.myeoru.realtimesubway.data.datasource.remote

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsStationInfoDataSource(stationInfoDataSourceImpl: StationInfoDataSourceImpl): StationInfoDataSource

    @Binds
    abstract fun bindsKakaoRestApiDataSource(kakaoRestApiDataSourceImpl: KakaoRestApiDataSourceImpl): KakaoRestApiDataSource
}
