package br.unicid.livraria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.unicid.livraria.dao.UsuarioDAO;
import br.unicid.livraria.domain.Usuario;

public class EditaUsuario extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;
    private EditText txtPassNew;
    private EditText txtPassNew2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_usuario);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        txtPassNew = (EditText) findViewById(R.id.txtPassNew);
        txtPassNew2 = (EditText) findViewById(R.id.txtPassNew2);
    }

    public void altFoto(View botao){
        Intent it = new Intent(this, Login.class);
        startActivity(it);
    }

    public void alterar(View botao) {

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);

        //Obtendo os valores dos campos
        String user = prefs.getString("username", "");
        //String username = txtUser.setText(String.valueOf(user));
        String pass = prefs.getString("password", "");
        String passCheck = txtPass.getText().toString();
        String passNew = txtPassNew.getText().toString();
        String passNew2 = txtPassNew2.getText().toString();

        if( passCheck.equals( pass ) ) {
            if( passNew.equals( passNew2 ) ) {
                //Criando um objeto aluno com os dados dos campos
                Usuario usuario = new Usuario(user, passNew);

                //DAO para inserção do registro
                UsuarioDAO dao = new UsuarioDAO(this);
                dao.update(usuario);

                Toast.makeText(this, "Usuario atualizado com sucesso!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "As novas senhas não batem!", Toast.LENGTH_SHORT).show();

                //Limpando os campos
                txtPassNew.setText(null);
                txtPassNew2.setText(null);
            }
        }else{
            Toast.makeText(this, "A senha atual está incorreta!", Toast.LENGTH_SHORT).show();
            //Limpando os campos
            txtPass.setText(null);
        }

        //Limpando os campos
        txtUser.setText(null);
        txtPass.setText(null);
    }

    public void fechar(View botao){
        finish();
    }
}
