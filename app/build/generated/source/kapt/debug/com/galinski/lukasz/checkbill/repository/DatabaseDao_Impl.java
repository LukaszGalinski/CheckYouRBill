package com.galinski.lukasz.checkbill.repository;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BillDatabase> __insertionAdapterOfBillDatabase;

  private final SharedSQLiteStatement __preparedStmtOfRemoveItem;

  public DatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBillDatabase = new EntityInsertionAdapter<BillDatabase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BillDatabase` (`id`,`dateString`,`name`,`price`,`amount`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BillDatabase value) {
        stmt.bindLong(1, value.getId());
        if (value.getDateString() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDateString());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPrice());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getAmount());
        }
      }
    };
    this.__preparedStmtOfRemoveItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM BillDatabase WHERE id LIKE ?";
        return _query;
      }
    };
  }

  @Override
  public void addItem(final BillDatabase newBill) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBillDatabase.insert(newBill);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeItem(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveItem.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveItem.release(_stmt);
    }
  }

  @Override
  public List<BillDatabase> getItemsWithDate(final String date) {
    final String _sql = "SELECT * FROM BillDatabase WHERE dateString LIKE?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDateString = CursorUtil.getColumnIndexOrThrow(_cursor, "dateString");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final List<BillDatabase> _result = new ArrayList<BillDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BillDatabase _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpDateString;
        if (_cursor.isNull(_cursorIndexOfDateString)) {
          _tmpDateString = null;
        } else {
          _tmpDateString = _cursor.getString(_cursorIndexOfDateString);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        final Integer _tmpAmount;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmpAmount = null;
        } else {
          _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
        }
        _item = new BillDatabase(_tmpId,_tmpDateString,_tmpName,_tmpPrice,_tmpAmount);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BillDatabase> getItemsWithDateRange(final String startDate, final String endDate) {
    final String _sql = "SELECT * FROM BillDatabase WHERE dateString>= ? AND dateString<= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDateString = CursorUtil.getColumnIndexOrThrow(_cursor, "dateString");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final List<BillDatabase> _result = new ArrayList<BillDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BillDatabase _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpDateString;
        if (_cursor.isNull(_cursorIndexOfDateString)) {
          _tmpDateString = null;
        } else {
          _tmpDateString = _cursor.getString(_cursorIndexOfDateString);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        final Integer _tmpAmount;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmpAmount = null;
        } else {
          _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
        }
        _item = new BillDatabase(_tmpId,_tmpDateString,_tmpName,_tmpPrice,_tmpAmount);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BillDatabase> getAllItems() {
    final String _sql = "SELECT * FROM BillDatabase";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDateString = CursorUtil.getColumnIndexOrThrow(_cursor, "dateString");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final List<BillDatabase> _result = new ArrayList<BillDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BillDatabase _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpDateString;
        if (_cursor.isNull(_cursorIndexOfDateString)) {
          _tmpDateString = null;
        } else {
          _tmpDateString = _cursor.getString(_cursorIndexOfDateString);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        final Integer _tmpAmount;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmpAmount = null;
        } else {
          _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
        }
        _item = new BillDatabase(_tmpId,_tmpDateString,_tmpName,_tmpPrice,_tmpAmount);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
