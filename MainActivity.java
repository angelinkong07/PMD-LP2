package com.example.myapplicationnew;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            // Make the text view scroll automatically
            TextView appName = findViewById(R.id.appNameText);
            appName.setSelected(true);  // This activates the marquee

            // Speak welcome message when activity starts
            speakWelcomePrompt();

            // Set up button click listeners
            setupButtons();
        }

        private void speakWelcomePrompt() {
            AccessibilityManager am = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
            if (am.isEnabled()) {
                AccessibilityEvent event = AccessibilityEvent.obtain();
                event.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);
                event.getText().add(getString(R.string.welcome_prompt));
                am.sendAccessibilityEvent(event);
            }
        }

        private void setupButtons() {
            ImageButton settingsButton = findViewById(R.id.settingsButton);
            ImageButton profileButton = findViewById(R.id.profileButton);
            MaterialButton voiceButton = findViewById(R.id.voiceCommandButton);

            // For demonstration purposes - actual functionality would be implemented later
            settingsButton.setOnClickListener(v -> {
                // Play click sound for feedback
                playClickSound();
                // Navigate to settings screen
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            });

            voiceButton.setOnLongClickListener(v -> {
                v.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.blue_dark)));

                new Handler().postDelayed(() -> { // Add slight delay for better UX
                    showDestinationDialog();
                }, 300);

                return true;
            });

            profileButton.setOnClickListener(v -> {
                // Play click sound for feedback
                playClickSound();
                // Navigate to profile screen
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            });
        }

        private void showDestinationDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Voice Destination");

            final EditText input = new EditText(this);
            input.setHint("Say your destination");
            builder.setView(input);

            builder.setPositiveButton("NAVIGATE", (dialog, which) -> {
                String destination = input.getText().toString().trim();
                if (!destination.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
                    intent.putExtra("DESTINATION", destination);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Please enter a destination", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("CANCEL", null);
            builder.show();
        }

        private void playClickSound() {
            // Implement sound feedback
        }

        private void playRecordingSound() {
            // Implement recording sound feedback
        }


    }
