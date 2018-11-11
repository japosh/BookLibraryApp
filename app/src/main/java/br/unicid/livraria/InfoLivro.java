package br.unicid.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_livro);
    }

    public void voltar(View botao){
        finish();
    }
}
