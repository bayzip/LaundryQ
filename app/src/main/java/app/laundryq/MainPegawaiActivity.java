package app.laundryq;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainPegawaiActivity extends AppCompatActivity {
    private Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home_pegawai:
                    fragment = new HomePegawaiFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_history_pegawai:
                    fragment = new HistoryPegawaiFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile_pegawai:
                    fragment = new ProfilePegawaiFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pegawai);

        BottomNavigationView navigation = findViewById(R.id.navigation_pegawai);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Load the HomeFragment when app is loaded
        fragment = new HomePegawaiFragment();
        loadFragment(fragment);

        //Hide the Bottom Navigation when the page is scrolled
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new ScrollHandler());


    }

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        //Close the application when back button is pressed
        finish();
    }
}
