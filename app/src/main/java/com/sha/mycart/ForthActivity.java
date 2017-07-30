package com.sha.mycart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sha.mycart.Model.Contact;
import com.sha.mycart.Model.DatabaseHandler;

import java.util.List;

public class ForthActivity extends AppCompatActivity {

    Button submit,show;
    EditText fname,lname;
    String fn,ln ;
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        fname=(EditText)findViewById(R.id.fn);
        lname=(EditText)findViewById(R.id.ln);
        submit=(Button)findViewById(R.id.submit);
        show=(Button)findViewById(R.id.show);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
//        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
//        db.deleteTable();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=fname.getText().toString();
                ln=lname.getText().toString();
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.addContact(new Contact(fn, ln));
                fname.setText("");
                lname.setText("");

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View v) {
            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
//            Toast.makeText(ForthActivity.this, Integer.toString(db.getContactsCount()), Toast.LENGTH_SHORT).show();
            List<Contact> contacts = db.getAllContacts();
            recycler =new RecycleAdapter(contacts);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);
    }
});
    }
}
