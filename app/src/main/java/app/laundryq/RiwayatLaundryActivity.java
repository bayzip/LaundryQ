package app.laundryq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Text;

public class RiwayatLaundryActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_laundry);
        mListView = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter(this);
        mListView.setAdapter(customAdapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), DetailLaundry.class);
//                intent.putExtra("position", i);
//
//                startActivity(intent);
//            }
//        });
    }
}
