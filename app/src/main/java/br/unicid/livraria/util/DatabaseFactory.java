package br.unicid.livraria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseFactory {
    public static SQLiteDatabase getDatabase(Context context) {

        //Criando o banco de dados ou abrindo um banco de dados existente
        SQLiteDatabase db = context.openOrCreateDatabase("livraria.db", Context.MODE_PRIVATE, null);

        //Retornando a instância do banco de dados
        return db;
    }
}
