package br.unicid.livraria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        Intent it = new Intent(this, Administracao.class);
        startActivity(it);

    }

    public void resetPass(View botao){
        Intent it = new Intent(this, ResetPass.class);
        startActivity(it);


    }

    public void newRegister(View botao){
        Intent it = new Intent(this, NewRegister.class);
        startActivity(it);


    }

    public void voltar(View botao){
        finish();
    }
}
