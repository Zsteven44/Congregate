package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.algorithms.search.BinarySearch;
import com.example.stevenzafrani.congregate.algorithms.search.LinearSearch;
import com.example.stevenzafrani.congregate.canvas.AlgorithmSearchCanvas;
import com.example.stevenzafrani.congregate.models.AlgorithmLogSearch;

public class SearchFragment extends BaseFragment {

    private int[] myArray;
    private int searchType = 0;
    private boolean inProgress =false;
    private AlgorithmLogSearch algorithmLog;

    private Button runButton;
    private EditText editTextSearch;
    int i;
    private ImageView drawableCanvas;
    Handler handler = new Handler();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_algorithm_search);
        myArray = new int[20];

        algorithmLog = new AlgorithmLogSearch();

        drawableCanvas= (ImageView) getActivity().findViewById(R.id.imageView_algorithm_search);
        runButton = (Button) getActivity().findViewById((R.id.button_run_algorithm_search));
        spinner.setSelection(1, false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {

                drawableCanvas.setImageDrawable(new AlgorithmSearchCanvas(myArray));
                algorithmLog.clear();
                switch (j) {
                    case 0:
                        generateMyArray();
                        setArrayData();
                        searchType=0;
                        break;
                    case 1:
                        searchType=1;
                        break;
                    case 2:
                        searchType=2;
                        break;

                    default:
                        break;
                }
                if (j !=0) {

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.algorithm_search_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editTextSearch = (EditText) getActivity().findViewById(R.id.edit_text_search_value);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = getSearchValue();
                algorithmLog.clear();
                if (value<0) {
                    Toast toast = Toast.makeText(view.getContext(),"Please enter search value.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                switch (searchType) {
                    case 0:
                        Toast toast = Toast.makeText(view.getContext(),"Please select search type.", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    case 1:
                        algorithmLog = new LinearSearch(getActivity(),myArray,value).getAlgorithmLog();
                        break;
                    case 2:
                        algorithmLog = new BinarySearch(getActivity(),myArray,value).getAlgorithmLog();
                        break;

                    default:
                        break;
                }
                spinner.setEnabled(false);
                runSimulation(algorithmLog, spinner);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void runSimulation(final AlgorithmLogSearch algorithmLogSearch, final Spinner spinner) {
        i =0;
        if (algorithmLogSearch.size()>0) {
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    drawableCanvas.setImageDrawable(new AlgorithmSearchCanvas(myArray, algorithmLogSearch.get(i)));
                    i++;
                    if (i< algorithmLog.size()){
                        handler.postDelayed(this,500);
                    }else{
                        spinner.setEnabled(true);
                    }
                }
            };
            handler.post(runnable);
        }
    }
    private void setArrayData() {

        drawableCanvas.setImageDrawable(new AlgorithmSearchCanvas(myArray));
    }
    private void generateMyArray() {
        for (int i=0; i<myArray.length; i++) {
            myArray[i] = (int) ((Math.random()*3.5)+ i*4);
        }
    }

    public int getSearchValue() {

        String value = (editTextSearch.getText().toString());
        Log.d(SearchFragment.class.getSimpleName(), "The search value is: " +value);
        if (value == null || value.isEmpty() || value.length()==0 ){
            return -1;
        } else {
            return Integer.parseInt(value);
        }
    }

}
