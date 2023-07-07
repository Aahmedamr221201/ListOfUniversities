package com.example.universitylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UniverstiesList extends AppCompatActivity {

    ListView lst;
    //Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        //btn1 = findViewById(R.id.btn1);
        lst = findViewById(R.id.list2);
        Intent RecIntent = getIntent();
        String Country_Name = RecIntent.getStringExtra("CountryName");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://universities.hipolabs.com/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        //List<String> Uni_Names = null;
        Call<List<UniName>> call = apiInterface.getUni(Country_Name);
        call.enqueue(new Callback<List<UniName>>() {
            @Override
            public void onResponse(Call<List<UniName>> call, Response<List<UniName>> response) {
                String [] List_Of_Uni = new String [response.body().size()];
                String [] Domain = new String [response.body().size()];
                String [] URL = new String [response.body().size()];

                for(int i=0;i<List_Of_Uni.length;i++)
                {
                    List_Of_Uni[i]=response.body().get(i).getName();
                    Domain[i]=response.body().get(i).getDomains();
                    URL[i]=response.body().get(i).getWeb_pages();
                }
                ArrayAdapter<String> Adaptor = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1, List_Of_Uni);
                lst.setAdapter(Adaptor);
                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent2 = new Intent(UniverstiesList.this,ThirdAcivity.class);
                        intent2.putExtra("Uni",List_Of_Uni[i]);
                        intent2.putExtra("Domain",Domain[i]);
                        intent2.putExtra("URL",URL[i]);
                        startActivity(intent2);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<UniName>> call, Throwable t) {
                System.out.println(t.getCause());
            }
        });


    }


}