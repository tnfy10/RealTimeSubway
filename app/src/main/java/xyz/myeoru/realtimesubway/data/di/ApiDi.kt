package xyz.myeoru.realtimesubway.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.data.ApiHelper
import xyz.myeoru.realtimesubway.data.api.ReaTimeStationArrivalApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiDi {
    @Singleton
    @Provides
    fun provideSubwayApi() = ApiHelper.create(
        "http://swopenAPI.seoul.go.kr",
        ReaTimeStationArrivalApi::class.java
    )
}
