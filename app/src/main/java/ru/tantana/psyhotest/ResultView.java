package ru.tantana.psyhotest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_result, null);

        TextView resultView = (TextView) v.findViewById(R.id.result_tv);

        resultView.setText(((RunningTest) getActivity()).getResultsString());

        return v;
    }
}
