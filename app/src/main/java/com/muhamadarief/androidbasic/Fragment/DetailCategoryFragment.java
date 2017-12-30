package com.muhamadarief.androidbasic.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.muhamadarief.androidbasic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment{

    private TextView tvCategoryName;
    private TextView tvCategoryDescription;
    public static final String EXTRA_NAME = "extra_name";
    private String description;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
    }
}
