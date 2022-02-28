package com.example.pruebarecyclermodificable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_addOne;
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<President> presidentList;
    private static final String TAG = "PRESIDENT app";

    MyApplication myApplication= (MyApplication) this.getApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList= myApplication.getPresidentList();

        Log.d(TAG, "onCreate: " + presidentList.toString());

        btn_addOne = findViewById(R.id.btn_addOne);

        recyclerView = findViewById(R.id.Recycler_list);

        recyclerView.setHasFixedSize(true);

        //layout manager
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //specify an adapter
        mAdapter = new RecyclerViewAdapter(presidentList,MainActivity.this);
        recyclerView.setAdapter(mAdapter);


        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

    }


}