package com.sha.mycart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sha.mycart.Model.Db;
import com.sha.mycart.Model.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHA on 28/7/2017.
 */

public class listdbitem extends Activity {

    Button sho;
    Db database;
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    List<datamodel> dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.view);
        sho = (Button) findViewById(R.id.view);
        dm =new ArrayList<datamodel>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);


        sho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new Db(listdbitem.this);
                dm=  database.getdata();
                recycler =new RecycleAdapter(dm);

                RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);


            }
        });

    }

}
