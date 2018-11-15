package br.unicid.livraria;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.List;

import br.unicid.livraria.dao.LivroDAO;
import br.unicid.livraria.domain.Livro;
import br.unicid.livraria.util.LivrosAdapter;

public class Catalogo extends AppCompatActivity {

    private ListView lvwLista;
    private LivrosAdapter adapter;
    private List<Livro> livros;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo);


        lvwLista = (ListView) findViewById(R.id.lvwLista);


        //Buscando a lista de livros no banco
        livros = new LivroDAO(this).findAll();

        adapter = new LivrosAdapter(this, livros);

        lvwLista.setAdapter(adapter)


    }

    public void voltar(View botao){
        finish();
    }
}
