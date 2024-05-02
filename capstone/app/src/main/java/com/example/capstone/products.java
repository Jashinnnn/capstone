package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class products extends AppCompatActivity {

    RecyclerView recyclerView;
    prodAdapter prodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_rv);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<prodModel> options =
                new FirebaseRecyclerOptions.Builder<prodModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("product"), prodModel.class)
                        .build();

        prodAdapter = new prodAdapter(options);
        recyclerView.setAdapter(prodAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        prodAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        prodAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setInputType(InputType.TYPE_CLASS_TEXT);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });
        return true;
    }
    private void  txtSearch(String str)
    {
        FirebaseRecyclerOptions<prodModel> options =
                new FirebaseRecyclerOptions.Builder<prodModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("product").orderByChild("Name").startAt(str).endAt(str+"~"), prodModel.class)
                        .build();

        prodAdapter = new prodAdapter(options);
        prodAdapter.startListening();
        recyclerView.setAdapter(prodAdapter);

    }
}