package br.unicid.livraria.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.unicid.livraria.domain.Livro;
import br.unicid.livraria.util.DatabaseFactory;

public class LivroDAO {

    private Context context;

    public LivroDAO(Context context) {
        this.context = context;
    }


    public void create(Aluno aluno) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "INSERT INTO aluno VALUES (?, ?, ?)";
        String params[] = {aluno.getRgm(), aluno.getNome(), aluno.getEmail()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void update(Aluno aluno) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "UPDATE aluno SET nome = ?, email = ? WHERE rgm = ?";
        String params[] = {aluno.getNome(), aluno.getEmail(), aluno.getRgm()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void delete(String rgm) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "DELETE FROM aluno WHERE rgm = ?";
        String params[] = {rgm};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public Aluno findByRgm(String rgm) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM aluno WHERE rgm = ?";
        String params[] = {rgm};
        Cursor rs = db.rawQuery(sql, params);

        Aluno aluno = null;

        if (rs.moveToNext()) {
            aluno = new Aluno();
            aluno.setRgm(rs.getString(0)); //campo rgm
            aluno.setNome(rs.getString(1)); //campo nome
            aluno.setEmail(rs.getString(2)); //campo email
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return aluno;
    }

    public List<Aluno> findAll() {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM aluno";
        Cursor rs = db.rawQuery(sql, null);

        //Criando um objeto Lista de alunos (vazia)
        List<Aluno> alunos = new ArrayList<>();

        //Enquanto houver linhas registros...
        while (rs.moveToNext()) {
            //Cria um objeto aluno, preencha com os dados da linha
            Aluno aluno = new Aluno();
            aluno.setRgm(rs.getString(0)); //campo rgm
            aluno.setNome(rs.getString(1)); //campo nome
            aluno.setEmail(rs.getString(2)); //campo email

            //Adiciona o objeto à lista
            alunos.add(aluno);
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return alunos;
    }
}
