package com.wzx.recyclerview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wzx.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customView(View view){
        startActivity(new Intent(this, EmptyRecyclerByCustomView.class));
    }

    public void customViewHolder(View view){
        startActivity(new Intent(this, EmptyRecyclerByViewHolder.class));
    }
}
