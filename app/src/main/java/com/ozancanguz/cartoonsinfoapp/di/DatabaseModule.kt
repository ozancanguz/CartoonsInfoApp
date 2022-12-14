package com.ozancanguz.cartoonsinfoapp.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.cartoonsinfoapp.data.db.CartoonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CartoonDatabase::class.java,
        "cartoon_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: CartoonDatabase) = database.cartoonDao()

}
