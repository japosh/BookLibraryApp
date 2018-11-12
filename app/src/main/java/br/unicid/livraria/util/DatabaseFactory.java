package br.unicid.livraria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseFactory {
    public static SQLiteDatabase getDatabase(Context context) {

        //Criando o banco de dados ou abrindo um banco de dados existente
        SQLiteDatabase db = context.openOrCreateDatabase("livraria", Context.MODE_PRIVATE, null);

        //Criando a tabela Usuario
        String sqlTable =
                "CREATE TABLE IF NOT EXISTS usuario (" +
                        "user VARCHAR(8) PRIMARY KEY," +
                        "pass VARCHAR(50) NOT NULL)";

        db.execSQL(sqlTable);

        //Retornando a instância do banco de dados
        return db;
    }
}
