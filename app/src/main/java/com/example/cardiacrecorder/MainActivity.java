package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cardiacrecorder.Adaptor.ListAdaptor;
import com.example.cardiacrecorder.Domain.ListDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-eb8d3-default-rtdb.firebaseio.com/");
    DatabaseReference pressureDataRef =  FirebaseDatabase.getInstance().getReference("pressureData");

    private RecyclerView.Adapter adapter1;
    private RecyclerView recyclerViewList;
    TextView textView,name;
    Button add;
    View prs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewList();
        bottomNavigation();
        name=findViewById(R.id.textView);
        prs=findViewById(R.id.person);
        add=findViewById(R.id.addNew);
        String n1=getIntent().getStringExtra("var");

        databaseReference.child("userinfo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                String getUsername=snapshot.child(n1).child("username").getValue(String.class);
                name.setText("Hi,"+getUsername);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        pressureDataRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                ArrayList<ListDomain> listDomains = new ArrayList<>();
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    String key = dataSnapshot.getKey();
//                    String systolicPressure = dataSnapshot.child("systolicPressure").getValue(String.class);
//                    String diastolicPressure = dataSnapshot.child("diastolicPressure").getValue(String.class);
//                    String currentDate = dataSnapshot.child("currentDate").getValue(String.class);
//                    String currentTime = dataSnapshot.child("currentTime").getValue(String.class);
//
//                    ListDomain listDomain = new ListDomain(systolicPressure, diastolicPressure, currentDate, currentTime, key);
//                    listDomains.add(listDomain);
//                }
//
//                // Use the listDomains ArrayList as needed
//
//                adapter1 = new ListAdaptor(listDomains);
//                recyclerViewList.setAdapter(adapter1);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Handle the error scenario
//            }
//        });

//        prs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent intent=new Intent(MainActivity.this, Profile.class);
////                intent.putExtra("var",n1);
////                startActivity(intent);
//            }
//        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Add.class);
                startActivity(intent);
            }
        });





    }

    /**
     * Set up the RecyclerView and populate it with pressure data from the Firebase Realtime Database.
     */

    private void recyclerViewList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList =findViewById(R.id.recyclerView);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        pressureDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ListDomain> listDomains = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey();


                    String systolicPressure = snapshot.child("systolicPressure").getValue(String.class);

                    String diastolicPressure = snapshot.child("diastolicPressure").getValue(String.class);

                    String currentDate = snapshot.child("currentDate").getValue(String.class);
                    String currentTime = snapshot.child("currentTime").getValue(String.class);

                    String n1 =getIntent().getStringExtra("var");
                    ListDomain listDomain = new ListDomain(systolicPressure, diastolicPressure, currentDate, currentTime, key,n1);
                    listDomains.add(listDomain);

                }
                adapter1 =new ListAdaptor(listDomains);
                recyclerViewList.setAdapter(adapter1);


                // Use the listDomains ArrayList as needed
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error scenario
            }
        });


    }

    /**
     * Set up the bottom navigation bar functionality.
     */

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.fac);
        View homeBtn=findViewById(R.id.home);
        View setting =findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, MainActivity.class);
                String n1=getIntent().getStringExtra("var");
                intent.putExtra("var",n1);
                startActivity(intent);
            }
        });

    }
}

