package com.example.universitylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    ListView list1 ;
    String [] List_Uni = new String[]{"Algeria","Brazil","China","Egypt","Lebanon","Morocco",
            "Qatar","Russia","United States"};
    int[]Image = {R.drawable.algeria,R.drawable.brazil,R.drawable.chine,R.drawable.egypt
    ,R.drawable.lebnon,R.drawable.moroco,R.drawable.qatar,R.drawable.russia,R.drawable.us};
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent Rec = getIntent();
        list1 = (ListView)findViewById(R.id.List_Item);
        CustamBaseAdaptor CustomAdaptor = new CustamBaseAdaptor(getApplicationContext(),List_Uni,Image);
        list1.setAdapter(CustomAdaptor);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,UniverstiesList.class);
                intent.putExtra("CountryName",List_Uni[i]);
                startActivity(intent);

            }
        });

    }
}