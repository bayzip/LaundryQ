package app.laundryq;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddLaundryActivity extends AppCompatActivity {

    int hargaPerKilo = 3000;
    int beratCucianInt = 0;
    int hargaSepatu = 10000;
    int hargaSelimut = 10000;
    int hargaTas = 20000;
    int totalHarga = 0;
    boolean[] hargaTambahanArr = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_laundry);

        final EditText beratCucian = (EditText) findViewById(R.id.berat_cucian);
        final TextView hargaKilo = (TextView) findViewById(R.id.harga_kilo);
        final CheckBox sepatu = (CheckBox) findViewById(R.id.sepatu_cb);
        final TextView totalHargaView = (TextView) findViewById(R.id.total_harga);
        final TextView hargaTambahan = (TextView) findViewById(R.id.harga_tambahan);
        final Button tambahLaundry = (Button) findViewById(R.id.tambah_laundry_btn);
        CheckBox selimut = (CheckBox) findViewById(R.id.selimut_cb);
        CheckBox tas = (CheckBox) findViewById(R.id.tas_cb);

        hargaKilo.setText(beratCucianInt + " kg x " + hargaPerKilo + " = Rp." + (beratCucianInt * hargaPerKilo));

        beratCucian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                hargaKilo.setText(beratCucianInt + " kg x " + hargaPerKilo + " = Rp." + (beratCucianInt * hargaPerKilo));
                totalHarga = beratCucianInt * hargaPerKilo;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (beratCucian.getText().toString().length() <= 0) beratCucianInt = 0;
                else beratCucianInt = Integer.parseInt(beratCucian.getText().toString());
                hargaKilo.setText(beratCucianInt + " kg x " + hargaPerKilo + " = Rp." + (beratCucianInt * hargaPerKilo));
                totalHarga = beratCucianInt * hargaPerKilo;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (beratCucian.getText().toString().length() <= 0) beratCucianInt = 0;
                else beratCucianInt = Integer.parseInt(beratCucian.getText().toString());
                hargaKilo.setText(beratCucianInt + " kg x " + hargaPerKilo + " = Rp." + (beratCucianInt * hargaPerKilo));
                totalHarga = beratCucianInt * hargaPerKilo;

                updateView(hargaTambahan, totalHargaView);
            }
        });

        sepatu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hargaTambahanArr[0] = true;
                    updateView(hargaTambahan, totalHargaView);
                } else if (!b) {
                    hargaTambahanArr[0] = false;
                    updateView(hargaTambahan, totalHargaView);
                }
            }
        });

        selimut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hargaTambahanArr[1] = true;
                    updateView(hargaTambahan, totalHargaView);
                } else if (!b) {
                    hargaTambahanArr[1] = false;
                    updateView(hargaTambahan, totalHargaView);
                }
            }
        });

        tas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hargaTambahanArr[2] = true;
                    updateView(hargaTambahan, totalHargaView);
                } else if (!b) {
                    hargaTambahanArr[2] = false;
                    updateView(hargaTambahan, totalHargaView);
                }
            }
        });

        tambahLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Order Baru Ditambahkan", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateView(TextView hargaTambahan, TextView totalHargaView) {
        int totalHargaTambahan = 0;
        hargaTambahan.setText("");

        if (hargaTambahanArr[0]) {
            hargaTambahan.setText(hargaTambahan.getText() + "+ Sepatu Rp." + hargaSepatu + "\n");
            totalHargaTambahan += hargaSepatu;
        }
        if (hargaTambahanArr[1]) {
            hargaTambahan.setText(hargaTambahan.getText() + "+ Selimut Rp." + hargaSelimut + "\n");
            totalHargaTambahan += hargaSelimut;
        }
        if (hargaTambahanArr[2]) {
            hargaTambahan.setText(hargaTambahan.getText() + "+ Tas Rp." + hargaTas + "\n");
            totalHargaTambahan += hargaTas;
        }

        totalHargaView.setText("TOTAL : Rp." + (totalHargaTambahan + totalHarga));
    }
}
