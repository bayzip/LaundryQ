package app.laundryq;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context c;
    int[] fotoToko = {R.drawable.edward, R.drawable.adin, R.drawable.sofyan, R.drawable.ashil, R.drawable.rachmad, R.drawable.muhammad};
    String[] namaToko = {"Edward Laundry", "Adin Laundry", "Sofyan Laundry", "Ashil Laundry", "Rachmad Laundry", "Muhammad Laundry"};
    String[] tanggal = {"02 April 2018", "30 Maret 2018", "28 Maret 2018", "24 Maret 2018", "22 Maret 2018", "2 Maret 2018"};
    double[] berat = {5, 4.5, 3, 2.2, 3, 3.2};
    String[] status = {"Dalam Proses", "Selesai", "Selesai", "Selesai", "Selesai", "Batal"};
    String[] id = {"000001", "000002", "000003", "000004", "000005", "000006"};
    String[] noPesanan = {"0023", "0123", "0081", "0010", "0002", "0003"};
    String[] parfum = {"Lavender", "Aqua", "Sakura", "Sakura", "Lavender", "Sakura"};
    String[] layanan = {"Normal", "Normal", "Normal", "Normal", "Normal", "Normal"};
    int[] rating = {4, 4, 5, 5, 3, 4};


    public CustomAdapter (Context ctx) {
        this.c = ctx;
    }

    @Override
    public int getCount() {
        return namaToko.length;
    }

    @Override
    public Object getItem(int i) {
        return namaToko[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.riwayat_list_layout, null);

        ImageView mFotoToko = convertView.findViewById(R.id.foto_toko);
        TextView mNamaToko = convertView.findViewById(R.id.nama_toko);
        TextView mTanggal = convertView.findViewById(R.id.tanggal);
        TextView mBeratBiaya = convertView.findViewById(R.id.berat_biaya);
        TextView mStatus = convertView.findViewById(R.id.status);

        Double d = new Double(berat[i] * 4000);
        int ribuan = d.intValue()/1000;
        int ratusan = d.intValue()%1000;

        if (ratusan == 0) mBeratBiaya.setText(berat[i] + "kg - Rp." + ribuan + ".000");
        else mBeratBiaya.setText(berat[i] + "kg - Rp." + ribuan + "." + ratusan);

        mFotoToko.setImageResource(fotoToko[i]);
        mNamaToko.setText(namaToko[i]);
        mTanggal.setText(tanggal[i]);
        mStatus.setText(status[i]);
        if (status[i] == "Dalam Proses") mStatus.setBackgroundColor(Color.parseColor("#fdd835"));
        else if (status[i] == "Sukses") mStatus.setBackgroundColor(Color.parseColor("#64dd17"));
        else if (status[i] == "Batal") mStatus.setBackgroundColor(Color.parseColor("#dd2c00"));

        return convertView;
    }
}

