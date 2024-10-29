package br.ulbra.apphamburgueria;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    EditText nomeEditText, emailEditText, senhaEditText, telefoneEditText;
    DatabaseHelper dbHelper;
    Button cadastroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        nomeEditText = findViewById(R.id.edNome);
        emailEditText = findViewById(R.id.edEmail);
        senhaEditText = findViewById(R.id.edSenha);
        telefoneEditText = findViewById(R.id.edTelefone);
        Button cadastrarButton = findViewById(R.id.btCadastro);

        dbHelper = new DatabaseHelper(this);

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        String telefone = telefoneEditText.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("senha", senha);
        values.put("telefone", telefone);

        long id = db.insert("usuarios", null, values);
        if (id != -1) {
            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
        }
    }
}
