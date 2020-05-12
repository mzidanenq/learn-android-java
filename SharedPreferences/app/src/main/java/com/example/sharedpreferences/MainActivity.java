package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtUser,edtPass;
    CheckBox chckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        edtUser = findViewById(R.id.edtuser);
        edtPass = findViewById(R.id.edtpass);
        chckBox = findViewById(R.id.checkbox);


        displayInfo();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chckBox.isChecked())
                {
                    saveInfo();
                } else
                {
                    displayInfo();
                }
            }
        });
    }

    public void saveInfo() {
        SharedPreferences preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("Save", true);
        editor.putString("Nama", edtUser.getText().toString());
        editor.putString("Pass", edtPass.getText().toString());

        editor.apply();

        Toast.makeText(this,"Sukses Save", Toast.LENGTH_LONG).show();

    }

    public void  displayInfo()
    {
        SharedPreferences preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Boolean save = preferences.getBoolean("Save", false);
        String nama = preferences.getString("Nama","");
        String pass = preferences.getString("Pass","");


        chckBox.setChecked(save);
        edtUser.setText(nama);
        edtPass.setText(pass);
    }
}
