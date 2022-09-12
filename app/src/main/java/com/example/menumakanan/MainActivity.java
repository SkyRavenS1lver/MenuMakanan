package com.example.menumakanan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String Encrypt1 = "eunch";
    EditText menuPesan;
    Button makanan;
    Button minuman;
    TextView jumlah;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode() == RESULT_OK){
                        String replytext = o.getData().getStringExtra(Menu.Encrypt2);
                        jumlah.setText(replytext);
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuPesan = findViewById(R.id.menuPesan);
        makanan = findViewById(R.id.makanan);
        minuman = findViewById(R.id.minuman);
        jumlah = findViewById(R.id.jumlah);

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesan = new Intent(v.getContext(), Menu.class);
                String ingpo1 = menuPesan.getText().toString();
                String ingpo2 = makanan.getText().toString();
                String[] ingpo = {ingpo1, ingpo2};
                pesan.putExtra(Encrypt1, ingpo);
                launcher.launch(pesan);}
            }
        );
        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesan = new Intent(v.getContext(), Menu.class);
                String ingpo1 = menuPesan.getText().toString();
                String ingpo2 = minuman.getText().toString();
                String[] ingpo = {ingpo1, ingpo2};
                pesan.putExtra(Encrypt1, ingpo);
                launcher.launch(pesan);
            }
        });
    }
}