package br.ulbra.apphamburgueria;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText emailEditText, senhaEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailEditText = findViewById(R.id.edEmail);
        senhaEditText = findViewById(R.id.edSenha);
        Button loginButton = findViewById(R.id.btLogin);
        Button cadastroButton = findViewById(R.id.btCadastro);

        dbHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarLogin();
            }
        });

        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, Cadastro.class);
                startActivity(intent);
            }
        });
    }

    private void verificarLogin() {
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE email=? AND senha=?", new String[]{email, senha});

        if (cursor.moveToFirst()) {
            Intent intent = new Intent(login.this, Catalogo.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }
}
