package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Add extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference pressureDataRef = database.getReference("pressureData");
    EditText sp,dp;
    Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        String key = pressureDataRef.push().getKey();
        sp=findViewById(R.id.sp1);
        dp=findViewById(R.id.dp1);
        addBtn=findViewById(R.id.add2);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String systolicPressure = sp.getText().toString().trim();
                //int systolicPressure = Integer.parseInt(systolicPressureString);
                String diastolicPressure=dp.getText().toString().trim();
                //int diastolicPressure = Integer.parseInt(diastolicPressureString);


                String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                PressureData pressureData = new PressureData(key, systolicPressure, diastolicPressure, currentDate, currentTime);
                pressureDataRef.child(key).setValue(pressureData);
                pressureDataRef.child(key).setValue(pressureData)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "Data uploaded successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Failed to upload data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });



    }
}