package com.galinski.lukasz.checkbill.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BillDatabase(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "dateString") var dateString: String?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "amount") val amount: Int?
 )

