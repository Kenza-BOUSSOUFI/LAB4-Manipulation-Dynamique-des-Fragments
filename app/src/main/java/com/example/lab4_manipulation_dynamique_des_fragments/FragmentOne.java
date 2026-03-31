package com.example.lab4_manipulation_dynamique_des_fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView messageView;
    private Button actionBtn;

    public FragmentOne() {
        super(R.layout.fragment_welcome); // layout renommé
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        messageView = view.findViewById(R.id.txtMessage);
        actionBtn = view.findViewById(R.id.btnAction);

        // Interaction utilisateur
        actionBtn.setOnClickListener(v ->
                messageView.setText("Bienvenue 👋 depuis la première vue !")
        );
    }
}