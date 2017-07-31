package com.sha.mycart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sha.mycart.Model.Contact;
import com.sha.mycart.Model.DatabaseHandler;

import java.util.List;

public class ShowDatabaseActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<Contact> contacts = db.getAllContacts();
        recycler =new RecycleAdapter(contacts);
        RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycler);
    }
}
