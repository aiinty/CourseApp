package com.aiinty.courseapp.di

import android.app.Activity
import com.aiinty.core.navigation.AppNavigator
import com.aiinty.courseapp.MainActivity
import com.aiinty.courseapp.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun provideNavigator(activity: Activity): AppNavigator {
        return AppNavigatorImpl(activity as MainActivity)
    }
}