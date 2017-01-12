package com.example.marcelo.testerecycleviewsqlite.model;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class Livro {
    private int id_livro;
    private String titulo;
    private String autor;
    private String anoLancamento;

    public Livro(String titulo, String autor, String anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
