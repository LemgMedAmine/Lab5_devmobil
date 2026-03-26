package com.example.lab5_devmobil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    public DistanceFragment() {
        super(R.layout.fragment_distance);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        
        EditText input = v.findViewById(R.id.inputDist);
        Button btn = v.findViewById(R.id.btnDist);
        TextView res = v.findViewById(R.id.resultDist);

        btn.setOnClickListener(x -> {
            String inputStr = input.getText().toString();
            if (inputStr.isEmpty()) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                double val = Double.parseDouble(inputStr);
                double result = val * 0.6214;
                res.setText(String.format("Résultat : %.2f miles", result));
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Valeur invalide", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
