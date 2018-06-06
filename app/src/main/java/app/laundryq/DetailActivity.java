package app.laundryq;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        final CustomAdapter adapter = new CustomAdapter(this);
        final TextView detailStatus = (TextView) findViewById(R.id.detail_status);
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

        detailStatus.setText(adapter.status[position]);
        detailToko.setText(adapter.namaToko[position]);
        detailBerat.setText("" + adapter.berat[position] + "kg");
        detailHarga.setText("Rp. " + biaya);
        detailID.setText("Id " + adapter.id[position]);
        detailRating.setText("Rating : " + adapter.rating[position] + " / 5");
        detailLayanan.setText(adapter.layanan[position]);
        detailNomorPesanan.setText(adapter.noPesanan[position]);
        detailParfum.setText(adapter.parfum[position]);

        final Button konfirmasi = (Button) findViewById(R.id.konfirmasi_pengambilan_btn);
        konfirmasi.setText("Konfirmasi Pengambilan Laundry");
        konfirmasi.setEnabled(true);

        if (adapter.status[position] == "Dalam Proses") {
            detailStatus.setBackgroundColor(Color.parseColor("#fdd835"));
            konfirmasi.setText("Konfirmasi Pengambilan Laundry");
            konfirmasi.setEnabled(true);
        }
        else if (adapter.status[position] == "Selesai") {
            detailStatus.setBackgroundColor(Color.parseColor("#64dd17"));
            konfirmasi.setText("Laundry Telah Diambil");
            konfirmasi.setEnabled(false);
            konfirmasi.setTextColor(Color.parseColor("#000000"));
        }
        else if (adapter.status[position] == "Batal") {
            detailStatus.setBackgroundColor(Color.parseColor("#dd2c00"));
            konfirmasi.setText("Proses Laundry Dibatalkan");
            konfirmasi.setEnabled(false);
            konfirmasi.setTextColor(Color.parseColor("#000000"));
        }

        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                builder.setTitle("Konfirmasi Pengambilan");
                builder.setMessage("Apakah Anda ingin mengonfirmasi telah mengambil laundry?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        Toast.makeText(getApplicationContext(), "Laundry Telah Diambil", Toast.LENGTH_LONG).show();

                        adapter.status[position] = "Selesai";
                        detailStatus.setText(adapter.status[position]);
                        detailStatus.setBackgroundColor(Color.parseColor("#64dd17"));
                        konfirmasi.setText("Laundry Telah Diambil");
                        konfirmasi.setEnabled(false);
                        konfirmasi.setTextColor(Color.parseColor("#000000"));
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}
