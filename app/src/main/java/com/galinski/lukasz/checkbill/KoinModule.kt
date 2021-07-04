package com.galinski.lukasz.checkbill

import android.app.Application
import androidx.room.Room
import com.galinski.lukasz.checkbill.presentation.MainViewModel
import com.galinski.lukasz.checkbill.repository.AppDatabase
import com.galinski.lukasz.checkbill.repository.DATABASE_NAME
import com.galinski.lukasz.checkbill.repository.DatabaseDao
import org.koin.dsl.module

val mainModule = module{
    single { MainViewModel(get()) }
}

val databaseModule = module{
    single { createDatabase(get()) }
    single { provideDatabaseDao(get()) }
}

private fun createDatabase(application: Application): AppDatabase{
    return Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME).build()
}

private fun provideDatabaseDao(database: AppDatabase): DatabaseDao{
    return database.billsDao()
}