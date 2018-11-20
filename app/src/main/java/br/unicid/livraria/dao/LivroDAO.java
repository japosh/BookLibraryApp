package br.unicid.livraria.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.unicid.livraria.domain.Livro;
import br.unicid.livraria.util.DatabaseFactory;

public class LivroDAO {

    private Context context;

    public LivroDAO(Context context) {
        this.context = context;
    }


    public void create(Livro livro) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "INSERT INTO livro VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String params[] = {livro.getIsbn(), livro.getTitulo(), livro.getSubTitulo(), livro.getEdicao(), livro.getAutor(), livro.getQuantPag(), livro.getAnoPub(), livro.getEditora()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void update(Livro livro) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "UPDATE livro SET titulo = ?, subTitulo = ?, edicao = ?, autor = ?, quantPag = ?, anoPub = ?, editora = ? WHERE isbn = ?";
        String params[] = {livro.getTitulo(), livro.getSubTitulo(), livro.getEdicao(), livro.getAutor(), livro.getQuantPag(), livro.getAnoPub(), livro.getEditora(), livro.getIsbn()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void delete(String isbn) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "DELETE FROM livro WHERE isbn = ?";
        String params[] = {isbn};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public Livro  findByIsbn(String isbn) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        String params[] = {isbn};
        Cursor rs = db.rawQuery(sql, params);

        Livro livro = null;

        if (rs.moveToNext()) {
            livro = new Livro();
            livro.setIsbn(rs.getString(0));
            livro.setTitulo(rs.getString(1));
            livro.setSubTitulo(rs.getString(2));
            livro.setEdicao(rs.getString(3));
            livro.setAutor(rs.getString(4));
            livro.setQuantPag(rs.getString(5));
            livro.setAnoPub(rs.getString(6));
            livro.setEditora(rs.getString(7));
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return livro;
    }

    public List <Livro> findAll() {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM livro";
        Cursor rs = db.rawQuery(sql, null);

        //Criando um objeto Lista de alunos (vazia)
        List <Livro> livros = new ArrayList<>();

        //Enquanto houver linhas registros...
        while (rs.moveToNext()) {
            //Cria um objeto aluno, preencha com os dados da linha
            Livro livro = new Livro();
            livro.setIsbn(rs.getString(0));
            livro.setTitulo(rs.getString(1));
            livro.setSubTitulo(rs.getString(2));
            livro.setEdicao(rs.getString(3));
            livro.setAutor(rs.getString(4));
            livro.setQuantPag(rs.getString(5));
            livro.setAnoPub(rs.getString(6));
            livro.setEditora(rs.getString(7));

            //Adiciona o objeto à lista
            livros.add(livro);
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return livros;
    }
}
