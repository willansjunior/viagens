package br.com.viagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.viagens.model.Pacote;
import br.com.viagens.util.Constantes;

public class DetalhePagamentoActivity extends AppCompatActivity {

    private TextView txtPreco;

    private EditText edtNumeroCartao;
    private EditText edtMesCartao;
    private EditText edtAnoCartao;
    private EditText edtCVCCartao;
    private EditText edtNomeCartao;

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pagamento);

        initViews();

        montarDetalhe();
    }

    private void initViews() {
        txtPreco = findViewById(R.id.txt_pagamento_preco);

        edtNumeroCartao = findViewById(R.id.edt_pagamento_cartao);
        edtMesCartao = findViewById(R.id.edt_pagamento_mes_cartao);
        edtAnoCartao = findViewById(R.id.edt_pagamento_ano_cartao);
        edtCVCCartao = findViewById(R.id.edt_pagamento_cvc_cartao);
        edtNomeCartao = findViewById(R.id.edt_pagamento_nome_cartao);
    }

    private void montarDetalhe() {
        Intent intent = getIntent();
        pacote = (Pacote) intent.getSerializableExtra(Constantes.PACOTE);
        if (pacote != null) {
            NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale(
                    getResources().getConfiguration().locale.getLanguage(),
                    getResources().getConfiguration().locale.getCountry()));
            txtPreco.setText(format.format(pacote.getPreco()).replace("R$", "R$ "));
        }
    }
}
