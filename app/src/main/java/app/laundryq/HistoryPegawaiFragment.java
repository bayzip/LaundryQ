package app.laundryq;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HistoryPegawaiFragment extends Fragment {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history_pegawai, container, false);
        listView = (ListView) v.findViewById(R.id.history_laundry_list);
        listView.setDivider(null);

        HistoryLaundryAdapter historyLaundryAdapter = new HistoryLaundryAdapter(getActivity().getApplicationContext());
        listView.setAdapter(historyLaundryAdapter);

        return v;
    }
}
