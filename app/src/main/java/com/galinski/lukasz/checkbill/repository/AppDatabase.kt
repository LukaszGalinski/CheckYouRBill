package com.galinski.lukasz.checkbill.repository

import androidx.room.Database
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "billDatabase"

@Database(entities = [BillDatabase::class], version = 1, exportSchema = false)
abstract class AppBillsDatabase : RoomDatabase(){
    abstract fun billsDao() : DatabaseDao
}