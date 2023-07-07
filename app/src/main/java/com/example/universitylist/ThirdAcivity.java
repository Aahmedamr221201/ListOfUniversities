package com.example.universitylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdAcivity extends AppCompatActivity {

    TextView UniversityName;
    TextView DomainPlain;
    Button btnOkay;
    Button btnVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        UniversityName=findViewById(R.id.UniversityPlain);
        DomainPlain=findViewById(R.id.DomainPlain);
        btnVisit=findViewById(R.id.Visit);
        Intent RecIntent = getIntent();
        String University = RecIntent.getStringExtra("Uni");
        Intent RecIntent2 = getIntent();
        String Domain = RecIntent2.getStringExtra("Domain");
        Intent RecIntent3 = getIntent();
        String url = RecIntent2.getStringExtra("URL");
        UniversityName.setText(University);
        DomainPlain.setText(Domain);
        btnOkay=findViewById(R.id.Okay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

    }
}