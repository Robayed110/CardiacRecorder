package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Edit extends AppCompatActivity {

    private EditText key1,newSystolicPressure,newDiastolicPressure;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        newSystolicPressure=findViewById(R.id.systolic1);
        newDiastolicPressure=findViewById(R.id.diastolic1);

        btn=findViewById(R.id.update);
        Intent intent = getIntent();
        String key2 = intent.getStringExtra("key");
        String n1=getIntent().getStringExtra("var");


        /**
         * OnClickListener for the update button. It updates the systolic and diastolic
         * pressures of the selected pressure data in the Firebase Realtime Database.
         */

        //key1.setText(intent.getStringExtra("key"));
        //String keyString = key1.getText().toString();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //object = (ListDomain) getIntent().getSerializableExtra("object");



                DatabaseReference pressureDataRef =  FirebaseDatabase.getInstance().getReference("pressureData");

                pressureDataRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                            String key = dataSnapshot.getKey();

                            if(key.equals(key2)) {
                                String SystolicPressure = newSystolicPressure.getText().toString();

                                String DiastolicPressure = newDiastolicPressure.getText().toString();

                                pressureDataRef.child(key2).child("systolicPressure").setValue(SystolicPressure);
                                pressureDataRef.child(key2).child("diastolicPressure").setValue(DiastolicPressure);

                                Intent intent=new Intent(Edit.this, MainActivity.class);
                                intent.putExtra("var",n1);
                                startActivity(intent);
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}