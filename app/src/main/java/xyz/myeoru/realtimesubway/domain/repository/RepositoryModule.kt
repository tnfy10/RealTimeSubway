package xyz.myeoru.realtimesubway.domain.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsStationInfoRepository(stationInfoRepositoryImpl: StationInfoRepositoryImpl): StationInfoRepository
}
