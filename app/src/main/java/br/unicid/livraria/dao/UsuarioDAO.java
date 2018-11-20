package br.unicid.livraria.dao;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.ArrayList;
        import java.util.List;

        import br.unicid.livraria.domain.Usuario;
        import br.unicid.livraria.util.DatabaseFactory;

public class UsuarioDAO {

    private Context context;

    public UsuarioDAO(Context context) {
        this.context = context;
    }

    public void create(Usuario usuario) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "INSERT INTO usuario VALUES (?, ?)";
        String params[] = {usuario.getUser(), usuario.getPass()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void update(Usuario usuario) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "UPDATE usuario SET pass = ? WHERE user = ?";
        String params[] = {usuario.getPass(), usuario.getUser()};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public void delete(String usuario) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL
        String sql = "DELETE FROM usuario WHERE usuario = ?";
        String params[] = {usuario};
        db.execSQL(sql, params);

        //Fechando o banco de dados
        db.close();
    }

    public Usuario findByUser(String user, String pass) {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM usuario WHERE user = ? AND pass = ?";
        String params[] = {user, pass};
        Cursor rs = db.rawQuery(sql, params);

        Usuario usuario = null;

        if (rs.moveToNext()) {
            usuario = new Usuario();
            usuario.setUser(rs.getString(0));
            usuario.setPass(rs.getString(1));
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return usuario;
    }

    public List<Usuario> findAll() {
        //Obtendo o objeto que representa o banco de dados
        SQLiteDatabase db = DatabaseFactory.getWritableDatabase(context);

        //Preparando e executando o comando SQL e obtendo os dados
        String sql = "SELECT * FROM usuario";
        Cursor rs = db.rawQuery(sql, null);

        //Criando um objeto Lista de alunos (vazia)
        List<Usuario> usuarios = new ArrayList<>();

        //Enquanto houver linhas registros...
        while (rs.moveToNext()) {
            //Cria um objeto aluno, preencha com os dados da linha
            Usuario usuario = new Usuario();
            usuario.setUser(rs.getString(0)); //campo usuario(login)
            usuario.setPass(rs.getString(1)); //campo senha

            //Adiciona o objeto à lista
            //usuario.add(usuario);
        }

        //Fechando o banco de dados
        db.close();

        //Retornando o objeto aluno
        return usuarios;
    }
}


