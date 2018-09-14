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
import manop.mytutor.com.mytutor.utility.RecyclerviewAdepter;

public class TablayoutMycourseFragment extends Fragment {

    private List<DataRecyclerFragment> dataRecyclerFragmentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerviewAdepter mAdepter;

    private void prepareData() {

        DataRecyclerFragment dataRecyclerFragment = new DataRecyclerFragment("English",
                "Manop R.", "English Skill Test", R.drawable.t1);
        dataRecyclerFragmentList.add(dataRecyclerFragment);

        dataRecyclerFragment = new DataRecyclerFragment("Thai", "Mor P.",
                "Thai Skill Test", R.drawable.t2);
        dataRecyclerFragmentList.add(dataRecyclerFragment);

        dataRecyclerFragment = new DataRecyclerFragment("Match Test", "Ploy P.",
                "Match Skill Test", R.drawable.t3);
        dataRecyclerFragmentList.add(dataRecyclerFragment);

        dataRecyclerFragment = new DataRecyclerFragment("Swimming Test", "Lukewaii R.",
                "Swimming Skill Test", R.drawable.t4);
        dataRecyclerFragmentList.add(dataRecyclerFragment);

        dataRecyclerFragment = new DataRecyclerFragment("Chinese", "Bint G.",
                "Chinese Skill Test", R.drawable.t5);
        dataRecyclerFragmentList.add(dataRecyclerFragment);

        mAdepter.notifyDataSetChanged();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout_mycourse, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_MyCourse);


        mAdepter = new RecyclerviewAdepter(dataRecyclerFragmentList);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdepter);

        prepareData();

        return view;
    }
}
