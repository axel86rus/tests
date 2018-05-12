package ru.tantana.psyhotest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class RunningTest extends AppCompatActivity {

    private Fragment questionView;
    private Fragment resultView;
    private String[] questions;
    private String[] answers;
    private String[] results;
    private int[] resultsLimit;
    public int countAnswers;
    private int sum;
    private int currentI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("RUN", "RUNNING TEST");
        setContentView(R.layout.activity_running_test);
        Log.d("RUN", "END");
    }

    @Override
    protected void onResume() {
        super.onResume();

        setup();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.question_text, questionView);
        ft.commit();
    }

    private void setup(){
        questionView = new QuestionView();
        resultView = new ResultView();

        Intent intent = getIntent();
        int questionsID = intent.getIntExtra("questionsID", 0);
        int answersID = intent.getIntExtra("answersID", 0);
        int resultsID = intent.getIntExtra("resultID", 0);
        int countID = intent.getIntExtra("countAnswerID", 0);
        int limitsId = intent.getIntExtra("limitsID", 0);


        questions = getResources().getStringArray(questionsID);
        answers = getResources().getStringArray(answersID);
        results = getResources().getStringArray(resultsID);
        countAnswers = getResources().getInteger(countID);
        resultsLimit = getResources().getIntArray(limitsId);
        sum = 0;
        currentI = 0;
    }

    public void isEnd() {
        if (currentI == questions.length) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.question_text, resultView);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            QuestionView qView = (QuestionView) getFragmentManager().findFragmentById(R.id.question_text);
            qView.run();
        }
    }

    public String getResultsString() {
        for (int i = 0; i < resultsLimit.length; i++) {
            if (sum >= resultsLimit[i]){
                return results[i];
            }
        }

        return results[0];
    }

    public void changeSumma(int value) {
        sum += value;
    }

    public MyData getData() {
        currentI++;
        return new MyData(questions[currentI], answers[currentI]);
    }
}
