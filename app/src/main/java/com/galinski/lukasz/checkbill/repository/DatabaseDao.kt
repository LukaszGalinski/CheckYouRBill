package com.galinski.lukasz.checkbill.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao{

    @Query("SELECT * FROM BillDatabase WHERE dateString LIKE:date")
    fun getItemsWithDate(date: String)

    @Insert
    fun addItem(newBill: BillDatabase)

    @Query("DELETE FROM BillDatabase WHERE id LIKE :id")
    fun removeItem(id: Long)

    @Query("SELECT * FROM BillDatabase WHERE dateString>= :startDate AND dateString<= :endDate")
    fun getItemsWithDateRange(startDate: String, endDate: String)
}