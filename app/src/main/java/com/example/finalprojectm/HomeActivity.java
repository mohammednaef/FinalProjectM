package com.example.finalprojectm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    RecyclerView recyclerView;
    AdapterUser adapterUser;

    final List<User> users=new ArrayList<>();

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView=findViewById(R.id.search);
        recyclerView=findViewById(R.id.Userrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager((getApplicationContext())));
        ReadUser();
        searchView.setOnQueryTextListener(this);
    }
    public void ReadUser(){

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference().child("User");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    users.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                 //   Toast.makeText(HomeActivity.this, dataSnapshot.getValue(User.class).getUserName() + "", Toast.LENGTH_LONG).show();
                  //  Toast.makeText(HomeActivity.this, dataSnapshot.getValue(User.class).getId() + "", Toast.LENGTH_SHORT).show();
                    if (!dataSnapshot.getValue(User.class).getId().equals(firebaseUser.getUid())) {
                        User user = new User();
                        user.setId(dataSnapshot.getValue(User.class).getId());
                        user.setUserName(dataSnapshot.getValue(User.class).getUserName());
                        users.add(user);
                    }
                    adapterUser=new AdapterUser(getApplicationContext(),users);
                    recyclerView.setAdapter(adapterUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapterUser.Filter(newText);
        return false;
    }
}