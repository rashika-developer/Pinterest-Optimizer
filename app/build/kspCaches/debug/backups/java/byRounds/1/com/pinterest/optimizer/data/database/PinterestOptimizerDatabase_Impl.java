package com.pinterest.optimizer.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PinterestOptimizerDatabase_Impl extends PinterestOptimizerDatabase {
  private volatile PinterestAccountDao _pinterestAccountDao;

  private volatile NicheProfileDao _nicheProfileDao;

  private volatile PinterestPostDao _pinterestPostDao;

  private volatile AnalyticsDao _analyticsDao;

  private volatile TrendDao _trendDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `pinterest_accounts` (`userId` TEXT NOT NULL, `username` TEXT NOT NULL, `accessToken` TEXT NOT NULL, `refreshToken` TEXT, `tokenExpiresAt` INTEGER NOT NULL, `profileImage` TEXT, PRIMARY KEY(`userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `niche_profiles` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `niche` TEXT NOT NULL, `description` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pinterest_posts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `imageUri` TEXT NOT NULL, `description` TEXT NOT NULL, `captionMinimal` TEXT NOT NULL, `captionEngaging` TEXT NOT NULL, `captionSales` TEXT NOT NULL, `hashtags` TEXT NOT NULL, `productLinks` TEXT NOT NULL, `boardName` TEXT NOT NULL, `scheduledTime` INTEGER NOT NULL, `isPosted` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `analytics` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `postId` INTEGER NOT NULL, `views` INTEGER NOT NULL, `saves` INTEGER NOT NULL, `clicks` INTEGER NOT NULL, `impressions` INTEGER NOT NULL, `engagementRate` REAL NOT NULL, `updatedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `trends` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `category` TEXT NOT NULL, `trendScore` REAL NOT NULL, `discoveredAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '083e168834ed0fe9328b3d9e4b23f0c1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `pinterest_accounts`");
        db.execSQL("DROP TABLE IF EXISTS `niche_profiles`");
        db.execSQL("DROP TABLE IF EXISTS `pinterest_posts`");
        db.execSQL("DROP TABLE IF EXISTS `analytics`");
        db.execSQL("DROP TABLE IF EXISTS `trends`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsPinterestAccounts = new HashMap<String, TableInfo.Column>(6);
        _columnsPinterestAccounts.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestAccounts.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestAccounts.put("accessToken", new TableInfo.Column("accessToken", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestAccounts.put("refreshToken", new TableInfo.Column("refreshToken", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestAccounts.put("tokenExpiresAt", new TableInfo.Column("tokenExpiresAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestAccounts.put("profileImage", new TableInfo.Column("profileImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPinterestAccounts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPinterestAccounts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPinterestAccounts = new TableInfo("pinterest_accounts", _columnsPinterestAccounts, _foreignKeysPinterestAccounts, _indicesPinterestAccounts);
        final TableInfo _existingPinterestAccounts = TableInfo.read(db, "pinterest_accounts");
        if (!_infoPinterestAccounts.equals(_existingPinterestAccounts)) {
          return new RoomOpenHelper.ValidationResult(false, "pinterest_accounts(com.pinterest.optimizer.data.models.PinterestAccount).\n"
                  + " Expected:\n" + _infoPinterestAccounts + "\n"
                  + " Found:\n" + _existingPinterestAccounts);
        }
        final HashMap<String, TableInfo.Column> _columnsNicheProfiles = new HashMap<String, TableInfo.Column>(5);
        _columnsNicheProfiles.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNicheProfiles.put("niche", new TableInfo.Column("niche", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNicheProfiles.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNicheProfiles.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNicheProfiles.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNicheProfiles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNicheProfiles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNicheProfiles = new TableInfo("niche_profiles", _columnsNicheProfiles, _foreignKeysNicheProfiles, _indicesNicheProfiles);
        final TableInfo _existingNicheProfiles = TableInfo.read(db, "niche_profiles");
        if (!_infoNicheProfiles.equals(_existingNicheProfiles)) {
          return new RoomOpenHelper.ValidationResult(false, "niche_profiles(com.pinterest.optimizer.data.models.NicheProfile).\n"
                  + " Expected:\n" + _infoNicheProfiles + "\n"
                  + " Found:\n" + _existingNicheProfiles);
        }
        final HashMap<String, TableInfo.Column> _columnsPinterestPosts = new HashMap<String, TableInfo.Column>(12);
        _columnsPinterestPosts.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("imageUri", new TableInfo.Column("imageUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("captionMinimal", new TableInfo.Column("captionMinimal", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("captionEngaging", new TableInfo.Column("captionEngaging", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("captionSales", new TableInfo.Column("captionSales", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("hashtags", new TableInfo.Column("hashtags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("productLinks", new TableInfo.Column("productLinks", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("boardName", new TableInfo.Column("boardName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("scheduledTime", new TableInfo.Column("scheduledTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("isPosted", new TableInfo.Column("isPosted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPinterestPosts.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPinterestPosts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPinterestPosts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPinterestPosts = new TableInfo("pinterest_posts", _columnsPinterestPosts, _foreignKeysPinterestPosts, _indicesPinterestPosts);
        final TableInfo _existingPinterestPosts = TableInfo.read(db, "pinterest_posts");
        if (!_infoPinterestPosts.equals(_existingPinterestPosts)) {
          return new RoomOpenHelper.ValidationResult(false, "pinterest_posts(com.pinterest.optimizer.data.models.PinterestPost).\n"
                  + " Expected:\n" + _infoPinterestPosts + "\n"
                  + " Found:\n" + _existingPinterestPosts);
        }
        final HashMap<String, TableInfo.Column> _columnsAnalytics = new HashMap<String, TableInfo.Column>(8);
        _columnsAnalytics.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("postId", new TableInfo.Column("postId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("views", new TableInfo.Column("views", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("saves", new TableInfo.Column("saves", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("clicks", new TableInfo.Column("clicks", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("impressions", new TableInfo.Column("impressions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("engagementRate", new TableInfo.Column("engagementRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnalytics.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAnalytics = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAnalytics = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAnalytics = new TableInfo("analytics", _columnsAnalytics, _foreignKeysAnalytics, _indicesAnalytics);
        final TableInfo _existingAnalytics = TableInfo.read(db, "analytics");
        if (!_infoAnalytics.equals(_existingAnalytics)) {
          return new RoomOpenHelper.ValidationResult(false, "analytics(com.pinterest.optimizer.data.models.PostAnalytics).\n"
                  + " Expected:\n" + _infoAnalytics + "\n"
                  + " Found:\n" + _existingAnalytics);
        }
        final HashMap<String, TableInfo.Column> _columnsTrends = new HashMap<String, TableInfo.Column>(6);
        _columnsTrends.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrends.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrends.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrends.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrends.put("trendScore", new TableInfo.Column("trendScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrends.put("discoveredAt", new TableInfo.Column("discoveredAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrends = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrends = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrends = new TableInfo("trends", _columnsTrends, _foreignKeysTrends, _indicesTrends);
        final TableInfo _existingTrends = TableInfo.read(db, "trends");
        if (!_infoTrends.equals(_existingTrends)) {
          return new RoomOpenHelper.ValidationResult(false, "trends(com.pinterest.optimizer.data.models.Trend).\n"
                  + " Expected:\n" + _infoTrends + "\n"
                  + " Found:\n" + _existingTrends);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "083e168834ed0fe9328b3d9e4b23f0c1", "ba14036e5ab621db729f08c841694ef1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pinterest_accounts","niche_profiles","pinterest_posts","analytics","trends");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `pinterest_accounts`");
      _db.execSQL("DELETE FROM `niche_profiles`");
      _db.execSQL("DELETE FROM `pinterest_posts`");
      _db.execSQL("DELETE FROM `analytics`");
      _db.execSQL("DELETE FROM `trends`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PinterestAccountDao.class, PinterestAccountDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NicheProfileDao.class, NicheProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PinterestPostDao.class, PinterestPostDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AnalyticsDao.class, AnalyticsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TrendDao.class, TrendDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PinterestAccountDao pinterestAccountDao() {
    if (_pinterestAccountDao != null) {
      return _pinterestAccountDao;
    } else {
      synchronized(this) {
        if(_pinterestAccountDao == null) {
          _pinterestAccountDao = new PinterestAccountDao_Impl(this);
        }
        return _pinterestAccountDao;
      }
    }
  }

  @Override
  public NicheProfileDao nicheProfileDao() {
    if (_nicheProfileDao != null) {
      return _nicheProfileDao;
    } else {
      synchronized(this) {
        if(_nicheProfileDao == null) {
          _nicheProfileDao = new NicheProfileDao_Impl(this);
        }
        return _nicheProfileDao;
      }
    }
  }

  @Override
  public PinterestPostDao pinterestPostDao() {
    if (_pinterestPostDao != null) {
      return _pinterestPostDao;
    } else {
      synchronized(this) {
        if(_pinterestPostDao == null) {
          _pinterestPostDao = new PinterestPostDao_Impl(this);
        }
        return _pinterestPostDao;
      }
    }
  }

  @Override
  public AnalyticsDao analyticsDao() {
    if (_analyticsDao != null) {
      return _analyticsDao;
    } else {
      synchronized(this) {
        if(_analyticsDao == null) {
          _analyticsDao = new AnalyticsDao_Impl(this);
        }
        return _analyticsDao;
      }
    }
  }

  @Override
  public TrendDao trendDao() {
    if (_trendDao != null) {
      return _trendDao;
    } else {
      synchronized(this) {
        if(_trendDao == null) {
          _trendDao = new TrendDao_Impl(this);
        }
        return _trendDao;
      }
    }
  }
}
