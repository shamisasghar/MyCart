package com.sha.mycart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sha.mycart.Model.SqliteDb;

public class ForthActivity extends AppCompatActivity {

    Button submit,show;
SqliteDb sqliteDb;
    EditText fname,lname;
    String fn,ln ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        fname=(EditText)findViewById(R.id.fn);
        lname=(EditText)findViewById(R.id.ln);
        submit=(Button)findViewById(R.id.submit);
        show=(Button)findViewById(R.id.show);

sqliteDb =new SqliteDb(this,"",null,1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=fname.getText().toString();
                ln=lname.getText().toString();

                sqliteDb.insert_data(fn,ln);
                fname.setText("");
                lname.setText("");
            }
        });
show.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ForthActivity.this,listdbitem.class);
        startActivity(intent);

    }
});
    }
}
