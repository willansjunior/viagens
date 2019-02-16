package br.com.viagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.viagens.adapter.ListaPacotesAdapter;
import br.com.viagens.dao.PacoteDAO;
import br.com.viagens.model.Pacote;

public class MainActivity extends AppCompatActivity {

    public static final int LABEL_PACOTE_VIAGENS = R.string.label_pacote_viagens;

    private ListView lvPacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(LABEL_PACOTE_VIAGENS);

        initViews();
    }

    private void initViews() {
        lvPacotes = findViewById(R.id.lv_pacotes);
        List<Pacote> pacotes = new PacoteDAO().lista();
        lvPacotes.setAdapter(new ListaPacotesAdapter(this, pacotes));

        lvPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pacote pacote = (Pacote) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this, DetalhePacoteActivity.class);
                intent.putExtra("pacote", pacote);
                startActivity(intent);
            }
        });
    }
}
