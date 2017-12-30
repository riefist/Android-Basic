package com.muhamadarief.androidbasic.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.muhamadarief.androidbasic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);

        btnDetailCategory.setOnClickListener(view1 -> {
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String description = "Kategori ini akan berisi produk-produk lifestyle";
            detailCategoryFragment.setArguments(bundle);
            detailCategoryFragment.setDescription(description);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment.class.getSimpleName());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

}
