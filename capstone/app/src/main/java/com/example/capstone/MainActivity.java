package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button products, load, debtor, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        setContentView(R.layout.activity_main);

        products = findViewById(R.id.bt1);
        products.setOnClickListener(a -> {
            Intent intent1 = new Intent(MainActivity.this, products.class);
            startActivity(intent1);


            load = findViewById(R.id.bt2);
            load.setOnClickListener(b -> {
                Intent intent2 = new Intent(MainActivity.this, load.class);
                startActivity(intent2);



                debtor = findViewById(R.id.bt3);
                debtor.setOnClickListener(c -> {
                    Intent intent3 = new Intent(MainActivity.this, debtor.class);
                    startActivity(intent3);



                    other = findViewById(R.id.bt4);
                    other.setOnClickListener(d -> {
                        Intent intent4 = new Intent(MainActivity.this, other.class);
                        startActivity(intent4);


                    });
                });
            });
        });
    }
}
