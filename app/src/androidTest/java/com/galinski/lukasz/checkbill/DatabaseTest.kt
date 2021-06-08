package com.galinski.lukasz.checkbill

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.galinski.lukasz.checkbill.repository.AppBillsDatabase
import com.galinski.lukasz.checkbill.repository.DatabaseDao
import junit.framework.Assert.assertTrue
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class EntityWriteAndDeleteTest {
    private lateinit var testDao: DatabaseDao
    private lateinit var testDatabase: AppBillsDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        testDatabase = Room.inMemoryDatabaseBuilder(context, AppBillsDatabase::class.java).build()
        testDao = testDatabase.billsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        testDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun entityWriteAndReadElementTest(){
        val testUser1 = TestUtilities.createTestUsers(1).apply {
            get(0).name = "Albert"
        }
        testDao.addItem(testUser1[0])
        val readUser = testDao.getAllItems()
        assertThat(testUser1[0].name, equalTo(readUser[0].name))
    }

    @Test
    @Throws(Exception::class)
    fun entityDeleteTest(){
        val testUser = TestUtilities.createTestUsers(1)
        testDao.addItem(testUser[0])
        var readUser = testDao.getAllItems()
        val addedElementSuccess = readUser.size == 1
        testDao.removeItem(1)
        readUser = testDao.getAllItems()
        val removingElementSuccess = readUser.isEmpty()
        assertThat(addedElementSuccess, equalTo(removingElementSuccess))
    }
}