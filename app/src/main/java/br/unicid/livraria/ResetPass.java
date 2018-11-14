package br.unicid.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResetPass extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pass);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
    }

    public void altSenha(View botao){

        String user = txtUser.getText().toString();
        String pass = txtPass.getText().toString();
    }

    public void voltar(View botao){
        finish();
    }
}
