package com.example.bottomnavbar.KalkulatorBangunRuang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bottomnavbar.Fragments.BangunRuangFragment;
import com.example.bottomnavbar.KalkulatorBangunDatar.Square;
import com.example.bottomnavbar.R;

public class Block extends AppCompatActivity {
    EditText tbLenght, tbWidth, tbHeight;
    TextView tvResult;
    Button btnCount, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block);

        tbLenght = findViewById(R.id.tbLenght);
        tbWidth = findViewById(R.id.tbWidth);
        tbHeight = findViewById(R.id.tbHeight);
        tvResult = findViewById(R.id.tvResultBlock);
        btnCount = findViewById(R.id.btnCountBlock);
        btnBack = findViewById(R.id.btnBack);
        img = findViewById(R.id.imgBlock);

        Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Cuboid_simple.svg/1200px-Cuboid_simple.svg.png")
                                .into(img);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pString = tbLenght.getText().toString();
                String lString = tbWidth.getText().toString();
                String tString = tbHeight.getText().toString();

                if (pString.isEmpty() || lString.isEmpty() || tString.isEmpty()){
                    Toast.makeText(Block.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                }else {
                    double p = Double.parseDouble(pString);
                    double l = Double.parseDouble(lString);
                    double t = Double.parseDouble(tString);

                    if (p<l){
                        Toast.makeText(Block.this,"Nilai dari panjang tidak boleh lebih kecil dari pada lebar!",Toast.LENGTH_LONG).show();

                    } else {
                        double hasil = ((p*l)+(p*t)+(l*t))*2;
                        tvResult.setText(String.valueOf(hasil));
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
