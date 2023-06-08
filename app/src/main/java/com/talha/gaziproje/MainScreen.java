package com.talha.gaziproje;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.talha.gaziproje.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    ImageButton btn;
    ImageButton btn1;
    ImageButton btn2;
    Button btn3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btn=findViewById(R.id.depremBtn);
        sharedPreferences = this.getSharedPreferences("com.talha.gaziproje.databinding.ActivityMainBinding", Context.MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris = new Intent(MainScreen.this,DepremScreen.class);
                startActivity(giris);
            }
        });


        btn1=findViewById(R.id.selBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris1 = new Intent(MainScreen.this,SelScreen.class);
                startActivity(giris1);
            }
        });

        btn2=findViewById(R.id.yangınBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris2 = new Intent(MainScreen.this,YanginScreen.class);
                startActivity(giris2);
            }
        });

        btn3=findViewById(R.id.button8);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris3 = new Intent(MainScreen.this,HelpMeScreen.class);
                startActivity(giris3);
            }
        });

    }
    public void saveFunction(View view){

        EditText username=findViewById(R.id.usernameEdtTxt);
        EditText nationalId=findViewById(R.id.nationalEdtTxt);
        EditText   blood=findViewById(R.id.bloodTypeEdtTxt);

        String name=username.getText().toString();
        String nationalid =nationalId.getText().toString();
        String bloodType = blood.getText().toString();


        sharedPreferences.edit().putString("isim", name).apply();
        sharedPreferences.edit().putString("tc", nationalid).apply();
        sharedPreferences.edit().putString("kan grubu", bloodType).apply();

    }
    public void showFunction(View view) {
        String name = sharedPreferences.getString("isim", "Kayıtlı isim bulunamadı!");
        String national = sharedPreferences.getString("tc", "tc bulunamadı!");
        String blood = sharedPreferences.getString("kan grubu", "");

        TextView info1 = findViewById(R.id.infoTxtVw);
        TextView info2 = findViewById(R.id.infoTxtVw2);
        TextView info3 = findViewById(R.id.infoTxtVw3);

        info1.setText("İsim: " + name);
        info2.setText("Tc: " + national);
        info3.setText("Kan Grubu: " + blood);

    }

}