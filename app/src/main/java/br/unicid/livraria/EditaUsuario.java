package br.unicid.livraria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.unicid.livraria.dao.UsuarioDAO;
import br.unicid.livraria.domain.Usuario;

public class EditaUsuario extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_usuario);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
    }

    public void alterar(View view) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        //Obtendo os valores dos campos
        String user = pref.getString("key_name", null);
        String pass = txtPass.getText().toString();

        //Criando um objeto aluno com os dados dos campos
        Usuario usuario = new Usuario(user, pass);

        //DAO para inserção do registro
        UsuarioDAO dao = new UsuarioDAO(this);
        dao.update(usuario);

        //Exibe um alerta de sucesso.
        Toast.makeText(this, "Usuário alterado com sucesso", Toast.LENGTH_SHORT).show();

        //Limpando os campos
        txtUser.setText(null);
        txtPass.setText(null);
    }

    public void fechar(View botao){
        finish();
    }
}
