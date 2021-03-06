package br.com.viagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.viagens.model.Pacote;
import br.com.viagens.util.Constantes;

public class DetalhePacoteActivity extends AppCompatActivity {

    private TextView cidade;
    private TextView preco;
    private TextView dias;
    private TextView periodo;
    private ImageView banner;
    private Button btnFinalizarCompra;

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pacote);

        initViews();

        montarDetalhe();
    }

    private void initViews() {
        cidade = findViewById(R.id.txt_detalhe_cidade);
        preco = findViewById(R.id.txt_detalhe_preco);
        dias = findViewById(R.id.txt_detalhe_dias);
        periodo = findViewById(R.id.txt_detalhe_periodo);

        banner = findViewById(R.id.img_detalhe_pacote);

        btnFinalizarCompra = findViewById(R.id.btn_finalizar_pagamento);
        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhePacoteActivity.this, DetalhePagamentoActivity.class);
                intent.putExtra(Constantes.PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void montarDetalhe() {
        Intent intent = getIntent();
        if (intent.hasExtra(Constantes.PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(Constantes.PACOTE);
            cidade.setText(pacote.getCidade());
            if (pacote.getDias() > 1) {
                dias.setText(pacote.getDias() + getString(Constantes.LABEL_INF_DIAS));
            } else {
                dias.setText(pacote.getDias() + getString(Constantes.LABEL_INF_DIA));
            }
            NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale(
                    getResources().getConfiguration().locale.getLanguage(),
                    getResources().getConfiguration().locale.getCountry()));
            preco.setText(format.format(pacote.getPreco()).replace(Constantes.MOEDA, Constantes.MOEDA_ESPACO));

            banner.setImageDrawable(getResources().getDrawable(getResources()
                    .getIdentifier(pacote.getImagem(), Constantes.DRAWABLE, getPackageName())));

            Calendar calendar = Calendar.getInstance();
            Calendar volta = Calendar.getInstance();
            volta.add(Calendar.DATE, pacote.getDias());
            SimpleDateFormat formatData = new SimpleDateFormat("dd/MM");
            periodo.setText(formatData.format(calendar.getTime()) + " " + formatData.format(volta.getTime()) +
                    " de " + volta.get(Calendar.YEAR));
        }
    }
}
