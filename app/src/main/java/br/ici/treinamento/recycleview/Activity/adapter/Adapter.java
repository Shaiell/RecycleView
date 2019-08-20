package br.ici.treinamento.recycleview.Activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ici.treinamento.recycleview.Activity.model.Filme;
import br.ici.treinamento.recycleview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewholder> {

    List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes=lista;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);
        return new MyViewholder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
