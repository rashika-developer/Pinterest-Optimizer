package com.pinterest.optimizer.data.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pinterest.optimizer.data.models.Trend;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TrendDao_Impl implements TrendDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Trend> __insertionAdapterOfTrend;

  private final EntityDeletionOrUpdateAdapter<Trend> __deletionAdapterOfTrend;

  public TrendDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrend = new EntityInsertionAdapter<Trend>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `trends` (`id`,`title`,`description`,`category`,`trendScore`,`discoveredAt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Trend entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getCategory());
        statement.bindDouble(5, entity.getTrendScore());
        statement.bindLong(6, entity.getDiscoveredAt());
      }
    };
    this.__deletionAdapterOfTrend = new EntityDeletionOrUpdateAdapter<Trend>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `trends` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Trend entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertTrend(final Trend trend, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTrend.insert(trend);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTrend(final Trend trend, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTrend.handle(trend);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Trend>> getTopTrends(final int limit) {
    final String _sql = "SELECT * FROM trends ORDER BY trendScore DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"trends"}, new Callable<List<Trend>>() {
      @Override
      @NonNull
      public List<Trend> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTrendScore = CursorUtil.getColumnIndexOrThrow(_cursor, "trendScore");
          final int _cursorIndexOfDiscoveredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "discoveredAt");
          final List<Trend> _result = new ArrayList<Trend>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Trend _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final float _tmpTrendScore;
            _tmpTrendScore = _cursor.getFloat(_cursorIndexOfTrendScore);
            final long _tmpDiscoveredAt;
            _tmpDiscoveredAt = _cursor.getLong(_cursorIndexOfDiscoveredAt);
            _item = new Trend(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpTrendScore,_tmpDiscoveredAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Trend>> getTrendsByCategory(final String category) {
    final String _sql = "SELECT * FROM trends WHERE category = ? ORDER BY trendScore DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, category);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"trends"}, new Callable<List<Trend>>() {
      @Override
      @NonNull
      public List<Trend> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTrendScore = CursorUtil.getColumnIndexOrThrow(_cursor, "trendScore");
          final int _cursorIndexOfDiscoveredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "discoveredAt");
          final List<Trend> _result = new ArrayList<Trend>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Trend _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final float _tmpTrendScore;
            _tmpTrendScore = _cursor.getFloat(_cursorIndexOfTrendScore);
            final long _tmpDiscoveredAt;
            _tmpDiscoveredAt = _cursor.getLong(_cursorIndexOfDiscoveredAt);
            _item = new Trend(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpTrendScore,_tmpDiscoveredAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
