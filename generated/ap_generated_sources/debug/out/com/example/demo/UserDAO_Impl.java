package com.example.demo;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDAO_Impl implements UserDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfSupprimerUtilisateur;

  public UserDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `utilisateurs` (`id`,`nom`,`email`,`password`,`date_naissance`,`image_path`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final User entity) {
        statement.bindLong(1, entity.id);
        if (entity.nom == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.nom);
        }
        if (entity.email == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.email);
        }
        if (entity.password == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.password);
        }
        if (entity.dateNaissance == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.dateNaissance);
        }
        if (entity.imagePath == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.imagePath);
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `utilisateurs` SET `id` = ?,`nom` = ?,`email` = ?,`password` = ?,`date_naissance` = ?,`image_path` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final User entity) {
        statement.bindLong(1, entity.id);
        if (entity.nom == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.nom);
        }
        if (entity.email == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.email);
        }
        if (entity.password == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.password);
        }
        if (entity.dateNaissance == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.dateNaissance);
        }
        if (entity.imagePath == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.imagePath);
        }
        statement.bindLong(7, entity.id);
      }
    };
    this.__preparedStmtOfSupprimerUtilisateur = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM utilisateurs WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void inserer(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void modifier(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void supprimerUtilisateur(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSupprimerUtilisateur.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfSupprimerUtilisateur.release(_stmt);
    }
  }

  @Override
  public User verifierLogin(final String email, final String password) {
    final String _sql = "SELECT * FROM utilisateurs WHERE email = ? AND password = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfDateNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "date_naissance");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final User _result;
      if (_cursor.moveToFirst()) {
        _result = new User();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _result.nom = null;
        } else {
          _result.nom = _cursor.getString(_cursorIndexOfNom);
        }
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _result.email = null;
        } else {
          _result.email = _cursor.getString(_cursorIndexOfEmail);
        }
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _result.password = null;
        } else {
          _result.password = _cursor.getString(_cursorIndexOfPassword);
        }
        if (_cursor.isNull(_cursorIndexOfDateNaissance)) {
          _result.dateNaissance = null;
        } else {
          _result.dateNaissance = _cursor.getString(_cursorIndexOfDateNaissance);
        }
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _result.imagePath = null;
        } else {
          _result.imagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User verifierEmailExiste(final String email) {
    final String _sql = "SELECT * FROM utilisateurs WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfDateNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "date_naissance");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final User _result;
      if (_cursor.moveToFirst()) {
        _result = new User();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _result.nom = null;
        } else {
          _result.nom = _cursor.getString(_cursorIndexOfNom);
        }
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _result.email = null;
        } else {
          _result.email = _cursor.getString(_cursorIndexOfEmail);
        }
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _result.password = null;
        } else {
          _result.password = _cursor.getString(_cursorIndexOfPassword);
        }
        if (_cursor.isNull(_cursorIndexOfDateNaissance)) {
          _result.dateNaissance = null;
        } else {
          _result.dateNaissance = _cursor.getString(_cursorIndexOfDateNaissance);
        }
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _result.imagePath = null;
        } else {
          _result.imagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getTousLesUtilisateurs() {
    final String _sql = "SELECT * FROM utilisateurs";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfDateNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "date_naissance");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _item.nom = null;
        } else {
          _item.nom = _cursor.getString(_cursorIndexOfNom);
        }
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _item.email = null;
        } else {
          _item.email = _cursor.getString(_cursorIndexOfEmail);
        }
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _item.password = null;
        } else {
          _item.password = _cursor.getString(_cursorIndexOfPassword);
        }
        if (_cursor.isNull(_cursorIndexOfDateNaissance)) {
          _item.dateNaissance = null;
        } else {
          _item.dateNaissance = _cursor.getString(_cursorIndexOfDateNaissance);
        }
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _item.imagePath = null;
        } else {
          _item.imagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserById(final int id) {
    final String _sql = "SELECT * FROM utilisateurs WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfDateNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "date_naissance");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final User _result;
      if (_cursor.moveToFirst()) {
        _result = new User();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _result.nom = null;
        } else {
          _result.nom = _cursor.getString(_cursorIndexOfNom);
        }
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _result.email = null;
        } else {
          _result.email = _cursor.getString(_cursorIndexOfEmail);
        }
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _result.password = null;
        } else {
          _result.password = _cursor.getString(_cursorIndexOfPassword);
        }
        if (_cursor.isNull(_cursorIndexOfDateNaissance)) {
          _result.dateNaissance = null;
        } else {
          _result.dateNaissance = _cursor.getString(_cursorIndexOfDateNaissance);
        }
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _result.imagePath = null;
        } else {
          _result.imagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
