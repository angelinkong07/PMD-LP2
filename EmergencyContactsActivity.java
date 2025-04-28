package com.example.myapplicationnew;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class EmergencyContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);

        // Initialize RecyclerView
        RecyclerView contactsList = findViewById(R.id.contactsRecyclerView);
        contactsList.setLayoutManager(new LinearLayoutManager(this));

        // Sample data - replace with real contacts
        List<Contact> contacts = Arrays.asList(
                new Contact("Medical Emergency", "911"),
                new Contact("Trusted Friend", "012-3456789")
        );

        contactsList.setAdapter(new ContactsAdapter(contacts));

        // Button click handlers
        findViewById(R.id.addContactButton).setOnClickListener(v -> {
            Toast.makeText(this, "Add Contacts will be implemented soon", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.backButton).setOnClickListener(v -> {
            finish();
        });
    }
}

