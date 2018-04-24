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

    public void Login(View view){
        Intent login = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(login);
    }

    public void Register(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }
}
