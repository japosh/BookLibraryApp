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

public class Login extends AppCompatActivity {

    private EditText User;
    private EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        User = (EditText) findViewById(R.id.txtUser);
        Pass = (EditText) findViewById(R.id.txtPass);
    }

    public void login(View botao){


        //Obtendo valores digitados
        String user = String.valueOf(User.getText());
        String pass = String.valueOf(Pass.getText());

        //Verifica se o campo usuario está vazio
        if (user.length() == 0){
            Toast.makeText(this, "Informe o usuário!", Toast.LENGTH_SHORT).show();
        //Verifica se a senha tem menos de 6 caracteres
        }else if (pass.length() == 0){
            Toast.makeText(this, "Senha inválida!", Toast.LENGTH_SHORT).show();
        }else{

          //Procurando usuário no banco de dados
          Usuario usuario = new UsuarioDAO(this).findByUser(user,pass);

          //Caso encontre o usuário no banco, chama a tela de Administração
          if (usuario != null){ // Caso o login de erro verificar aqui
              Intent it = new Intent(this, AdmDados.class);
              startActivity(it);

          }else{
              //Se não encontra o usuário exibe um aviso e limpa os campos
              Toast.makeText(this, "Usuário não cadastrado!", Toast.LENGTH_SHORT).show();

              User.setText(null);
              Pass.setText(null);
          }
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();

            editor.putString("key_name", user);

            editor.commit();

        }
    }

    public void resetPass(View botao){
        User = (EditText) findViewById(R.id.txtUser);
        String user = String.valueOf(User.getText());

        Intent it = new Intent(this, ResetPass.class);
        startActivity(it);

    }

    public void newRegister(View botao){
        Intent it = new Intent(this, NovoUsuario.class);
        startActivity(it);

    }

    public void voltar(View botao){
        finish();
    }
}
