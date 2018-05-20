package app.laundryq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Pelanggan(View view){
        Intent pelanggan = new Intent(LoginActivity.this, LoginPelangganActivity.class);
        startActivity(pelanggan);
    }

    public void Pegawai(View view) {
        Intent pegawai = new Intent(LoginActivity.this, LoginPegawaiActivity.class);
        startActivity(pegawai);
    }
}
