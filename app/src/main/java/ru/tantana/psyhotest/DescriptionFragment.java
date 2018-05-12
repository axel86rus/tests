package ru.tantana.psyhotest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class DescriptionFragment extends Fragment implements View.OnClickListener {


    TextView nameTest;
    TextView descTest;
    Button startButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_description, null);

        nameTest = (TextView) v.findViewById(R.id.nameTest);
        descTest = (TextView) v.findViewById(R.id.descriptionTest);
        startButton = (Button) v.findViewById(R.id.startButton);

        startButton.setText("Start Test");
        startButton.setOnClickListener(this);

        MainActivity main = (MainActivity) getActivity();

        nameTest.setText(main.getCurrentNameTest());
        descTest.setText(main.getCurrentDescTest());

        return v;
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).goToRunning();
    }
}
