package com.sha.mycart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sha.mycart.Model.Contact;
import com.sha.mycart.Model.DatabaseHandler;

import java.util.List;

public class ForthActivity extends AppCompatActivity {
  //  DatabaseHandler db = new DatabaseHandler(getApplicationContext());
    Button submit,show,uptd;
    EditText fname,lname,etid;
    String fn,ln ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        fname=(EditText)findViewById(R.id.fn);
        lname=(EditText)findViewById(R.id.ln);
      etid=(EditText)findViewById(R.id.ID) ;
        submit=(Button)findViewById(R.id.submit);
        show=(Button)findViewById(R.id.show);
        uptd=(Button)findViewById(R.id.upte);



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
            startActivity(new Intent(ForthActivity.this,ShowDatabaseActivity.class ));
    }
});
        uptd.setOnClickListener(new View.OnClickListener() {
            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
            @Override
            public void onClick(View v) {

               boolean isupdate= db.update(etid.getText().toString(),fname.getText().toString(),lname.getText().toString());
                Toast.makeText(ForthActivity.this, "Record updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
