package com.sha.mycart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.sha.mycart.Model.dataclass;
import com.sha.mycart.rest.apiInterface;
import com.sha.mycart.rest.apiclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sha.mycart.R.id.recyclerView;

public class Second extends AppCompatActivity {
private TextView txt1;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        CartSession cartSession=new CartSession(getApplicationContext());
        List<dataclass> cartList=cartSession.getCartDetails();


        adapter=new CartAdapter(cartList,getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);//attach adapter to the recyler
        adapter.notifyDataSetChanged();


       // CartSession cartSession=new CartSession(getApplicationContext());
        //List<dataclass> cartlist= cartSession.getCartDetails();
       //txt1.setText(cartSession.getCartJson());



    }
}
