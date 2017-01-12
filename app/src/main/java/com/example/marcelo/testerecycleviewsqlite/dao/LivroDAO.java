package com.example.marcelo.testerecycleviewsqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.marcelo.testerecycleviewsqlite.model.Livro;
import com.example.marcelo.testerecycleviewsqlite.persistence.DataBase;
import com.example.marcelo.testerecycleviewsqlite.persistence.DataModel;

import java.util.ArrayList;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class LivroDAO {
    SQLiteDatabase db;
    public boolean insertLivro(Livro livro, Context context){
        boolean resultado = true;
        try {
            DataBase dataBase = new DataBase(context);
            db = dataBase.getWritableDatabase();
            db.insert(DataModel.NOME_TABELA_LIVRO, null, montaLivro(livro));
            resultado = true;
        }catch (SQLException ex){
            resultado = false;
        }
        db.close();
        return resultado;
    }

    // Monta dados do livro para gravação.
    private ContentValues montaLivro(Livro livro){
        ContentValues values = new ContentValues();
        values.put(DataModel.COLUNA_TITULO, livro.getTitulo());
        values.put(DataModel.COLUNA_AUTOR, livro.getAutor());
        values.put(DataModel.COLUNA_ANO_LANCAMENTO, livro.getAnoLancamento());
        return values;
    }

    public ArrayList<Livro> selectLivro(Context context){
        ArrayList<Livro> livroArrayList = new ArrayList<>();
        try {
            // Instancia um novo objeto DataBase.
            DataBase dataBase = new DataBase(context);
            // Abre o banco de dados.
            db = dataBase.getReadableDatabase();
            // Cria um cursor para varer a tabela.
            Cursor cursor = db.query(DataModel.NOME_TABELA_LIVRO, null, null, null, null,null, DataModel.COLUNA_TITULO);
            // Recupera os index das colunas da tabela Livro.
            int indexTitulo = cursor.getColumnIndex(DataModel.COLUNA_TITULO);
            int indexAutor = cursor.getColumnIndex(DataModel.COLUNA_AUTOR);
            int indexAnoLancamento = cursor.getColumnIndex(DataModel.COLUNA_ANO_LANCAMENTO);
            // Verifica se o cursor é nulo.
            if (cursor != null){
                // Verifica se o cursor esta na primeira posição.
                if (cursor.moveToFirst()){
                    // Cria um loop de repetição para criar objetos do tipo livro.
                    do {
                        // Recebe os dados da tabela em String.
                        String titulo = cursor.getString(indexTitulo);
                        String autor = cursor.getString(indexAutor);
                        String anoLancamento = cursor.getString(indexAnoLancamento);
                        // Cria um novo objeto Livro.
                        Livro livro = new Livro(titulo, autor, anoLancamento);
                        // Adiciona os dados de livro na lista de Livro.
                        livroArrayList.add(livro);
                    }while (cursor.moveToNext());
                }
            }
        }catch (SQLException ex){

        }
        db.close();
        return  livroArrayList;
    }
}
