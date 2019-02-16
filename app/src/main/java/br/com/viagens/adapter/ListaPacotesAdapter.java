package br.com.viagens.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.viagens.R;
import br.com.viagens.model.Pacote;

/**
 * Created by willans on 15/02/19.
 */
public class ListaPacotesAdapter extends BaseAdapter {

    public static final String DRAWABLE = "drawable";
    public static final int LABEL_INF_DIAS = R.string.label_inf_dias;
    public static final int LABEL_INF_DIA = R.string.label_inf_dia;
    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(Context context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int i) {
        return pacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewGroup = LayoutInflater.from(context).inflate(R.layout.item_adapter_pacotes,
                parent, false);

        Pacote pacote = pacotes.get(i);

        TextView cidade = viewGroup.findViewById(R.id.txt_cidade);
        TextView dias = viewGroup.findViewById(R.id.txt_dias);
        TextView preco = viewGroup.findViewById(R.id.txt_preco);
        ImageView foto = viewGroup.findViewById(R.id.img_pacote);

        carregarDados(pacote, cidade, dias, preco, foto);

        return viewGroup;
    }

    private void carregarDados(Pacote pacote, TextView cidade, TextView dias, TextView preco, ImageView foto) {
        cidade.setText(pacote.getCidade());
        if (pacote.getDias() > 1) {
            dias.setText(pacote.getDias() + context.getString(LABEL_INF_DIAS));
        } else {
            dias.setText(pacote.getDias() + context.getString(LABEL_INF_DIA));
        }
        NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
        preco.setText(format.format(pacote.getPreco()).replace("R$", "R$ "));

        foto.setImageDrawable(context.getResources().getDrawable(context.getResources()
                .getIdentifier(pacote.getImagem(), DRAWABLE, context.getPackageName())));
    }

}
