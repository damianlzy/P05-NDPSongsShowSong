package com.example.p05_ndpsongsshowsong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;

public class Modify extends AppCompatActivity {
    EditText etID,etSingers,etYears;
    Button btnUpdate,btnDelete,btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify);

        etID = (EditText)findViewById(R.id.etID);
        etSingers = (EditText)findViewById(R.id.etSinger);
        etYears = (EditText)findViewById(R.id.etYear);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

      //  Intent i = getIntent();
      //  data = (Note) i.getSerializableExtra("data");

        //tvID.setText("ID: " + data.getId());
       // etContent.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Modify.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Modify.this);
                dbh.deleteNote(data.getId());
                dbh.close();
            }
        });
    }

}
