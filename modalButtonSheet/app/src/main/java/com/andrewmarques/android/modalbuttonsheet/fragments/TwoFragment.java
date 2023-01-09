package com.andrewmarques.android.modalbuttonsheet.fragments;

import android.app.DialogFragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewmarques.android.modalbuttonsheet.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TwoFragment extends BottomSheetDialogFragment {

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_two, container, false);
        fragmentView.findViewById(R.id.txt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(fragmentView).navigate(R.id.action_twoFragment_to_oneFragment);
            }
        });
        return fragmentView;
    }
}