package com.example.lab4_manipulation_dynamique_des_fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnViewA, btnViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec les éléments XML
        btnViewA = findViewById(R.id.btnViewA);
        btnViewB = findViewById(R.id.btnViewB);

        // Chargement initial
        if (savedInstanceState == null) {
            loadFragment(new FragmentOne(), false);
        }

        // Gestion des clics
        btnViewA.setOnClickListener(v -> loadFragment(new FragmentOne(), true));
        btnViewB.setOnClickListener(v -> loadFragment(new FragmentTwo(), true));
    }

    // Méthode pour changer de fragment
    private void loadFragment(Fragment selectedFragment, boolean saveInBackStack) {

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.container_dynamic, selectedFragment);

        if (saveInBackStack) {
            transaction.addToBackStack("navigation");
        }

        transaction.commit();
    }
}