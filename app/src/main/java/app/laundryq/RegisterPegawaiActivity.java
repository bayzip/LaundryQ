package app.laundryq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterPegawaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pegawai);
    }

    public void Register(View view) {
        Intent register = new Intent(this, LoginActivity.class);
        startActivity(register);
    }

    public void Login(View view) {
        Intent login = new Intent(this, LoginPegawaiActivity.class);
        startActivity(login);
    }
}
