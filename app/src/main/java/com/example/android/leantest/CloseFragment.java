package com.example.android.leantest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class CloseFragment extends Fragment {

    private int finalScore = 0;


    @SuppressLint("ValidFragment")
    public CloseFragment(int score) {
        finalScore = score;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_close, container, false);
        TextView finalPoints = (TextView) view.findViewById(R.id.result_score);
        finalPoints.setText(finalScore + " points");
        return view;

    }




}


