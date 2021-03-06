package br.unicid.livraria;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import br.unicid.livraria.dao.LivroDAO;
import br.unicid.livraria.domain.Livro;

public class NovoLivro extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText txtISBN;
    private EditText txtTitulo;
    private EditText txtSubTitulo;
    private EditText txtEdicao;
    private EditText txtAutor;
    private EditText txtQuantPag;
    private EditText txtAnoPub;
    private EditText txtEditora;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_livro);


        txtISBN = (EditText) findViewById(R.id.txtISBN);
        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtSubTitulo  = (EditText) findViewById(R.id.txtSubTitulo);
        txtEdicao = (EditText) findViewById(R.id.txtEdicao);
        txtAutor = (EditText) findViewById(R.id.txtAutor);
        txtQuantPag = (EditText) findViewById(R.id.txtQuantPag);
        txtAnoPub = (EditText) findViewById(R.id.txtAnoPub);
        txtEditora = (EditText) findViewById(R.id.txtEditora);
        foto = (ImageView) findViewById(R.id.foto);

        findViewById(R.id.btnImgCapa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pegarFoto();
            }
        });
    }

    public void pegarFoto(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        i.setType("Image/*");
        startActivityForResult(i, REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            if(resultCode == RESULT_OK){
                Bundle extras = data.getExtras();
                Bitmap bitmap = (Bitmap) extras.get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                bitmap.recycle();
                foto.setImageBitmap(bitmap);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void salvar(View view){

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
        dao.create(livro);

        //Confirmando a alteração
        Toast.makeText(this, "Registro criado com sucesso!", Toast.LENGTH_SHORT).show();

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

    public void fechar(View botao){
        finish();
    }
}
