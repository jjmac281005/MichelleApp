package edu.uph.m23si2.michelleapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnTambah, btnKali, btnBagi;
    TextView txvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        txvHasil = findViewById(R.id.txvHasil);

        btnTambah.setOnClickListener(v -> hitung("tambah"));
        btnKali.setOnClickListener(v -> hitung("kali"));
        btnBagi.setOnClickListener(v -> hitung("bagi"));
    }

    private void hitung(String operasi) {
        try {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int hasil;

            if (operasi.equals("tambah")) {
                hasil = a + b;
                txvHasil.setText(String.valueOf(hasil));
            } else if (operasi.equals("kali")) {
                hasil = a * b;
                txvHasil.setText(String.valueOf(hasil));
            } else if (operasi.equals("bagi")) {
                if (b == 0) {
                    txvHasil.setText("Tidak bisa dibagi 0");
                } else {
                    hasil = a / b;
                    txvHasil.setText(String.valueOf(hasil));
                }
            } else {
                txvHasil.setText("Operasi tidak dikenali");
            }

        } catch (NumberFormatException e) {
            txvHasil.setText("Input tidak valid");
        }
    }
}
