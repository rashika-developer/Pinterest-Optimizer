package com.pinterest.optimizer.data.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pinterest.optimizer.data.models.PinterestPost;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class PinterestPostDao_Impl implements PinterestPostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PinterestPost> __insertionAdapterOfPinterestPost;

  private final EntityDeletionOrUpdateAdapter<PinterestPost> __deletionAdapterOfPinterestPost;

  private final EntityDeletionOrUpdateAdapter<PinterestPost> __updateAdapterOfPinterestPost;

  private final SharedSQLiteStatement __preparedStmtOfDeletePostById;

  public PinterestPostDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPinterestPost = new EntityInsertionAdapter<PinterestPost>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pinterest_posts` (`id`,`imageUri`,`description`,`captionMinimal`,`captionEngaging`,`captionSales`,`hashtags`,`productLinks`,`boardName`,`scheduledTime`,`isPosted`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PinterestPost entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getImageUri());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getCaptionMinimal());
        statement.bindString(5, entity.getCaptionEngaging());
        statement.bindString(6, entity.getCaptionSales());
        statement.bindString(7, entity.getHashtags());
        statement.bindString(8, entity.getProductLinks());
        statement.bindString(9, entity.getBoardName());
        statement.bindLong(10, entity.getScheduledTime());
        final int _tmp = entity.isPosted() ? 1 : 0;
        statement.bindLong(11, _tmp);
        statement.bindLong(12, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfPinterestPost = new EntityDeletionOrUpdateAdapter<PinterestPost>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pinterest_posts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PinterestPost entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfPinterestPost = new EntityDeletionOrUpdateAdapter<PinterestPost>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `pinterest_posts` SET `id` = ?,`imageUri` = ?,`description` = ?,`captionMinimal` = ?,`captionEngaging` = ?,`captionSales` = ?,`hashtags` = ?,`productLinks` = ?,`boardName` = ?,`scheduledTime` = ?,`isPosted` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PinterestPost entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getImageUri());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getCaptionMinimal());
        statement.bindString(5, entity.getCaptionEngaging());
        statement.bindString(6, entity.getCaptionSales());
        statement.bindString(7, entity.getHashtags());
        statement.bindString(8, entity.getProductLinks());
        statement.bindString(9, entity.getBoardName());
        statement.bindLong(10, entity.getScheduledTime());
        final int _tmp = entity.isPosted() ? 1 : 0;
        statement.bindLong(11, _tmp);
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getId());
      }
    };
    this.__preparedStmtOfDeletePostById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM pinterest_posts WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertPost(final PinterestPost post, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPinterestPost.insertAndReturnId(post);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePost(final PinterestPost post, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPinterestPost.handle(post);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePost(final PinterestPost post, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPinterestPost.handle(post);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePostById(final int postId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePostById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, postId);
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
          __preparedStmtOfDeletePostById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PinterestPost>> getAllPosts() {
    final String _sql = "SELECT * FROM pinterest_posts ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pinterest_posts"}, new Callable<List<PinterestPost>>() {
      @Override
      @NonNull
      public List<PinterestPost> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCaptionMinimal = CursorUtil.getColumnIndexOrThrow(_cursor, "captionMinimal");
          final int _cursorIndexOfCaptionEngaging = CursorUtil.getColumnIndexOrThrow(_cursor, "captionEngaging");
          final int _cursorIndexOfCaptionSales = CursorUtil.getColumnIndexOrThrow(_cursor, "captionSales");
          final int _cursorIndexOfHashtags = CursorUtil.getColumnIndexOrThrow(_cursor, "hashtags");
          final int _cursorIndexOfProductLinks = CursorUtil.getColumnIndexOrThrow(_cursor, "productLinks");
          final int _cursorIndexOfBoardName = CursorUtil.getColumnIndexOrThrow(_cursor, "boardName");
          final int _cursorIndexOfScheduledTime = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledTime");
          final int _cursorIndexOfIsPosted = CursorUtil.getColumnIndexOrThrow(_cursor, "isPosted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<PinterestPost> _result = new ArrayList<PinterestPost>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PinterestPost _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImageUri;
            _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCaptionMinimal;
            _tmpCaptionMinimal = _cursor.getString(_cursorIndexOfCaptionMinimal);
            final String _tmpCaptionEngaging;
            _tmpCaptionEngaging = _cursor.getString(_cursorIndexOfCaptionEngaging);
            final String _tmpCaptionSales;
            _tmpCaptionSales = _cursor.getString(_cursorIndexOfCaptionSales);
            final String _tmpHashtags;
            _tmpHashtags = _cursor.getString(_cursorIndexOfHashtags);
            final String _tmpProductLinks;
            _tmpProductLinks = _cursor.getString(_cursorIndexOfProductLinks);
            final String _tmpBoardName;
            _tmpBoardName = _cursor.getString(_cursorIndexOfBoardName);
            final long _tmpScheduledTime;
            _tmpScheduledTime = _cursor.getLong(_cursorIndexOfScheduledTime);
            final boolean _tmpIsPosted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPosted);
            _tmpIsPosted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new PinterestPost(_tmpId,_tmpImageUri,_tmpDescription,_tmpCaptionMinimal,_tmpCaptionEngaging,_tmpCaptionSales,_tmpHashtags,_tmpProductLinks,_tmpBoardName,_tmpScheduledTime,_tmpIsPosted,_tmpCreatedAt);
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
  public Flow<PinterestPost> getPostById(final int postId) {
    final String _sql = "SELECT * FROM pinterest_posts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, postId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pinterest_posts"}, new Callable<PinterestPost>() {
      @Override
      @Nullable
      public PinterestPost call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCaptionMinimal = CursorUtil.getColumnIndexOrThrow(_cursor, "captionMinimal");
          final int _cursorIndexOfCaptionEngaging = CursorUtil.getColumnIndexOrThrow(_cursor, "captionEngaging");
          final int _cursorIndexOfCaptionSales = CursorUtil.getColumnIndexOrThrow(_cursor, "captionSales");
          final int _cursorIndexOfHashtags = CursorUtil.getColumnIndexOrThrow(_cursor, "hashtags");
          final int _cursorIndexOfProductLinks = CursorUtil.getColumnIndexOrThrow(_cursor, "productLinks");
          final int _cursorIndexOfBoardName = CursorUtil.getColumnIndexOrThrow(_cursor, "boardName");
          final int _cursorIndexOfScheduledTime = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledTime");
          final int _cursorIndexOfIsPosted = CursorUtil.getColumnIndexOrThrow(_cursor, "isPosted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final PinterestPost _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImageUri;
            _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCaptionMinimal;
            _tmpCaptionMinimal = _cursor.getString(_cursorIndexOfCaptionMinimal);
            final String _tmpCaptionEngaging;
            _tmpCaptionEngaging = _cursor.getString(_cursorIndexOfCaptionEngaging);
            final String _tmpCaptionSales;
            _tmpCaptionSales = _cursor.getString(_cursorIndexOfCaptionSales);
            final String _tmpHashtags;
            _tmpHashtags = _cursor.getString(_cursorIndexOfHashtags);
            final String _tmpProductLinks;
            _tmpProductLinks = _cursor.getString(_cursorIndexOfProductLinks);
            final String _tmpBoardName;
            _tmpBoardName = _cursor.getString(_cursorIndexOfBoardName);
            final long _tmpScheduledTime;
            _tmpScheduledTime = _cursor.getLong(_cursorIndexOfScheduledTime);
            final boolean _tmpIsPosted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPosted);
            _tmpIsPosted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new PinterestPost(_tmpId,_tmpImageUri,_tmpDescription,_tmpCaptionMinimal,_tmpCaptionEngaging,_tmpCaptionSales,_tmpHashtags,_tmpProductLinks,_tmpBoardName,_tmpScheduledTime,_tmpIsPosted,_tmpCreatedAt);
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
  public Flow<List<PinterestPost>> getScheduledPosts() {
    final String _sql = "SELECT * FROM pinterest_posts WHERE isPosted = 0 ORDER BY scheduledTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pinterest_posts"}, new Callable<List<PinterestPost>>() {
      @Override
      @NonNull
      public List<PinterestPost> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCaptionMinimal = CursorUtil.getColumnIndexOrThrow(_cursor, "captionMinimal");
          final int _cursorIndexOfCaptionEngaging = CursorUtil.getColumnIndexOrThrow(_cursor, "captionEngaging");
          final int _cursorIndexOfCaptionSales = CursorUtil.getColumnIndexOrThrow(_cursor, "captionSales");
          final int _cursorIndexOfHashtags = CursorUtil.getColumnIndexOrThrow(_cursor, "hashtags");
          final int _cursorIndexOfProductLinks = CursorUtil.getColumnIndexOrThrow(_cursor, "productLinks");
          final int _cursorIndexOfBoardName = CursorUtil.getColumnIndexOrThrow(_cursor, "boardName");
          final int _cursorIndexOfScheduledTime = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledTime");
          final int _cursorIndexOfIsPosted = CursorUtil.getColumnIndexOrThrow(_cursor, "isPosted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<PinterestPost> _result = new ArrayList<PinterestPost>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PinterestPost _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImageUri;
            _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCaptionMinimal;
            _tmpCaptionMinimal = _cursor.getString(_cursorIndexOfCaptionMinimal);
            final String _tmpCaptionEngaging;
            _tmpCaptionEngaging = _cursor.getString(_cursorIndexOfCaptionEngaging);
            final String _tmpCaptionSales;
            _tmpCaptionSales = _cursor.getString(_cursorIndexOfCaptionSales);
            final String _tmpHashtags;
            _tmpHashtags = _cursor.getString(_cursorIndexOfHashtags);
            final String _tmpProductLinks;
            _tmpProductLinks = _cursor.getString(_cursorIndexOfProductLinks);
            final String _tmpBoardName;
            _tmpBoardName = _cursor.getString(_cursorIndexOfBoardName);
            final long _tmpScheduledTime;
            _tmpScheduledTime = _cursor.getLong(_cursorIndexOfScheduledTime);
            final boolean _tmpIsPosted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPosted);
            _tmpIsPosted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new PinterestPost(_tmpId,_tmpImageUri,_tmpDescription,_tmpCaptionMinimal,_tmpCaptionEngaging,_tmpCaptionSales,_tmpHashtags,_tmpProductLinks,_tmpBoardName,_tmpScheduledTime,_tmpIsPosted,_tmpCreatedAt);
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
