package com.example.android.leantest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class QuestionOne extends Fragment {


    private String playerName = "";

    @SuppressLint("ValidFragment")
    public QuestionOne (String name){
        playerName = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_one, container, false);
        TextView nameOfTheUser = (TextView) view.findViewById(R.id.nameInTHeHeader);
        RadioGroup radioGroupQuestion = (RadioGroup) view.findViewById(R.id.radioGroup);
        radioGroupQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (R.id.radio_buttonQ1b == checkedId){
                    ((MainActivity) getActivity()).setScore(1);
                }else{
                    ((MainActivity) getActivity()).setScore(0);
                }

            }
        });
        nameOfTheUser.setText(playerName);
        return view;
    }





}
