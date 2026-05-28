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
import com.pinterest.optimizer.data.models.PostAnalytics;
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
public final class AnalyticsDao_Impl implements AnalyticsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostAnalytics> __insertionAdapterOfPostAnalytics;

  private final EntityDeletionOrUpdateAdapter<PostAnalytics> __updateAdapterOfPostAnalytics;

  public AnalyticsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostAnalytics = new EntityInsertionAdapter<PostAnalytics>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `analytics` (`id`,`postId`,`views`,`saves`,`clicks`,`impressions`,`engagementRate`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final PostAnalytics entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getPostId());
        statement.bindLong(3, entity.getViews());
        statement.bindLong(4, entity.getSaves());
        statement.bindLong(5, entity.getClicks());
        statement.bindLong(6, entity.getImpressions());
        statement.bindDouble(7, entity.getEngagementRate());
        statement.bindLong(8, entity.getUpdatedAt());
      }
    };
    this.__updateAdapterOfPostAnalytics = new EntityDeletionOrUpdateAdapter<PostAnalytics>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `analytics` SET `id` = ?,`postId` = ?,`views` = ?,`saves` = ?,`clicks` = ?,`impressions` = ?,`engagementRate` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final PostAnalytics entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getPostId());
        statement.bindLong(3, entity.getViews());
        statement.bindLong(4, entity.getSaves());
        statement.bindLong(5, entity.getClicks());
        statement.bindLong(6, entity.getImpressions());
        statement.bindDouble(7, entity.getEngagementRate());
        statement.bindLong(8, entity.getUpdatedAt());
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insertAnalytics(final PostAnalytics analytics,
      final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object updateAnalytics(final PostAnalytics analytics,
      final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Flow<PostAnalytics> getAnalyticsByPostId(final int postId) {
    final String _sql = "SELECT * FROM analytics WHERE postId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, postId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"analytics"}, new Callable<PostAnalytics>() {
      @Override
      public PostAnalytics call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "postId");
          final int _cursorIndexOfViews = CursorUtil.getColumnIndexOrThrow(_cursor, "views");
          final int _cursorIndexOfSaves = CursorUtil.getColumnIndexOrThrow(_cursor, "saves");
          final int _cursorIndexOfClicks = CursorUtil.getColumnIndexOrThrow(_cursor, "clicks");
          final int _cursorIndexOfImpressions = CursorUtil.getColumnIndexOrThrow(_cursor, "impressions");
          final int _cursorIndexOfEngagementRate = CursorUtil.getColumnIndexOrThrow(_cursor, "engagementRate");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final PostAnalytics _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpPostId;
            _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
            final int _tmpViews;
            _tmpViews = _cursor.getInt(_cursorIndexOfViews);
            final int _tmpSaves;
            _tmpSaves = _cursor.getInt(_cursorIndexOfSaves);
            final int _tmpClicks;
            _tmpClicks = _cursor.getInt(_cursorIndexOfClicks);
            final int _tmpImpressions;
            _tmpImpressions = _cursor.getInt(_cursorIndexOfImpressions);
            final float _tmpEngagementRate;
            _tmpEngagementRate = _cursor.getFloat(_cursorIndexOfEngagementRate);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new PostAnalytics(_tmpId,_tmpPostId,_tmpViews,_tmpSaves,_tmpClicks,_tmpImpressions,_tmpEngagementRate,_tmpUpdatedAt);
          } else {
            _result = null;
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
  public Flow<List<PostAnalytics>> getRecentAnalytics() {
    final String _sql = "SELECT * FROM analytics ORDER BY updatedAt DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"analytics"}, new Callable<List<PostAnalytics>>() {
      @Override
      public List<PostAnalytics> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPostId = CursorUtil.getColumnIndexOrThrow(_cursor, "postId");
          final int _cursorIndexOfViews = CursorUtil.getColumnIndexOrThrow(_cursor, "views");
          final int _cursorIndexOfSaves = CursorUtil.getColumnIndexOrThrow(_cursor, "saves");
          final int _cursorIndexOfClicks = CursorUtil.getColumnIndexOrThrow(_cursor, "clicks");
          final int _cursorIndexOfImpressions = CursorUtil.getColumnIndexOrThrow(_cursor, "impressions");
          final int _cursorIndexOfEngagementRate = CursorUtil.getColumnIndexOrThrow(_cursor, "engagementRate");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<PostAnalytics> _result = new ArrayList<PostAnalytics>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PostAnalytics _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpPostId;
            _tmpPostId = _cursor.getInt(_cursorIndexOfPostId);
            final int _tmpViews;
            _tmpViews = _cursor.getInt(_cursorIndexOfViews);
            final int _tmpSaves;
            _tmpSaves = _cursor.getInt(_cursorIndexOfSaves);
            final int _tmpClicks;
            _tmpClicks = _cursor.getInt(_cursorIndexOfClicks);
            final int _tmpImpressions;
            _tmpImpressions = _cursor.getInt(_cursorIndexOfImpressions);
            final float _tmpEngagementRate;
            _tmpEngagementRate = _cursor.getFloat(_cursorIndexOfEngagementRate);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new PostAnalytics(_tmpId,_tmpPostId,_tmpViews,_tmpSaves,_tmpClicks,_tmpImpressions,_tmpEngagementRate,_tmpUpdatedAt);
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
