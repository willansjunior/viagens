package br.com.viagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.viagens.model.Pacote;
import br.com.viagens.util.Constantes;

public class ResumoCompraActivity extends AppCompatActivity {

    private TextView cidade;
    private TextView periodo;
    private TextView preco;

    private ImageView banner;

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        initViews();

        montarDetalhe();
    }

    private void initViews() {
        cidade = findViewById(R.id.txt_resumo_compra_cidade);
        periodo = findViewById(R.id.txt_resumo_compra_periodo);
        preco = findViewById(R.id.txt_resumo_compra_preco);

        banner = findViewById(R.id.img_resumo_compra_banner_pacote);
    }

    private void montarDetalhe() {
        Intent intent = getIntent();
        pacote = (Pacote) intent.getSerializableExtra(Constantes.PACOTE);
        if (pacote != null) {
            cidade.setText(pacote.getCidade());

            banner.setImageDrawable(getResources().getDrawable(getResources()
                    .getIdentifier(pacote.getImagem(), Constantes.DRAWABLE, getPackageName())));

            NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale(
                    getResources().getConfiguration().locale.getLanguage(),
                    getResources().getConfiguration().locale.getCountry()));
            preco.setText(format.format(pacote.getPreco()).replace(Constantes.MOEDA, Constantes.MOEDA_ESPACO));
        }

        Calendar calendar = Calendar.getInstance();
        Calendar volta = Calendar.getInstance();
        volta.add(Calendar.DATE, pacote.getDias());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM");
        periodo.setText(format.format(calendar.getTime()) + " " + format.format(volta.getTime()) +
                " de " + volta.get(Calendar.YEAR));
    }
}
