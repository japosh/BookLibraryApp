package br.unicid.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.unicid.livraria.dao.LivroDAO;
import br.unicid.livraria.domain.Livro;

public class EditaLivro extends AppCompatActivity {

    private EditText txtISBN;
    private EditText txtTitulo;
    private EditText txtSubTitulo;
    private EditText txtEdicao;
    private EditText txtAutor;
    private EditText txtQuantPag;
    private EditText txtAnoPub;
    private EditText txtEditora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_livro);


        txtISBN = (EditText) findViewById(R.id.txtISBN);
        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtSubTitulo  = (EditText) findViewById(R.id.txtSubTitulo);
        txtEdicao = (EditText) findViewById(R.id.txtEdicao);
        txtAutor = (EditText) findViewById(R.id.txtAutor);
        txtQuantPag = (EditText) findViewById(R.id.txtQuantPag);
        txtAnoPub = (EditText) findViewById(R.id.txtAnoPub);
        txtEditora = (EditText) findViewById(R.id.txtEditora);

    }

    public void alterarDados(View view){

        //Pegando os valortes do campo
        String isbn = txtISBN.getText().toString();
        String titulo = txtTitulo.getText().toString();
        String subTitulo= txtSubTitulo.getText().toString();
        String edicao = txtEdicao.getText().toString();
        String autor = txtAutor.getText().toString();
        String quantPag  = txtQuantPag.getText().toString();
        String anoPub = txtAnoPub.getText().toString();
        String editora = txtEditora.getText().toString();

        //Criando um objeto com as variaveis
        Livro livro = new Livro(isbn, titulo, subTitulo, edicao, autor, quantPag, anoPub, editora);

        LivroDAO dao = new LivroDAO(this);
        dao.update(livro);

       //Confirmando a alteração
        Toast.makeText(this, "Registro alterado com sucesso!", Toast.LENGTH_SHORT).show();

        //Limpando os campos

        txtISBN.setText("");
        txtTitulo.setText("");
        txtSubTitulo.setText("");
        txtEdicao.setText("");
        txtAutor.setText("");
        txtQuantPag.setText("");
        txtAnoPub.setText("");
        txtEditora.setText("");

    }

    //Fechando a janela
    public void fechar(View botao){
        finish();
    }
}
