package com.example.pruebarecyclermodificable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button bt_ok, bt_cancel;
    EditText etName, etImagen, etDate;
    TextView tv_presId;

    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList= myApplication.getPresidentList();

        bt_ok = findViewById(R.id.bt_ok);
        bt_cancel = findViewById(R.id.bt_cancel);

        etName = findViewById(R.id.etName);
        etImagen = findViewById(R.id.etImagen);
        etDate = findViewById(R.id.etDate);
        tv_presId = findViewById(R.id.tv_presidentIdNumber);

        Intent intent = getIntent();
        id= intent.getIntExtra("id",-1);
        President president= null;
        if(id>=0){
            //edit President
            for (President p: presidentList){
                if(p.getId()==id){
                    president= p;
                }
            }
            etName.setText(president.getName());
            etImagen.setText(president.getImg());
            etDate.setText(String.valueOf(president.getDate()));
            tv_presId.setText(String.valueOf(id));


        }


        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id >= 0) {
                    //update
                    President updatedPresident = new President(id, etName.getText().toString(), Integer.parseInt(etDate.getText().toString()), etImagen.getText().toString());
                    presidentList.set(id, updatedPresident);

                } else {
                    //add new Presidente
                    // create president
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(nextId, etName.getText().toString(), Integer.parseInt(etDate.getText().toString()), etImagen.getText().toString());
                    //add the object to the global list of presidents
                    presidentList.add(newPresident);
                    myApplication.setNextId(nextId++);
                }


                //go back...

                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}