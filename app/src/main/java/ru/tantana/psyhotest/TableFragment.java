package ru.tantana.psyhotest;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TableFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ListView listTest;
    private String[] nameTests;
    private String[] descriptionTests;



    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.table_test, null);

        listTest = (ListView) v.findViewById(R.id.listTest);
        listTest.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getContext(),
                R.array.name_test,
                android.R.layout.simple_list_item_1);

        listTest.setAdapter(adapter);
        listTest.setOnItemClickListener(this);

        nameTests = getResources().getStringArray(R.array.name_test);
        descriptionTests = getResources().getStringArray(R.array.description_test);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TAG", "Click Item");

        ((MainActivity) getActivity()).setDescriptionAndChangeFragment(nameTests[position], descriptionTests[position]);
    }
}
