package app.laundryq;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        CustomAdapter adapter = new CustomAdapter(this);
        ImageView detailFoto = (ImageView) findViewById(R.id.detail_foto);
        TextView detailStatus = (TextView) findViewById(R.id.detail_status);
        TextView detailID = (TextView) findViewById(R.id.detail_id);
        TextView detailToko = (TextView) findViewById(R.id.detail_toko);
        TextView detailRating = (TextView) findViewById(R.id.detail_rating);
        TextView detailLayanan = (TextView) findViewById(R.id.detail_layanan);
        TextView detailNomorPesanan = (TextView) findViewById(R.id.detail_no_pesanan);
        TextView detailBerat = (TextView) findViewById(R.id.detail_berat);
        TextView detailHarga = (TextView) findViewById(R.id.detail_harga);
        TextView detailParfum = (TextView) findViewById(R.id.detail_parfum);

        Double d = new Double((adapter.berat[position] * 4000));
        int biaya = d.intValue();

        detailFoto.setImageResource(adapter.fotoToko[position]);
        detailStatus.setText(adapter.status[position]);
        detailToko.setText(adapter.namaToko[position]);
        detailBerat.setText("" + adapter.berat[position] + "kg");
        detailHarga.setText("Rp. " + biaya);
        detailID.setText("Id " + adapter.id[position]);
        detailRating.setText("Rating : " + adapter.rating[position] + " / 5");
        detailLayanan.setText(adapter.layanan[position]);
        detailNomorPesanan.setText(adapter.noPesanan[position]);
        detailParfum.setText(adapter.parfum[position]);

        if (adapter.status[position] == "Dalam Proses") detailStatus.setBackgroundColor(Color.parseColor("#fdd835"));
        else if (adapter.status[position] == "Sukses") detailStatus.setBackgroundColor(Color.parseColor("#64dd17"));
        else if (adapter.status[position] == "Batal") detailStatus.setBackgroundColor(Color.parseColor("#dd2c00"));
    }
}
