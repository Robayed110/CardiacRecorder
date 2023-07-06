package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cardiacrecorder.Domain.ListDomain;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Details extends AppCompatActivity {
    private ListDomain object;
    TextView s_pressure,di_pressure,date,time,comment,key;
    Button btn,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();

        Intent intent = getIntent();
        //object = (ListDomain) getIntent().getSerializableExtra("object");
        //key.setText(intent.getStringExtra("key"));
        String key2 = intent.getStringExtra("key");
        //key.setText(key2);
        s_pressure.setText(intent.getStringExtra("systolic_pressure"));
        di_pressure.setText(intent.getStringExtra("diastolic_pressure"));
        date.setText(intent.getStringExtra("date"));
        time.setText(intent.getStringExtra("time"));
        String systolicPressureString = intent.getStringExtra("systolic_pressure");
        String diastolicPressureString = intent.getStringExtra("diastolic_pressure");

// Convert systolic pressure to integer
        int systolicPressure = Integer.parseInt(systolicPressureString);

// Convert diastolic pressure to integer
        int diastolicPressure = Integer.parseInt(diastolicPressureString);

        if(systolicPressure>=110 && systolicPressure<=130 && diastolicPressure>=70 && diastolicPressure<=90){
            comment.setText("Good Health.");
        }
        else {
            comment.setText("Concerning!!!");
        }



        /**
         * OnClickListener for the edit button. It starts the Edit activity to allow
         * editing of the pressure data.
         */

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String key=getIntent().getStringExtra("key");
                Intent intent=new Intent(Details.this, Edit.class);
                intent.putExtra("key",key2);
                String n1=getIntent().getStringExtra("var");
                intent.putExtra("var",n1);
                startActivity(intent);
            }
        });

        /**
         * OnClickListener for the delete button. It removes the pressure data from
         * the Firebase Realtime Database.
         */

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference itemRef =  FirebaseDatabase.getInstance().getReference("pressureData").child(key2);
                itemRef.removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Handle the successful deletion
                                Toast.makeText(getApplicationContext(), "Data deleted successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle the failure scenario
                                Toast.makeText(getApplicationContext(), "Failed to delete data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });



    }

    /**
     * Initialize the views used in the activity.
     */

    private void initView() {
        s_pressure=findViewById(R.id.systolic1);
        di_pressure=findViewById(R.id.diastolic1);
        date=findViewById(R.id.date1);
        time=findViewById(R.id.time1);
        comment=findViewById(R.id.comment);
        btn=findViewById(R.id.button);
        delete=findViewById(R.id.delete1);
    }
}