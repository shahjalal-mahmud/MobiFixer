package com.example.mobifixer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Set up system bar padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the logout button
        logoutButton = findViewById(R.id.logoutButton);

        // Check if the user is logged in, if not redirect to LoginActivity
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));  // Redirect to login if user is not logged in
            finish();  // Close the current activity
        }

        // Logout button click handler
        logoutButton.setOnClickListener(v -> {
            mAuth.signOut();  // Signs the user out of Firebase
            startActivity(new Intent(MainActivity.this, LoginActivity.class));  // Redirect to login activity
            finish();  // Close MainActivity
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            // Check if this activity was started from DashboardActivity
            if (getIntent().getBooleanExtra("fromDashboard", false)) {
                return; // Do nothing, stay in MainActivity
            }

            // Otherwise, navigate to DashboardActivity
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }
    }

}
