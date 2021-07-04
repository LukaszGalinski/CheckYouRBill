package com.galinski.lukasz.checkbill.repository

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "billDatabase"

@Database(entities = [BillDatabase::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun billsDao() : DatabaseDao
}