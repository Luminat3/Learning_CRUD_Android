package com.luminate.simplereminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addData extends AppCompatActivity {

    String choosenDate;
    EditText etTitle, etEvents;
    TextView tv_tanggal;
    Button btTanggal, btAdd;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference("event");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        etTitle = findViewById(R.id.et_title);
        etEvents = findViewById(R.id.et_events);
        btTanggal = findViewById(R.id.bt_tanggal);
        btAdd = findViewById(R.id.bt_add);
        tv_tanggal = findViewById(R.id.tv_tanggal);

        btTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment frgTanggal = new DatePickerFragment();
                frgTanggal.show(getSupportFragmentManager(), "datePicker");
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getTitle = etTitle.getText().toString();
                String getEvent = etEvents.getText().toString();
                String getDate = tv_tanggal.getText().toString();


                if (getTitle.isEmpty())
                {
                    etTitle.setError("Please fill the Tittle");
                }
                else if (getEvent.isEmpty())
                {
                    etEvents.setError("Please fill the events");
                }
                else
                {
                    db.child("Event").push().setValue(new model(getTitle, getEvent, getDate))
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(addData.this, "The Data has been added!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(addData.this, MainActivity.class));
                                finish();
                            }).addOnFailureListener(e -> Toast.makeText(addData.this, "The Data has not been added due to an error!", Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    public void processDatePickerResult(int tahun, int bulan, int hari)
    {
        String year = Integer.toString(tahun);
        String month = Integer.toString(bulan);
        String day = Integer.toString(hari);

        choosenDate = day + "/" + month + "/" + year;
        tv_tanggal.setText(choosenDate);
    }
}