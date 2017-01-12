package com.example.marcelo.testerecycleviewsqlite.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.marcelo.testerecycleviewsqlite.persistence.DataModel;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, DataModel.NOME_BANCO, null, DataModel.VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataModel.criaTabelaLivro());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
