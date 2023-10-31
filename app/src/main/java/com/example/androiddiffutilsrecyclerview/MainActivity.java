package com.example.androiddiffutilsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddiffutilsrecyclerview.Util.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button btn_insertToBack , btnInsertToFront, btn_update;
    RecyclerView recyclerView;

    List<String> dataSource = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn_insertToBack = (Button) findViewById(R.id.btn_insertToBack);
        btnInsertToFront = (Button) findViewById(R.id.btn_insertToFront);
        btn_update = (Button) findViewById(R.id.btn_update);

        ininData();

        MyAdapter adapter = new MyAdapter(dataSource);
        recyclerView.setAdapter(adapter);

        //Event
        btn_insertToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> insertList = new ArrayList<>(); // Assign old data
                for(int i = 0; i < 3; i++)
                    insertList.add(UUID.randomUUID().toString()); // Add new data
                adapter.insertDataToBack(insertList);
                recyclerView.smoothScrollToPosition(adapter.getItemCount()-1); // Auto scroll to last item
            }
        });

        btnInsertToFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> insertList = new ArrayList<>(); // Assign old data
                for(int i = 0; i < 3; i++)
                    insertList.add(UUID.randomUUID().toString()); // Add new data
                adapter.insertDataToFront(insertList);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> update = new ArrayList<>(); // Assign old data
                for(int i = 0; i < 3; i++)
                    update.add(UUID.randomUUID().toString()); // Add new data
                adapter.updateData(update);
            }
        });
    }

    private  void ininData() {
        for (int i = 0; i < 3; i++)
            dataSource.add(UUID.randomUUID().toString());
    }
}