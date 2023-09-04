package com.example.latihan_msib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Siklus Hidup ACT";

    EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(TAG+" onCreate");

        komentarText = (EditText) findViewById(R.id.komentar_text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

        String dataTersimpan = getPreferences("Komentar");

    }
    private String getPreferences(String key) {
        return this.getSharedPreferences("Siklus Hidup", Context.MODE_PRIVATE).getString(key,null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor data = this.getSharedPreferences("Siklus Hidup", Context.MODE_PRIVATE).edit();
        data.putString("komentar","value");
        data.commit();
    }

}