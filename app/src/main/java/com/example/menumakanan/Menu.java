package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Menu extends AppCompatActivity {
    TextView menuTerpesan;
    TextView jenisMenu;
    EditText banyakBarang;
    Button ok;

    public static final String Encrypt2 = "euncchhh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuTerpesan = findViewById(R.id.menuTerpesan);
        jenisMenu = findViewById(R.id.jenisMenu);
        banyakBarang = findViewById(R.id.banyakBarang);
        ok = findViewById(R.id.ok);

        Intent getting = getIntent();
        String[] ingpoh= getting.getStringArrayExtra(MainActivity.Encrypt1);
        menuTerpesan.setText(ingpoh[0]);
        jenisMenu.setText(ingpoh[1]);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replying = new Intent();
                String msgReply = banyakBarang.getText().toString();
                replying.putExtra(Encrypt2, msgReply);
                setResult(RESULT_OK, replying);
                finish();
            }
        });
    }
}