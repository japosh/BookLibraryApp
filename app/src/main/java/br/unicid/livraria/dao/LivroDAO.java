package br.unicid.livraria.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.unicid.livraria.domain.Livro;
import br.unicid.livraria.util.DatabaseFactory;

public class LivroDAO {

    private Context context;

    public LivroDAO(Context context){
        this.context = context;
    }



    public void create(Livro livro) {

        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "INSERT INTO Livro VALUES (?, ?, ?)";
        String params[] = {Livro.getRgm(), Livro.getNome(), Livro.getEmail()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void update(Livro livro) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "UPDATE Livro SET nome = ?, email = ? WHERE rgm = ?";
        String params[] = {Livro.getNome(), Livro.getEmail(), Livro.getRgm()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void delete(String rgm) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "DELETE FROM Livro WHERE rgm = ?";
        String params[] = {rgm};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public Livro findByRgm(String rgm) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM Livro WHERE rgm = ?";
        String params[] = {rgm};
        Cursor rs = db.rawQuery(sql, params);

        Livro Livro = null;

        if (rs.moveToNext()) {
            Livro = new Livro();
            Livro.setRgm(rs.getString(0)); //campo rgm
            Livro.setNome(rs.getString(1)); //campo nome
            Livro.setEmail(rs.getString(2)); //campo email
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto Livro
        return Livro;
    }

    public List<Livro> findAll() {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM Livro";
        Cursor rs = db.rawQuery(sql, null);

        //Criando um objeto Lista de Livros (vazia)
        List<Livro> Livros = new ArrayList<>();

        //Enquanto houver linhas registros...
        while (rs.moveToNext()) {
            //Cria um objeto Livro, preencha com os dados da linha
            Livro Livro = new Livro();
            Livro.setRgm(rs.getString(0)); //campo rgm
            Livro.setNome(rs.getString(1)); //campo nome
            Livro.setEmail(rs.getString(2)); //campo email

            //Adiciona o objeto à lista
            Livros.add(Livro);
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto Livro
        return Livros;
    }


}
