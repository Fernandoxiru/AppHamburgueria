package br.ulbra.apphamburgueria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hamburgueria.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE usuarios (id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT, senha TEXT, telefone TEXT)";
        String createProductTable = "CREATE TABLE produtos (id_produto INTEGER PRIMARY KEY AUTOINCREMENT, nome_produto TEXT, descricao TEXT, preco REAL, categoria TEXT)";
        db.execSQL(createUserTable);
        db.execSQL(createProductTable);

        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Hambúrguer Clássico', 'Pão, carne, queijo e salada', 15.00, 'Hambúrguer')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Cheeseburger', 'Pão, carne, queijo, bacon e salada', 18.00, 'Hambúrguer')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('X-Burguer', 'Pão, carne, queijo e molho especial', 17.00, 'Hambúrguer')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Veggie Burger', 'Pão, hambúrguer de grão de bico e salada', 16.00, 'Hambúrguer')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Refrigerante', 'Refrigerante Lata', 5.00, 'Bebida')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Suco Natural', 'Suco de frutas', 7.00, 'Bebida')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Água Mineral', 'Água mineral 500ml', 3.00, 'Bebida')");
        db.execSQL("INSERT INTO produtos (nome_produto, descricao, preco, categoria) VALUES ('Cerveja', 'Cerveja Lata', 8.00, 'Bebida')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        onCreate(db);
    }
}
