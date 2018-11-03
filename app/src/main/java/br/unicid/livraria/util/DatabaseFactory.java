package br.unicid.livraria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseFactory {
    public static SQLiteDatabase getDatabase(Context context) {
        //Criando o banco de dados ou abrindo um banco de dados existente
        SQLiteDatabase db = context.openOrCreateDatabase("db_acad", Context.MODE_PRIVATE, null);

        //Criando a tabela Aluno
        String sqlTable =
                "CREATE TABLE IF NOT EXISTS aluno (" +
                        "rgm VARCHAR(8) PRIMARY KEY," +
                        "nome VARCHAR(50) NOT NULL," +
                        "email VARCHAR(50))";

        db.execSQL(sqlTable);

        //Retornando a instância do banco de dados
        return db;
    }
}
