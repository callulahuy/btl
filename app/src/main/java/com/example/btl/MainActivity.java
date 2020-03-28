package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.btl.adapter.DoanAdapter;
import com.example.btl.api.ApiLayDoan;
import com.example.btl.interfaces.LayDLDoan;
import com.example.btl.model.DoAn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayDLDoan {
    GridView gvDSDoan;
    DoanAdapter adapter;
    ArrayList<DoAn> doAnArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setC();
        new ApiLayDoan(this).execute();
    }
    private void init(){
        doAnArrayList = new ArrayList<>();

        adapter = new DoanAdapter(this,0,doAnArrayList);
    }
    private void anhXa(){
        gvDSDoan = findViewById(R.id.gvDSDoan);
    }
    private void setUp(){
        gvDSDoan.setAdapter(adapter);
    }
    private void setC(){}

    @Override
    public void batDau() {
        Toast.makeText(this,"Dang Lay Du Lieu",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            doAnArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                doAnArrayList.add(new DoAn(o));
            }
            adapter = new DoanAdapter(this,0,doAnArrayList);
            gvDSDoan.setAdapter(adapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Loi Ket Noi",Toast.LENGTH_SHORT).show();
    }
}
