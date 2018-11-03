package br.unicid.livraria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
    }

    public void catalogo(View botao){
        Intent it = new Intent(this, Catalogo.class);
        startActivity(it);


    }

    public void dados(View botao){
        Intent it = new Intent(this, Login.class);
        startActivity(it);


    }

    public void equipe(View botao){
        Intent it = new Intent(this, Equipe.class);
        startActivity(it);


    }

    public void fechar(View botao){
        finishAffinity();
        finish();

    }
}
