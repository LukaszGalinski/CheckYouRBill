package com.galinski.lukasz.checkbill.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.galinski.lukasz.checkbill.repository.AppDatabase
import com.galinski.lukasz.checkbill.repository.BillDatabase
import com.galinski.lukasz.checkbill.repository.DatabaseDao
import com.galinski.lukasz.checkbill.repository.OperationType
import com.galinski.lukasz.checkbill.shared.BaseViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(private val databaseDao: DatabaseDao):  BaseViewModel(){
    private val incomeMutable = MutableLiveData<Long>(0)
    private val expensesMutable = MutableLiveData<Long>(0)

    val income: LiveData<Long> = incomeMutable
    val expenses: LiveData<Long> = expensesMutable
    val list = ArrayList<BillDatabase>()
    fun createEndDate(): Calendar {
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)
        return endDate
    }

    fun createStartDate(): Calendar{
        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)
        return startDate
    }

    private fun loadDatabaseRowsWithDateRangeImplementation(){
        list.add(BillDatabase(id = 0, "23", "Ar", 150.toDouble(),2,
            OperationType.INCOME, "inne"))
        list.add(BillDatabase(id = 1, "23", "Ar", 250.toDouble(),4,
            OperationType.INCOME, "inne"))
        list.add(BillDatabase(id = 2, "23", "Ar", 500.toDouble(),5,
            OperationType.OUTCOME, "inne"))
        list.add(BillDatabase(id = 3, "23", "Ar", 600.toDouble(),6,
            OperationType.INCOME, "inne"))
        var money = 0.toDouble()
        var iterator = 0
        list.forEach {
            if (it.operationType == OperationType.INCOME){
                money += it.value!!
                iterator++
            }
        }.let {
            apply { incomeMutable.value = money.div(iterator).toLong()} }
    }

    fun loadDatabaseRowsWithDateRange(){
        loadDatabaseRowsWithDateRangeImplementation().apply {
            Observable.fromCallable {
                databaseDao.addItem(list[0])
                databaseDao.addItem(list[1])
                databaseDao.addItem(list[2])
                databaseDao.addItem(list[3])
            }
                .subscribeOn(Schedulers.io())
                .doOnError{
                    println(it.message)
                }
                .subscribe()
        }
    }

    fun testRemove(){
        Observable.fromCallable {
            databaseDao.getIncomeAndOutcome()
        }
            .subscribeOn(Schedulers.io())
            .doOnNext {
                println("TWOJA: ${it}")
            }
            .subscribe()

    }
}