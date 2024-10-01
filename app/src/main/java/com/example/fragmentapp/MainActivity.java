package com.example.fragmentapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display Fragment 1 (MainFragment) initially
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new MainFragment())
                    .commit();
        }
    }

    // Method to show Fragment 2 (ChildFragment)
    public void showFragment2() {
        Fragment fragment = new ChildFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment1, fragment);
        transaction.addToBackStack(null); // Allow user to navigate back to Fragment 1
        transaction.commit();
    }

    // Method to navigate back to Fragment 1 (optional)
    public void showFragment1() {
        Fragment fragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment1, fragment);
        transaction.addToBackStack(null); // Maintain back stack for consistent navigation
        transaction.commit();
    }
}
