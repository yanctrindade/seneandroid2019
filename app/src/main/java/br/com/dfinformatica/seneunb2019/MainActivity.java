package br.com.dfinformatica.seneunb2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Elementos Visuais que eu construi na activity_main.xml
    EditText emailEditText;
    EditText senhaEditText;
    Button loginButton;
    Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIds();
    }

    void findViewByIds() {
        emailEditText = findViewById(R.id.activity_main_loginedittext);
        senhaEditText = findViewById(R.id.activity_main_senhaedittext);
        loginButton = findViewById(R.id.activity_main_loginbutton);
        limparButton = findViewById(R.id.activity_main_limparbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                //campos em branco ?
                if (email.isEmpty()) {
                    emailEditText.setError("Campo obrigatório");
                    return;
                }
                if (senha.isEmpty()) {
                    senhaEditText.setError("Preencha a senha");
                    return;
                }

                //campos com formato correto?
                if (!email.contains("@")) {
                    emailEditText.setError("Email inválido");
                    return;
                }
                if (senha.length() < 6) {
                    senhaEditText.setError("Senha muito curta");
                    return;
                }

                Toast.makeText(getApplicationContext(),
                        "Login realizado com sucesso!",
                        Toast.LENGTH_SHORT)
                        .show();

                //passando de tela
                Intent i = new Intent(MainActivity.this, SegundaTela.class);
                startActivity(i);

            }
        });

        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emailEditText.setText("");
                senhaEditText.setText("");

            }
        });

    }


}
