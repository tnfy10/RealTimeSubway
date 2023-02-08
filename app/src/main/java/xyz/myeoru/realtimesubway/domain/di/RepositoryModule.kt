package xyz.myeoru.realtimesubway.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.domain.repository.StationInfoRepository
import xyz.myeoru.realtimesubway.domain.repository.StationInfoRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsStationInfoRepository(stationInfoRepositoryImpl: StationInfoRepositoryImpl): StationInfoRepository
}
