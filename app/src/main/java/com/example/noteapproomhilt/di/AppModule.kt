package com.example.noteapproomhilt.di

import android.app.Application
import android.content.Context
import com.example.noteapproomhilt.db.AppDao
import com.example.noteapproomhilt.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context: Application) : AppDatabase{
        return AppDatabase.getAppDB(context)
    }
    @Singleton
    @Provides
    fun getDao(appDb: AppDatabase) : AppDao{
        return appDb.getDao()
    }


}