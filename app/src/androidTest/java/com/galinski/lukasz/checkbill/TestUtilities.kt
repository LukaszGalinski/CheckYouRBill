package com.galinski.lukasz.checkbill

import com.galinski.lukasz.checkbill.repository.BillDatabase

object TestUtilities{
    fun createTestUsers(testUsersNumber: Int): ArrayList<BillDatabase> {
        val usersList = arrayListOf<BillDatabase>()
        for (i in 0..testUsersNumber) {
            usersList.add(BillDatabase(i+1.toLong(),"01.01.2021", "George", 1.21, 1))
        }
        return usersList
    }
}