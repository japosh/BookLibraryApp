package br.unicid.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.unicid.livraria.dao.LivroDAO;
import br.unicid.livraria.domain.Livro;
import br.unicid.livraria.util.LivrosAdapter;

public class Catalogo extends AppCompatActivity {

    private ListView lvwLista;
    private LivrosAdapter adapter;
    private ArrayList <Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo);


        lvwLista = (ListView) findViewById(R.id.lvwLista);
        livros = new LivroDAO(this).findAll();
        adapter = new LivrosAdapter(this, livros);

        lvwLista.setAdapter(adapter);

    }

    public void voltar(View botao){
        finish();
    }
}