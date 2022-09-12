package com.example.foodike.di

import android.content.Context
import com.example.foodike.data.repository.CartRepositoryImpl
import com.example.foodike.data.repository.HomeRepositoryImpl
import com.example.foodike.data.repository.LoginRepositoryImpl
import com.example.foodike.data.repository.UserDataRepositoryImpl
import com.example.foodike.domain.repository.CartRepository
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.LoginRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        @ApplicationContext context: Context
    ): LoginRepository = LoginRepositoryImpl(context = context)

    @Provides
    @Singleton
    fun providesHomeRepository(): HomeRepository = HomeRepositoryImpl()

    @Provides
    @Singleton
    fun providesUserDataRepository(
        @ApplicationContext context: Context
    ): UserDataRepository = UserDataRepositoryImpl(context = context)

    @Provides
    @Singleton
    fun providesCartRepository(): CartRepository = CartRepositoryImpl()


}