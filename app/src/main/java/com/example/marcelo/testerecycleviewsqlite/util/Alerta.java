package com.example.marcelo.testerecycleviewsqlite.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcelo.testerecycleviewsqlite.R;

/**
 * Created by Marcelo on 11/01/2017.
 */

public class Alerta {

    public static void mensagemToast(Context context, String mensagem, int duracao, int gravity, int x, int y){
        // Instancia um objeto Layou.
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        // Infla a view.
        View view = layoutInflater.inflate(R.layout.activity_toast, null);
        // Recupera o item da view inflada.
        TextView tvToast = (TextView) view.findViewById(R.id.tv_toast);
        // Seta o valor do TextView tvToast.
        tvToast.setText(mensagem);
        // Cria um Toast.
        Toast toast = Toast.makeText(context, null, duracao);
        // Seta a gravidade do Toast
        toast.setGravity(gravity, x, y);
        // Seta a view que deve ser mostrada.
        toast.setView(view);
        // Da o show para a mensagem ser exibida.
        toast.show();
    }
}
