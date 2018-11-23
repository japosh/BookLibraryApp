package br.unicid.livraria.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.unicid.livraria.R;
import br.unicid.livraria.domain.Livro;

public class LivrosAdapter extends BaseAdapter {

    private Context context;

    private List<Livro> livros;


    public LivrosAdapter(Context context, ArrayList<Livro> livros){
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = LayoutInflater.from(context).inflate(R.layout.livro_item, null);

        Livro l = livros.get(position);

        //Não sei como colocar esse lbl dentro do list view
        TextView titulo = (TextView) item.findViewById(R.id.lblTitulo);

        titulo.setText(l.getTitulo());

        return item;
    }
}