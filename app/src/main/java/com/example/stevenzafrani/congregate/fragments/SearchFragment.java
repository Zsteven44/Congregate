package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.canvas.AlgorithmSearchCanvas;
import com.example.stevenzafrani.congregate.models.AlgorithmLogSearch;

public class SearchFragment extends BaseFragment {

    private int[] myArray;

    private int searchType = 0;
    private boolean inProgress =false;

    private AlgorithmLogSearch algorithmLog;
    private Button runButton;
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
                    case 3:
                        searchType=3;
                        break;
                    case 4:
                        searchType=4;
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
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchType == 0 ) {
                    Toast toast = Toast.makeText(view.getContext(),"Please select search type.", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void runSimulation() {
        AlgorithmLogSearch algorithmLogSearch;
    }
    private void setArrayData() {
        /**
         * Used to update Drawable canvas data to match generated array.
         */
        drawableCanvas.setImageDrawable(new AlgorithmSearchCanvas(myArray));
    }
    private void generateMyArray() {
        for (int i=0; i<myArray.length; i++) {
            myArray[i] = (int) (Math.random()*100);
        }
    }

}
