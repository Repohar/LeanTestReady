package com.example.android.leantest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class QuestionThree extends Fragment {


    private String playerName = "";


    public QuestionThree (String name){
        playerName = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_three, container, false);
        TextView nameOfTheUser = (TextView) view.findViewById(R.id.nameInTHeHeader);
        EditText editTextAnswer3 = (EditText) view.findViewById(R.id.textInput_q3);
        editTextAnswer3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().isEmpty()){
                    int answer = Integer.parseInt(s.toString());
                    if (answer == 80){
                        ((MainActivity) getActivity()).setScore(1);
                    }else{
                        ((MainActivity) getActivity()).setScore(0);
                    }
                }else {
                    ((MainActivity) getActivity()).setScore(0);
                }

            }
        });
        nameOfTheUser.setText(playerName);

        return view;
    }
}
