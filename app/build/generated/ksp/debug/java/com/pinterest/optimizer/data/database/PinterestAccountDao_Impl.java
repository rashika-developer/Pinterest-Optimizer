package com.pinterest.optimizer.data.database;

import android.database.Cursor;
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
import com.pinterest.optimizer.data.models.PinterestAccount;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PinterestAccountDao_Impl implements PinterestAccountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PinterestAccount> __insertionAdapterOfPinterestAccount;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAccount;

  public PinterestAccountDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPinterestAccount = new EntityInsertionAdapter<PinterestAccount>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pinterest_accounts` (`userId`,`username`,`accessToken`,`refreshToken`,`tokenExpiresAt`,`profileImage`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PinterestAccount entity) {
        statement.bindString(1, entity.getUserId());
        statement.bindString(2, entity.getUsername());
        statement.bindString(3, entity.getAccessToken());
        if (entity.getRefreshToken() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRefreshToken());
        }
        statement.bindLong(5, entity.getTokenExpiresAt());
        if (entity.getProfileImage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getProfileImage());
        }
      }
    };
    this.__preparedStmtOfDeleteAccount = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM pinterest_accounts";
        return _query;
      }
    };
  }

  @Override
  public Object insertAccount(final PinterestAccount account,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPinterestAccount.insert(account);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAccount(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAccount.acquire();
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
          __preparedStmtOfDeleteAccount.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<PinterestAccount> getAccount() {
    final String _sql = "SELECT * FROM pinterest_accounts LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pinterest_accounts"}, new Callable<PinterestAccount>() {
      @Override
      @Nullable
      public PinterestAccount call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfAccessToken = CursorUtil.getColumnIndexOrThrow(_cursor, "accessToken");
          final int _cursorIndexOfRefreshToken = CursorUtil.getColumnIndexOrThrow(_cursor, "refreshToken");
          final int _cursorIndexOfTokenExpiresAt = CursorUtil.getColumnIndexOrThrow(_cursor, "tokenExpiresAt");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final PinterestAccount _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            final String _tmpAccessToken;
            _tmpAccessToken = _cursor.getString(_cursorIndexOfAccessToken);
            final String _tmpRefreshToken;
            if (_cursor.isNull(_cursorIndexOfRefreshToken)) {
              _tmpRefreshToken = null;
            } else {
              _tmpRefreshToken = _cursor.getString(_cursorIndexOfRefreshToken);
            }
            final long _tmpTokenExpiresAt;
            _tmpTokenExpiresAt = _cursor.getLong(_cursorIndexOfTokenExpiresAt);
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            _result = new PinterestAccount(_tmpUserId,_tmpUsername,_tmpAccessToken,_tmpRefreshToken,_tmpTokenExpiresAt,_tmpProfileImage);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
