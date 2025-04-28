package com.example.myapplicationnew;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

public class NavigationHistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_history);

        ListView historyList = findViewById(R.id.historyListView);

        // Sample data
        String[] sampleHistory = {
                "Home → Supermarket (Today, 10:30 AM)",
                "Office → Home (Yesterday, 6:15 PM)",
                "Home → Park (Yesterday, 4:00 PM)"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                sampleHistory
        );

        historyList.setAdapter(adapter);

        historyList.setOnItemClickListener((parent, view, position, id) -> {
            // Handle item click (e.g., show details or re-navigate)
            Toast.makeText(this, "Selected: " + sampleHistory[position], Toast.LENGTH_SHORT).show();
        });
    }
}
