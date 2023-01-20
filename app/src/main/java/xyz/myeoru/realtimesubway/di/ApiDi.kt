package xyz.myeoru.realtimesubway.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubway.data.ApiHelper
import xyz.myeoru.realtimesubway.data.api.SubwayApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiDi {
    @Singleton
    @Provides
    fun provideSubwayApi() = ApiHelper.create(
        "http://swopenAPI.seoul.go.kr",
        SubwayApi::class.java
    )
}
