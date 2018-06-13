package app.laundryq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CurrentLaundryAdapter extends BaseAdapter {
    Context c;
    String[] nama = {"Sofyan Aji", "Rachmad Eko", "Ashil Al Latief"};
    String[] tglAwal = {"21 Mei 2018", "19 Mei 2018", "19 Mei 2018"};
    String[] tglAkhir = {"22 Mei 2018", "21 Mei 2018", "20 Mei 2018"};

    public CurrentLaundryAdapter(Context ctx) {
        this.c = ctx;
    }

    @Override
    public int getCount() {
        return nama.length;
    }

    @Override
    public Object getItem(int i) {
        return nama[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.current_laundry, null);

        TextView name = (TextView) convertView.findViewById(R.id.nama_pemesan);
        TextView tanggalMulai = (TextView) convertView.findViewById(R.id.tanggal_mulai);
        TextView tanggalSelesai = (TextView) convertView.findViewById(R.id.tanggal_selesai);

        name.setText(nama[i]);
        tanggalMulai.setText(tglAwal[i]);
        tanggalSelesai.setText(tglAkhir[i]);

        return convertView;
    }
}
