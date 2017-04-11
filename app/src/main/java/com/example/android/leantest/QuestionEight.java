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
public class QuestionEight extends Fragment {

    private String playerName = "";

    public QuestionEight (String name){
        playerName = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_eight, container, false);
        TextView nameOfTheUser = (TextView) view.findViewById(R.id.nameInTHeHeader);
        CheckBox answerBCheckBox = (CheckBox) view.findViewById(R.id.CB_q8_b);
        CheckBox answerCCheckBox = (CheckBox) view.findViewById(R.id.CB_q8_c);

        //checks if the CheckBox is checked or not
        answerBCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((MainActivity) getActivity()).setScore(1); //if it is checked, give 1 to score
                } else {
                    ((MainActivity) getActivity()).setScore(0); //if it is not checked, "give" 0 to score
                }
            }
        });

        //checks if the CheckBox is checked or not
        answerCCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((MainActivity) getActivity()).setScore(1); //if it is checked, give 1 to score
                } else {
                    ((MainActivity) getActivity()).setScore(0); //if it is not checked, "give" 0 to score
                }
            }
        });




        nameOfTheUser.setText(playerName);
        return view;
    }


}