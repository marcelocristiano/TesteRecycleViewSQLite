package com.example.marcelo.testerecycleviewsqlite.persistence;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class DataModel {
    public static final String NOME_BANCO = "Editora";
    public static final int VERSAO_BANCO = 1;
    public static final String NOME_TABELA_LIVRO = "Editora";
    public static final String COLUNA_ID_LIVRO = "Id_livro";
    public static final String COLUNA_TITULO = "Titulo";
    public static final String COLUNA_AUTOR = "Autor";
    public static final String COLUNA_ANO_LANCAMENTO = "AnoLancamento";

    // Cria tabela Livro.
    public static final String criaTabelaLivro(){
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE " + NOME_TABELA_LIVRO + "(");
        builder.append(COLUNA_ID_LIVRO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builder.append(COLUNA_TITULO + " TEXT, ");
        builder.append(COLUNA_AUTOR + " TEXT, ");
        builder.append(COLUNA_ANO_LANCAMENTO + " TEXT);");

        return builder.toString();
    }
}
