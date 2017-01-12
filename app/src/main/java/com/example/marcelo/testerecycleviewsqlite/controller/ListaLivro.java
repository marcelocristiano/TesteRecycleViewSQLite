package com.example.marcelo.testerecycleviewsqlite.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.marcelo.testerecycleviewsqlite.R;
import com.example.marcelo.testerecycleviewsqlite.adapter.LivroAdapter;
import com.example.marcelo.testerecycleviewsqlite.dao.LivroDAO;
import com.example.marcelo.testerecycleviewsqlite.model.Livro;

import java.util.ArrayList;

public class ListaLivro extends AppCompatActivity {
    RecyclerView rcvLivro;
    ArrayList<Livro> listaDeLivro;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livro);
        // Recupera o item da view RecycleView.
        rcvLivro = (RecyclerView) findViewById(R.id.rcv_livro);
        // Instancia a classe  RecyclerView.LayoutManager e recebe um tipo de Layout.
        layoutManager = new LinearLayoutManager(getApplication());
        // Seta o tipo de LayoutManager.
        rcvLivro.setLayoutManager(layoutManager);

        // Instancia uma nova Lista.
        listaDeLivro = new ArrayList<>();
        // Instancia a classe livroDAO e cria um novo ojeto.
        LivroDAO livroDAO = new LivroDAO();
        // adiciona valores a lista de livros.
        listaDeLivro = livroDAO.selectLivro(getApplication());
        // Instancia a classe LivroAdapter.
        LivroAdapter adapter = new LivroAdapter(listaDeLivro, getApplication());
        // Set o adapter no RecycleView.
        rcvLivro.setAdapter(adapter);

    }
}
