package com.example.smartlight.di

import com.example.smartlight.data.network.PhillipsHueApiService
import com.example.smartlight.domain.use_case.GetLightListUC
import com.example.smartlight.domain.use_case.PostLightUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetBookListUC(
        phillipsHueApiService: PhillipsHueApiService,
    ): GetLightListUC {
        return GetLightListUC(
            phillipsHueApiService = phillipsHueApiService,
        )
    }

    @ViewModelScoped
    @Provides
    fun providePostLightUC(
        phillipsHueApiService: PhillipsHueApiService,
    ): PostLightUC {
        return PostLightUC(
            phillipsHueApiService = phillipsHueApiService,
        )
    }
}