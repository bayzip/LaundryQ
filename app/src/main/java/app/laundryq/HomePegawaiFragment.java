package app.laundryq;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class HomePegawaiFragment extends Fragment {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_pegawai, container, false);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.add_laundry);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AddLaundryActivity.class);
                startActivity(in);
            }
        });

        listView = (ListView) v.findViewById(R.id.pesanan_list);
        listView.setDivider(null);

        CurrentLaundryAdapter currentLaundryAdapter = new CurrentLaundryAdapter(getActivity().getApplicationContext());
        listView.setAdapter(currentLaundryAdapter);

        return v;
    }

    public void confirmationClicked(View v) {
        Toast.makeText(getContext(), "Order Baru Ditambahkan", Toast.LENGTH_LONG).show();
    }
}
