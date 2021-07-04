package com.galinski.lukasz.checkbill.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BillDatabase(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "dateString") val dateString: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "price") val value: Double?,
    @ColumnInfo(name = "amount") val amount: Int?,
    @ColumnInfo(name = "operationType") val operationType: OperationType,
    @ColumnInfo(name = "operationCategory") val operationCategory: String?
 )
