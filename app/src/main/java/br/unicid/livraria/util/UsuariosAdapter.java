package br.unicid.livraria.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.unicid.livraria.domain.Usuario;
import br.unicid.livraria.R;

public class UsuariosAdapter extends BaseAdapter {
    private Context context;
    private List<Usuario> usuarios;

    public UsuariosAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = LayoutInflater.from(context).inflate(R.layout.usuario_item, null);

        //Usuario a = usuarios.get(position);

        //TextView user   = (TextView) item.findViewById(R.id.lblUser);
        //TextView pass  = (TextView) item.findViewById(R.id.lblPass);

        //rgm.setText(a.getRgm());
        //nome.setText(a.getNome());
        //email.setText(a.getEmail());

        return item;
    }
}

