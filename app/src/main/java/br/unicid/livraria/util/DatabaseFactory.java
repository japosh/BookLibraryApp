package br.unicid.livraria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseFactory {
    public static SQLiteDatabase getWritableDatabase(Context context) {

        //Criando o banco de dados ou abrindo um banco de dados existente
        SQLiteDatabase db = context.openOrCreateDatabase("livraria.db", Context.MODE_PRIVATE, null);


        String usuarioTable =
                "CREATE TABLE IF NOT EXISTS usuario (" +
                        "user VARCHAR(50) PRIMARY KEY," +
                        "pass VARCHAR(50) NOT NULL)";

        db.execSQL(usuarioTable);

        String livroTable =
                "CREATE TABLE IF NOT EXISTS livro (" +
                        "isbn VARCHAR(50) PRIMARY KEY," +
                        "titulo VARCHAR(50) NOT NULL," +
                        "subTitulo VARCHAR(50)," +
                        "edicao VARCHAR(50) NOT NULL," +
                        "autor VARCHAR(50) NOT NULL," +
                        "quantPag VARCHAR(50) NOT NULL," +
                        "anoPub VARCHAR(50) NOT NULL," +
                        "editora VARCHAR(50) NOT NULL)";

        db.execSQL(livroTable);

        //Retornando a instância do banco de dados
        return db;
    }
}
