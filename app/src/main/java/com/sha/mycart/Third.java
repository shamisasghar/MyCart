package com.sha.mycart;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sha.mycart.Model.SqliteDb;
import com.sha.mycart.R;

public class Third extends AppCompatActivity {

    EditText ed1,ed2;
    TextView textView;
    SqliteDb sqliteDb;

    @Override
         protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ed1=(EditText)findViewById(R.id.fn);
        ed2=(EditText)findViewById(R.id.ln);
        textView=(TextView)findViewById(R.id.textView);



    }
    public void btn_click(View view)
    {
        switch (view.getId())
        {
            case R.id.add:

                sqliteDb.insert_data(ed1.getText().toString(),ed2.getText().toString());
                Toast.makeText(this,"Record inserted",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Update:
                AlertDialog.Builder dialog=new AlertDialog.Builder(Third.this);
                dialog.setTitle("FirstName plz");
               final EditText nw=new EditText(this);
                dialog.setView(nw);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sqliteDb.update_data(ed1.getText().toString(),nw.getText().toString());
                            }
                        });

                        dialog.show();
                break;
                case R.id.delete:
                  sqliteDb.delete_data(ed1.getText().toString());

               case R.id.view:
                sqliteDb.list_data(textView);
                break;

        }
    }

}

