package br.unicid.livraria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.unicid.livraria.dao.LivroDAO;
import br.unicid.livraria.domain.Livro;

public class InfoLivro extends AppCompatActivity {

    private TextView txtISBN;
    private TextView txtTitulo;
    private TextView txtSubTitulo;
    private TextView txtEdicao;
    private TextView txtAutor;
    private TextView txtQuantPag;
    private TextView txtAnoPub;
    private TextView txtEditora;

    private String isbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_livro);

        txtISBN = (TextView) findViewById(R.id.txtISBN);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtSubTitulo  = (TextView) findViewById(R.id.txtSubTitulo);
        txtEdicao = (TextView) findViewById(R.id.txtEdicao);
        txtAutor = (TextView) findViewById(R.id.txtAutor);
        txtQuantPag = (TextView) findViewById(R.id.txtQuantPag);
        txtAnoPub = (TextView) findViewById(R.id.txtAnoPub);
        txtEditora = (TextView) findViewById(R.id.txtEditora);

        //Recebe o isbn do livro da página catalogo
        Intent getIsbn = getIntent();
        isbn  = getIsbn.getStringExtra("isbn");

        //Pesquisa o libro no banco
        Livro livro = new LivroDAO(this).findByIsbn(isbn);

        if (livro != null){

            //Preenche os campos com as informações do livro
            txtAnoPub.setText(livro.getAnoPub());
            txtAutor.setText(livro.getAutor());
            txtEdicao.setText(livro.getEdicao());
            txtEditora.setText(livro.getEditora());
            txtISBN.setText(livro.getIsbn());
            txtQuantPag.setText(livro.getQuantPag());
            txtSubTitulo.setText(livro.getSubTitulo());
            txtTitulo.setText(livro.getTitulo());
        }

    }

    public void voltar(View botao){
        finish();
    }
}
