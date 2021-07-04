package com.galinski.lukasz.checkbill.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao{

 //   @Query("SELECT * FROM BillDatabase WHERE dateString LIKE:date")
  //  fun getItemsWithDate(date: String)

    //@Query("SELECT value FROM BILLDATABASE WHERE dateString BETWEEN :st")
    //fun getIncomeAndOutcome(startDate: String, endDate:String)

    @Query("SELECT avg(price) as averageAmount,avg(amount) as average FROM BILLDATABASE WHERE operationType like :operationType")
    fun getIncomeAndOutcome(operationType: OperationType): ez

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(newBill: BillDatabase)

    @Query("DELETE FROM BillDatabase WHERE id LIKE :id")
    fun removeItem(id: Long)

   // @Query("SELECT * FROM BillDatabase WHERE dateString>= :startDate AND dateString<= :endDate")
   // fun getItemsWithDateRange(startDate: String, endDate: String)
}