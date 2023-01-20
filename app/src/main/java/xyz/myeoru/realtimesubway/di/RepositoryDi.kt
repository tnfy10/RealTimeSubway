package xyz.myeoru.realtimesubway.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.data.api.SubwayApi
import xyz.myeoru.realtimesubway.data.repository.SubwayRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryDi {
    @Singleton
    @Provides
    fun provideSubwayRepository(api: SubwayApi) = SubwayRepository(api)
}
