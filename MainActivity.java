package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonRead, buttonWrite;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonRead = findViewById(R.id.readBtn);
        buttonWrite = findViewById(R.id.writeBtn);

        //Intializing
        sharedPreferences = getSharedPreferences("txt",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(sharedPreferences.getString("username",""));
                Toast.makeText(MainActivity.this, ""+sharedPreferences.getString("username",""), Toast.LENGTH_LONG).show();
            }
        });

        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Value = editText.getText().toString();
                editor.putString("username", Value);
                editor.commit();
            }
        });

    }

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
}
