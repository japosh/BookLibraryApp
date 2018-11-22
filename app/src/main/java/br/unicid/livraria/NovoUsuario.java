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

import br.unicid.livraria.dao.UsuarioDAO;
import br.unicid.livraria.domain.Usuario;

public class NovoUsuario extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText txtUser;
    private EditText txtPass;
    private EditText txtPassNew;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_usuario);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        txtPassNew = (EditText) findViewById(R.id.txtPassNew);
        foto = (ImageView) findViewById(R.id.foto);

        findViewById(R.id.btnAltFoto).setOnClickListener(new View.OnClickListener() {
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
        //Obtendo os valores dos campos
        String user = txtUser.getText().toString();
        String pass = txtPass.getText().toString();
        String passCheck = txtPassNew.getText().toString();

        if( passCheck.equals( pass ) ) {
            //Criando um objeto aluno com os dados dos campos
            Usuario usuario = new Usuario(user, pass);

            //DAO para inserção do registro
            UsuarioDAO dao = new UsuarioDAO(this);
            dao.create(usuario);

            //Exibe um alerta de sucesso.
            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();

            //Limpando os campos
            txtUser.setText(null);
            txtPass.setText(null);
            txtPassNew.setText(null);

        }else{
            Toast.makeText(this, "As novas senhas não batem!", Toast.LENGTH_SHORT).show();

            //Limpando os campos
            txtPass.setText(null);
            txtPassNew.setText(null);
        }
    }

    public void voltar(View botao){
        finish();
    }
}
