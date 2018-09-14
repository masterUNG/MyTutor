package manop.mytutor.com.mytutor.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.utility.Recent_RecyclerviewAdepter;
import manop.mytutor.com.mytutor.utility.RecyclerviewAdepter;

public class TablayoutRecentFragment extends Fragment {

    private List<Data_RecentFragment> data_recentFragmentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Recent_RecyclerviewAdepter mAdepter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_recent, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_Recent);
        mAdepter = new Recent_RecyclerviewAdepter(data_recentFragmentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdepter);

        data();

        return view;
    }

    private void data() {

        Data_RecentFragment data_recentFragment = new Data_RecentFragment("English",
                "Manop R.", "Chapter 1", R.drawable.v1);
        data_recentFragmentList.add(data_recentFragment);

        data_recentFragment = new Data_RecentFragment("Thai", "Mor P.",
                "Chapter 2", R.drawable.v2);
        data_recentFragmentList.add(data_recentFragment);

        data_recentFragment = new Data_RecentFragment("Computer", "Waii R.",
                "Chapter 3", R.drawable.v3);
        data_recentFragmentList.add(data_recentFragment);

        data_recentFragment = new Data_RecentFragment("Iphone", "Ploy P.",
                "Chapter 4", R.drawable.v4);
        data_recentFragmentList.add(data_recentFragment);

        data_recentFragment = new Data_RecentFragment("Java", "Bint S.",
                "Chapter 5", R.drawable.v5);
        data_recentFragmentList.add(data_recentFragment);

        mAdepter.notifyDataSetChanged();

    }
}
