package br.unicid.livraria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Administracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administracao);
    }

    public void manutCatalogo(View botao){
        Intent it = new Intent(this, ManutCatalogo.class);
        startActivity(it);


    }

    public void editaUsuario(View botao){
        Intent it = new Intent(this, EditaUsuario.class);
        startActivity(it);


    }

    public void sair(View botao){
        finish();
    }
}
