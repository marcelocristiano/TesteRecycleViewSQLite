package com.example.marcelo.testerecycleviewsqlite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marcelo.testerecycleviewsqlite.R;
import com.example.marcelo.testerecycleviewsqlite.model.Livro;

import java.util.ArrayList;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {
    ArrayList<Livro> livroArrayList;
    Context context;

    public LivroAdapter(ArrayList<Livro> livroArrayList, Context context) {
        this.livroArrayList = livroArrayList;
        this.context = context;
    }

    @Override
    public LivroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Instancia um objeto de LayoutInflater.
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        // infla a view e seta o valor dele em um objeto view.
        View view = layoutInflater.inflate(R.layout.activity_inflater_livro, null);
        return new LivroAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivroAdapter.ViewHolder holder, int position) {
        // Cria uma variavel para receber a posição do livro na lsita.
        Livro livro = livroArrayList.get(position);
        // Seta valores dos itens da view.
        holder.tvTitulo.setText(livro.getTitulo());
        holder.tvAutor.setText(livro.getAutor());
        holder.tvAnoLancamento.setText(livro.getAnoLancamento());
    }

    @Override
    public int getItemCount() {
        return livroArrayList.size();
    }

    // Metodo para intanciar os objetos da view.
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Varias do tipo TextView.
        TextView tvTitulo, tvAutor, tvAnoLancamento;

        public ViewHolder(View itemView) {
            super(itemView);
            // Recupera os objetos da view.
            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvAutor = (TextView) itemView.findViewById(R.id.tv_autor);
            tvAnoLancamento = (TextView) itemView.findViewById(R.id.tv_ano_lancamento);
        }
    }
}
