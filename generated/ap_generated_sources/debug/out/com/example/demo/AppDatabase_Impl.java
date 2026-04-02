package com.example.demo;

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
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDAO _userDAO;

  private volatile BarDAO _barDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `utilisateurs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nom` TEXT, `email` TEXT, `password` TEXT, `date_naissance` TEXT, `image_path` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `bars` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `utilisateurId` INTEGER NOT NULL, `nom` TEXT, `adresse` TEXT, `note` REAL NOT NULL, `commentaire` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '108dd88793f93a589d82334d3b9f6aa7')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `utilisateurs`");
        db.execSQL("DROP TABLE IF EXISTS `bars`");
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
        final HashMap<String, TableInfo.Column> _columnsUtilisateurs = new HashMap<String, TableInfo.Column>(6);
        _columnsUtilisateurs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("nom", new TableInfo.Column("nom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("date_naissance", new TableInfo.Column("date_naissance", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("image_path", new TableInfo.Column("image_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUtilisateurs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUtilisateurs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUtilisateurs = new TableInfo("utilisateurs", _columnsUtilisateurs, _foreignKeysUtilisateurs, _indicesUtilisateurs);
        final TableInfo _existingUtilisateurs = TableInfo.read(db, "utilisateurs");
        if (!_infoUtilisateurs.equals(_existingUtilisateurs)) {
          return new RoomOpenHelper.ValidationResult(false, "utilisateurs(com.example.demo.User).\n"
                  + " Expected:\n" + _infoUtilisateurs + "\n"
                  + " Found:\n" + _existingUtilisateurs);
        }
        final HashMap<String, TableInfo.Column> _columnsBars = new HashMap<String, TableInfo.Column>(6);
        _columnsBars.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBars.put("utilisateurId", new TableInfo.Column("utilisateurId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBars.put("nom", new TableInfo.Column("nom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBars.put("adresse", new TableInfo.Column("adresse", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBars.put("note", new TableInfo.Column("note", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBars.put("commentaire", new TableInfo.Column("commentaire", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBars = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBars = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBars = new TableInfo("bars", _columnsBars, _foreignKeysBars, _indicesBars);
        final TableInfo _existingBars = TableInfo.read(db, "bars");
        if (!_infoBars.equals(_existingBars)) {
          return new RoomOpenHelper.ValidationResult(false, "bars(com.example.demo.Bar).\n"
                  + " Expected:\n" + _infoBars + "\n"
                  + " Found:\n" + _existingBars);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "108dd88793f93a589d82334d3b9f6aa7", "6b1471daac6520913b29091aa9f008fa");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "utilisateurs","bars");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `utilisateurs`");
      _db.execSQL("DELETE FROM `bars`");
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
    _typeConvertersMap.put(UserDAO.class, UserDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(BarDAO.class, BarDAO_Impl.getRequiredConverters());
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
  public UserDAO utilisateurDao() {
    if (_userDAO != null) {
      return _userDAO;
    } else {
      synchronized(this) {
        if(_userDAO == null) {
          _userDAO = new UserDAO_Impl(this);
        }
        return _userDAO;
      }
    }
  }

  @Override
  public BarDAO barDao() {
    if (_barDAO != null) {
      return _barDAO;
    } else {
      synchronized(this) {
        if(_barDAO == null) {
          _barDAO = new BarDAO_Impl(this);
        }
        return _barDAO;
      }
    }
  }
}
