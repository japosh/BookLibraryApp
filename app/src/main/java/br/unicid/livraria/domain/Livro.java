package br.unicid.livraria.domain;

public class Livro {
    private String user;
    private String pass;

    private String title;
    private String subtitle;
    private String isbnt;
    private String edicao;
    private String autor;
    private String paginas;
    private String anopub;
    private String editora;
    private String categoria;

    public Livro() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public String getIsbnt() {
        return isbnt;
    }

    public void setIsbnt(String isbnt) {
        this.isbnt = isbnt;
    }


    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }


    public String getAnopub() {
        return anopub;
    }

    public void setAnopub(String anopub) {
        this.anopub = anopub;
    }


    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
