package br.unicid.livraria.domain;

public class Livro {

    private String isbn;
    private String titulo;
    private String subTitulo;
    private String edicao;
    private String autor;
    private String quantPag;
    private String anoPub;
    private String editora;

    public Livro() {

    }

    public Livro(String isbn, String titulo, String subTitulo, String edicao, String autor, String quantPag, String anoPub, String editora) {

    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
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

    public String getQuantPag() {
        return quantPag;
    }

    public void setQuantPag(String quantPag) {
        this.quantPag = quantPag;
    }

    public String getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(String anoPub) {
        this.anoPub = anoPub;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


    @Override
    public String toString() {
        return "{" + isbn + ", " + titulo + ", " + subTitulo + ", " + edicao + ", " + autor + ", " + quantPag + ", " + anoPub + ", " + editora +"}";
    }

}
