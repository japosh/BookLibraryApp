package br.unicid.livraria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManutCatalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manut_catalogo);
    }

    public void novoLivro(View botao){
        Intent it = new Intent(this, NovoLivro.class);
        startActivity(it);


    }

    public void voltar(View botao){
        finish();
    }
}
