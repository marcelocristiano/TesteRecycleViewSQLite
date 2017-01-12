package com.example.marcelo.testerecycleviewsqlite.controller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcelo.testerecycleviewsqlite.R;
import com.example.marcelo.testerecycleviewsqlite.dao.LivroDAO;
import com.example.marcelo.testerecycleviewsqlite.model.Livro;
import com.example.marcelo.testerecycleviewsqlite.util.Alerta;

public class MainActivity extends AppCompatActivity {
    EditText edtTitulo, edtAutor, edtAnoLancmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // seta o titulo da view.
        getSupportActionBar().setTitle("Cadastro de Livro");

        // Recupera os itens da view main
        edtTitulo = (EditText) findViewById(R.id.edt_titulo);
        edtAutor = (EditText) findViewById(R.id.edt_autor);
        edtAnoLancmento = (EditText) findViewById(R.id.edt_ano_lancamento);

        Button btnGravar = (Button) findViewById(R.id.btn_gravar);
        Button btnListaLivro = (Button) findViewById(R.id.btn_lista_livro);
        // Seta o click do botão btnGravar.
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insancia a classe LivroDAO criando um novo objeto;
                LivroDAO livroDAO = new LivroDAO();
                // Cria variaves para receber os valores inseridos;
                String titulo = edtTitulo.getText().toString();
                String autor = edtAutor.getText().toString();
                String anoLancamento = edtAnoLancmento.getText().toString();
                // Instancia o objeto livro criando um novo obejto;
                Livro livro = new Livro(titulo, autor, anoLancamento);
                // Chama o meto de inserir um livro no banco de dados.
                boolean insertValido = livroDAO.insertLivro(livro, getApplication());
                // Verifica se o insert dos dados forão feitos corretamente.
                if (insertValido){
                    Alerta.mensagemToast(getApplication(), "Dados gravados com sucesso", Toast.LENGTH_SHORT, Gravity.CENTER, 0, 0);
                    edtTitulo.setText("");
                    edtAutor.setText("");
                    edtAnoLancmento.setText("");
                }else{
                    Alerta.mensagemToast(getApplication(), "Erro ao gravar os dados", Toast.LENGTH_SHORT, Gravity.CENTER, 0, 220);
                }
            }
        });
        btnListaLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), ListaLivro.class));
            }
        });
    }
}
