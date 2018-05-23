package app.laundryq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HistoryLaundryAdapter extends BaseAdapter {
    Context c;
    String[] nama = {"Edward Chakim", "Bayu Adin"};
    String[] tglAkhir = {"20 Mei 2018", "18 Mei 2018"};

    public HistoryLaundryAdapter(Context ctx) {
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
        convertView = inflater.inflate(R.layout.history_laundry_layout, null);

        TextView name = (TextView) convertView.findViewById(R.id.nama_pemesan);
        TextView tanggalSelesai = (TextView) convertView.findViewById(R.id.tanggal_berakhir);

        name.setText(nama[i]);
        tanggalSelesai.setText(tglAkhir[i]);

        return convertView;
    }
}
