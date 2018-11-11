package br.unicid.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NovoLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_livro);
    }

    public void fechar(View botao){
        finish();
    }
}
