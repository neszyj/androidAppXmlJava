package com.example.demo;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
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
public final class BarDAO_Impl implements BarDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Bar> __insertionAdapterOfBar;

  private final EntityDeletionOrUpdateAdapter<Bar> __deletionAdapterOfBar;

  public BarDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBar = new EntityInsertionAdapter<Bar>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `bars` (`id`,`utilisateurId`,`nom`,`adresse`,`note`,`commentaire`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Bar entity) {
        statement.bindLong(1, entity.id);
        statement.bindLong(2, entity.utilisateurId);
        if (entity.nom == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.nom);
        }
        if (entity.adresse == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.adresse);
        }
        statement.bindDouble(5, entity.note);
        if (entity.commentaire == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.commentaire);
        }
      }
    };
    this.__deletionAdapterOfBar = new EntityDeletionOrUpdateAdapter<Bar>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `bars` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Bar entity) {
        statement.bindLong(1, entity.id);
      }
    };
  }

  @Override
  public void inserer(final Bar bar) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBar.insert(bar);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void supprimer(final Bar bar) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBar.handle(bar);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Bar> getBarsParUtilisateur(final int uId) {
    final String _sql = "SELECT * FROM bars WHERE utilisateurId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUtilisateurId = CursorUtil.getColumnIndexOrThrow(_cursor, "utilisateurId");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfCommentaire = CursorUtil.getColumnIndexOrThrow(_cursor, "commentaire");
      final List<Bar> _result = new ArrayList<Bar>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Bar _item;
        _item = new Bar();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.utilisateurId = _cursor.getInt(_cursorIndexOfUtilisateurId);
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _item.nom = null;
        } else {
          _item.nom = _cursor.getString(_cursorIndexOfNom);
        }
        if (_cursor.isNull(_cursorIndexOfAdresse)) {
          _item.adresse = null;
        } else {
          _item.adresse = _cursor.getString(_cursorIndexOfAdresse);
        }
        _item.note = _cursor.getFloat(_cursorIndexOfNote);
        if (_cursor.isNull(_cursorIndexOfCommentaire)) {
          _item.commentaire = null;
        } else {
          _item.commentaire = _cursor.getString(_cursorIndexOfCommentaire);
        }
        _result.add(_item);
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
