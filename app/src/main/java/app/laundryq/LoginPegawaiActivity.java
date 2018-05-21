package app.laundryq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginPegawaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pegawai);
    }

    public void Login(View view){
        Intent login = new Intent(LoginPegawaiActivity.this, MainPegawaiActivity.class);
        startActivity(login);
    }

    public void Register(View view) {
        Intent register = new Intent(this, RegisterPegawaiActivity.class);
        startActivity(register);
    }
}
