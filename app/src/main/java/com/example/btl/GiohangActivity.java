package com.example.btl;

import android.content.Intent;
import android.os.Bundle;

import com.example.btl.adapter.GiohangAdapter;
import com.example.btl.model.Giohang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class GiohangActivity extends AppCompatActivity {
    ListView lvgiohang;
    TextView tvthongbao;
    TextView tvTongtien;
    Button btthanhtoan, bttieptucmua;
    Toolbar toolbargiohang;
    GiohangAdapter giohangAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        anhxa();
        ActionToolbar();
        checkdata();
        Tinhtien();

        bttieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiohangActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Tinhtien() {
        long tongtien = 0;
        for(int i = 0; i<MainActivity.giohangArrayList.size();i++){
            tongtien += MainActivity.giohangArrayList.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvTongtien.setText(decimalFormat.format(tongtien)+ " Đ");
    }

    private void checkdata() {
        if(MainActivity.giohangArrayList.size()<=0){
            giohangAdapter.notifyDataSetChanged();
            tvthongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);
        }else {
            giohangAdapter.notifyDataSetChanged();
            tvthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_media_rew);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void anhxa() {
        lvgiohang = findViewById(R.id.lvgiohang);
        tvthongbao = findViewById(R.id.tvthongbao);
        tvTongtien = findViewById(R.id.tvtongtien);
        btthanhtoan = findViewById(R.id.btthanhtoan);
        bttieptucmua = findViewById(R.id.bttieptucmua);
        toolbargiohang = findViewById(R.id.tbgiohang);
        giohangAdapter = new GiohangAdapter(GiohangActivity.this,MainActivity.giohangArrayList);
        lvgiohang.setAdapter(giohangAdapter);
    }

}
