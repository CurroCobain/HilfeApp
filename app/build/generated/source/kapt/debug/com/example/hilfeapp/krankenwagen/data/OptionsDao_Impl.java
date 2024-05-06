package com.example.hilfeapp.krankenwagen.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OptionsDao_Impl implements OptionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Options> __insertionAdapterOfOptions;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllOptions;

  public OptionsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOptions = new EntityInsertionAdapter<Options>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `options` (`color1`,`color2`,`color3`,`fondo`,`image`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Options entity) {
        statement.bindDouble(1, entity.getColor1());
        statement.bindDouble(2, entity.getColor2());
        statement.bindDouble(3, entity.getColor3());
        statement.bindLong(4, entity.getFondo());
        statement.bindLong(5, entity.getImage());
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllOptions = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM options";
        return _query;
      }
    };
  }

  @Override
  public Object insertOptions(final Options options, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOptions.insert(options);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllOptions(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllOptions.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllOptions.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getOptions(final Continuation<? super Options> $completion) {
    final String _sql = "SELECT * FROM options LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Options>() {
      @Override
      @Nullable
      public Options call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfColor1 = CursorUtil.getColumnIndexOrThrow(_cursor, "color1");
          final int _cursorIndexOfColor2 = CursorUtil.getColumnIndexOrThrow(_cursor, "color2");
          final int _cursorIndexOfColor3 = CursorUtil.getColumnIndexOrThrow(_cursor, "color3");
          final int _cursorIndexOfFondo = CursorUtil.getColumnIndexOrThrow(_cursor, "fondo");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final Options _result;
          if (_cursor.moveToFirst()) {
            final float _tmpColor1;
            _tmpColor1 = _cursor.getFloat(_cursorIndexOfColor1);
            final float _tmpColor2;
            _tmpColor2 = _cursor.getFloat(_cursorIndexOfColor2);
            final float _tmpColor3;
            _tmpColor3 = _cursor.getFloat(_cursorIndexOfColor3);
            final int _tmpFondo;
            _tmpFondo = _cursor.getInt(_cursorIndexOfFondo);
            final int _tmpImage;
            _tmpImage = _cursor.getInt(_cursorIndexOfImage);
            _result = new Options(_tmpColor1,_tmpColor2,_tmpColor3,_tmpFondo,_tmpImage);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _result.setId(_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
