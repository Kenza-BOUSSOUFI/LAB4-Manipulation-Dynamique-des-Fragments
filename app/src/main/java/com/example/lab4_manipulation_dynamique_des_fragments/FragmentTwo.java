package com.example.lab4_manipulation_dynamique_des_fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView valueDisplay;
    private SeekBar sliderControl;

    private int currentValue = 0;
    private static final String STATE_VALUE = "slider_value";

    public FragmentTwo() {
        super(R.layout.fragment_control); // layout renommé
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        valueDisplay = view.findViewById(R.id.txtValue);
        sliderControl = view.findViewById(R.id.sliderBar);

        // Restaurer l'état après rotation
        if (savedInstanceState != null) {
            currentValue = savedInstanceState.getInt(STATE_VALUE, 0);
            sliderControl.setProgress(currentValue);
            valueDisplay.setText("Niveau : " + currentValue);
        }

        // Listener sur le slider
        sliderControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                currentValue = value;
                valueDisplay.setText("Niveau : " + value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // optionnel
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // optionnel
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_VALUE, currentValue);
    }
}
