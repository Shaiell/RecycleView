package br.ici.treinamento.recycleview.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ici.treinamento.recycleview.Activity.RecyclerItemClickListener;
import br.ici.treinamento.recycleview.Activity.adapter.Adapter;
import br.ici.treinamento.recycleview.Activity.model.Filme;
import br.ici.treinamento.recycleview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //LISTAGEM DE FILMES

        this.criarFilmes();

        // CONFIRGURAR ADAPTER

        Adapter adapter = new Adapter(listaFilmes);

        // CONFIGURAR RECYCLEVIEW

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Item Pressionado: " +filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Click Longo: "+ filme.getAno(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    public void criarFilmes(){
         Filme filme = new Filme("Casa do Lago","Ação","2010");
         this.listaFilmes.add(filme);

        filme = new Filme("Amanhecer ","Terror","2016");
        this.listaFilmes.add(filme);

        filme = new Filme("Amor à Segunda Vista","Romance","2014");
        this.listaFilmes.add(filme);

        filme = new Filme("Última Música","Ação","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Trilha ","Terror","2019");
        this.listaFilmes.add(filme);

        filme = new Filme("A Mentir","Ação","2002");
        this.listaFilmes.add(filme);

        filme = new Filme("A Rede Social","Suspense","2011");
        this.listaFilmes.add(filme);

        filme = new Filme("Alma de Campeão","Romance","2012");
        this.listaFilmes.add(filme);

        filme = new Filme("A Casa de Cera","Suspense","2015");
        this.listaFilmes.add(filme);

        filme = new Filme("Afinado no Amor","Ação","2014");
        this.listaFilmes.add(filme);

        filme = new Filme("A Lenda do Tesouro Perdido","Romance","2019");
        this.listaFilmes.add(filme);

        filme = new Filme("A Corrente do Bem","Terror","1964");
        this.listaFilmes.add(filme);
    }
}
