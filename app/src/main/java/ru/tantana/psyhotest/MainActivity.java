package ru.tantana.psyhotest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private Fragment tableFrag;
    private Fragment descFrag;
    private String currentNameTest;
    private String currentDescTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableFrag = new TableFragment();
        descFrag = new DescriptionFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_main, tableFrag);
        ft.commit();
    }

    public void setDescriptionAndChangeFragment(String name, String desc) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_main, descFrag);
        ft.addToBackStack(null);
        ft.commit();

        setCurrentDescTest(desc);
        setCurrentNameTest(name);
    }

    public void goToRunning() {
        Intent intent = new Intent(this, RunningTest.class);
        intent.putExtra("questionsID", R.array.questionsOne);
        intent.putExtra("answersID", R.array.варианты_ответов_1);
        intent.putExtra("resultID", R.array.results_1);
        intent.putExtra("countAnswerID",R.integer.количество_ответов);
        intent.putExtra("limitsID", R.array.границы_1);
        startActivity(intent);
    }

    public String getCurrentDescTest() {
        return currentDescTest;
    }

    public String getCurrentNameTest() {
        return currentNameTest;
    }

    public void setCurrentDescTest(String currentDescTest) {
        this.currentDescTest = currentDescTest;
    }

    public void setCurrentNameTest(String currentNameTest) {
        this.currentNameTest = currentNameTest;
    }

}
