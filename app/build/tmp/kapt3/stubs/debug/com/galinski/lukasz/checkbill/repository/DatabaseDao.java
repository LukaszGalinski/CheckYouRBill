package com.galinski.lukasz.checkbill.repository;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\nH\'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\'\u00a8\u0006\u0011"}, d2 = {"Lcom/galinski/lukasz/checkbill/repository/DatabaseDao;", "", "addItem", "", "newBill", "Lcom/galinski/lukasz/checkbill/repository/BillDatabase;", "getAllItems", "", "getItemsWithDate", "date", "", "getItemsWithDateRange", "startDate", "endDate", "removeItem", "id", "", "app_debug"})
public abstract interface DatabaseDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM BillDatabase WHERE dateString LIKE:date")
    public abstract java.util.List<com.galinski.lukasz.checkbill.repository.BillDatabase> getItemsWithDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date);
    
    @androidx.room.Insert()
    public abstract void addItem(@org.jetbrains.annotations.NotNull()
    com.galinski.lukasz.checkbill.repository.BillDatabase newBill);
    
    @androidx.room.Query(value = "DELETE FROM BillDatabase WHERE id LIKE :id")
    public abstract void removeItem(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM BillDatabase WHERE dateString>= :startDate AND dateString<= :endDate")
    public abstract java.util.List<com.galinski.lukasz.checkbill.repository.BillDatabase> getItemsWithDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM BillDatabase")
    public abstract java.util.List<com.galinski.lukasz.checkbill.repository.BillDatabase> getAllItems();
}