package com.sha.mycart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sha.mycart.Model.dataclass;
import com.sha.mycart.rest.apiInterface;
import com.sha.mycart.rest.apiclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    Button Proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        Proceed=(Button) findViewById(R.id.button2);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Second.class));
            }
        });

        apiInterface apiService = apiclass.getClient().create(apiInterface.class);
        Call<List<dataclass>> call_getlist = apiService.getAlldata();
        call_getlist.enqueue(new Callback<List<dataclass>>() {
            @Override
            public void onResponse(Call<List<dataclass>> call, Response<List<dataclass>> response) {
                List<dataclass> data = response.body();
                CartSession cartSession=new CartSession(getApplicationContext());
                cartSession.createCartSession(data);
                //Toast.makeText(MainActivity.this, "count"+Integer.toString(students.size()), Toast.LENGTH_SHORT).show();
                adapter = new listadapter(data, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<dataclass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Sorry Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
