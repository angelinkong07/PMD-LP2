package com.example.myapplicationnew;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        // Initialize views
        EditText nameField = findViewById(R.id.nameField);
        EditText phoneField = findViewById(R.id.phoneField);
        EditText addressField = findViewById(R.id.addressField);
        EditText medField = findViewById(R.id.medField);
        ImageButton editButton = findViewById(R.id.editProfileButton);
        LinearLayout saveButton = findViewById(R.id.saveButton);

        // Edit button toggles edit mode
        editButton.setOnClickListener(v -> {
            boolean enabled = !nameField.isEnabled();
            nameField.setEnabled(enabled);

            enabled = !phoneField.isEnabled();
            phoneField.setEnabled(enabled);

            enabled = !addressField.isEnabled();
            addressField.setEnabled(enabled);

            enabled = !medField.isEnabled();
            medField.setEnabled(enabled);

            // Repeat for other fields
            saveButton.setVisibility(enabled ? View.VISIBLE : View.GONE);
        });

        // Save button handler
        saveButton.setOnClickListener(v -> {
            // Save data to SharedPreferences or database
            Toast.makeText(this, "Information saved", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
