package com.example.android.leantest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.leantest.QuestionOne;

public class MainActivity extends FragmentActivity {

    private String userName = "";
    private Button startQuiz;
    private Button nextButton;
    private Button previousButton;
    private LinearLayout bottomButtons;
    private int fragmentCounter = 0;
    int score = 0;
    int globalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartFragment startFragment = new StartFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmant_container, startFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        //listening to add or a remove a fragment
        //create a fragmentCounter variable to count the number of the fragments
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
//                Toast.makeText(MainActivity.this, "Fragment count: " + getSupportFragmentManager().getBackStackEntryCount() , Toast.LENGTH_SHORT).show();
                fragmentCounter = getSupportFragmentManager().getBackStackEntryCount();
                manageButtonVisibilty();
            }
        });

        //store the buttons in local variables
        startQuiz = (Button) findViewById(R.id.startQuizButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        previousButton = (Button) findViewById(R.id.backButton);
        bottomButtons = (LinearLayout) findViewById(R.id.buttonLayout);


        //back button press call the system default button press
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.onBackPressed();
            }
        });


    }

    //on click start quiz button
    public void startQuiz(View view) {

        //checks the name field is empty or not and toast a message
        if (userName.isEmpty()) {
            Toast.makeText(this, "Please give your name!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "Welcome to the game " + userName, Toast.LENGTH_SHORT).show();
            manageFregmants();
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //method to store the values of the given answers
    public void setScore(int score) {
        this.score=score;
        //only allows clicks, if the setScore method called
        nextButton.setEnabled(true);

    }



    private void manageButtonVisibilty(){
        if (fragmentCounter<=1){
            startQuiz.setVisibility(View.VISIBLE);
            bottomButtons.setVisibility(View.GONE);
        }else if (fragmentCounter>1){
            startQuiz.setVisibility(View.GONE);
            bottomButtons.setVisibility(View.VISIBLE);
        }else if (fragmentCounter>8){
            startQuiz.setVisibility(View.VISIBLE);
            bottomButtons.setVisibility(View.GONE);

        }

    }

    public void onClickNext(View v){
        manageFregmants();
        globalScore += score;
        showCurrentScore();
    }
    //comment
    private void manageFregmants(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragmentToShow = new QuestionOne(userName);
        switch (fragmentCounter){
            case 1:
                fragmentToShow = new QuestionOne(userName);
                break;
            case 2:
                fragmentToShow = new QuestionTwo(userName);
                break;
            case 3:
                fragmentToShow = new QuestionThree(userName);
                break;
            case 4:
                fragmentToShow = new QuestionFour(userName);
                break;
            case 5:
                fragmentToShow = new QuestionFive(userName);
                break;
            case 6:
                fragmentToShow = new QuestionSix(userName);
                break;
            case 7:
                fragmentToShow = new QuestionSeven(userName);
                break;
            case 8:
                fragmentToShow = new QuestionEight(userName);
                break;
            case 9:
                fragmentToShow = new CloseFragment(globalScore);
                break;

        }
        transaction.replace(R.id.fragmant_container, fragmentToShow);
        transaction.addToBackStack(null);
        transaction.commit();
        nextButton.setEnabled(false);
    }

    //shows the current score on the screen
    private void showCurrentScore(){
        Toast.makeText(this, "Current score: " + globalScore, Toast.LENGTH_SHORT).show();
    }

    //show the curret fragment number
//    private void showCurrentFragmentNumber(){
//        Toast.makeText(this, "Current fagment nr: " + fragmentCounter, Toast.LENGTH_SHORT).show();
//    }


    }
