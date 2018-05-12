package ru.tantana.psyhotest;

import android.app.Fragment;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class QuestionView extends Fragment implements View.OnClickListener{

    private ArrayList<Button> buttons;
    private int countAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_question, null);

        setup();
        run();

        return v;
    }

    public void run(){
        MyData data = ((RunningTest) getActivity()).getData();

        ((TextView) getView().findViewById(R.id.question_text)).setText(data.question);
        String[] answers = data.answers.split("/");
        for (int i = 0; i < countAnswer; i++) {
            Button btn = buttons.get(i);
            btn.setText(answers[i]);
        }

    }

    private void setup() {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lParams.gravity = Gravity.CENTER_HORIZONTAL;
        LinearLayout ll = (LinearLayout) getView().findViewById(R.id.llQuestion);

        countAnswer = ((RunningTest) getActivity()).countAnswers;
        Context context = getContext();

        for (int i = 0; i < countAnswer; i++) {
            Button btn = new Button(context);
            btn.setTextColor(ColorStateList.valueOf(0));
            btn.setTextSize(8);
            btn.setAllCaps(true);
            btn.setOnClickListener(this);
            ll.addView(btn,lParams);
            buttons.add(btn);
        }

    }

    @Override
    public void onClick(View v) {
        int i = 0;
        for (; i < countAnswer; i++) {
            if (buttons.get(i).getId() == v.getId()) {
                String txt = buttons.get(i).getText().toString();
                buttons.get(i).setText("CLiCK" + txt);
            }
        }
        RunningTest rt = (RunningTest) getActivity();
        rt.changeSumma(i);
        rt.isEnd();
    }
}
