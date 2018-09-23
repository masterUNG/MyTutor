package manop.mytutor.com.mytutor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.utility.BannerAdapter;
import manop.mytutor.com.mytutor.utility.BannerModel;
import manop.mytutor.com.mytutor.utility.OnClickItem;

public class MainFragment extends Fragment {


    private TextView textView;
    private boolean aBoolean = true;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Login Controller
        loginController();

//        Show DisplayName
        showDisplayName();

//        Banner RecyclerView
        bannerRecyclerView();

    }   //Main Method

    private void bannerRecyclerView() {
        final RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewBanner);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

//        Read FirebaseDatabase
        final int[] timesInts = new int[]{0};
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("Banner");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int i = (int) dataSnapshot.getChildrenCount();
                ArrayList<String> stringArrayList = new ArrayList<>();
                final ArrayList<String> uidStringArrayList1 = new ArrayList<>();
                List list = new ArrayList<>();


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    BannerModel bannerModel = dataSnapshot1.getValue(BannerModel.class);
                    list.add(bannerModel);

                    BannerModel bannerModel1 = (BannerModel) list.get(timesInts[0]);
                    stringArrayList.add(bannerModel1.getImage());
                    uidStringArrayList1.add(bannerModel1.getUidString());
                    timesInts[0] += 1;
                }   // for

                Log.d("2SepV1", "stringArray ==> " + stringArrayList.toString());
                BannerAdapter bannerAdapter = new BannerAdapter(getActivity(),
                        stringArrayList, new OnClickItem() {
                    @Override
                    public void onClickItem(View view, int i) {
                        Log.d("22SepV1", "You Click at Position ==> " + i);
                        Log.d("22SepV1", "uid Click ==> " + uidStringArrayList1.get(i));

                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentMainFragment,
                                        TeacherProfileFragment.teacherProfileInstance(uidStringArrayList1.get(i)))
                                .addToBackStack(null)
                                .commit();

                    }
                });
                recyclerView.setAdapter(bannerAdapter);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void showDisplayName() {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            textView.setText(firebaseUser.getDisplayName());
            aBoolean = false;
        } else {
            aBoolean = true;
        }
    }


    private void loginController() {
        textView = getView().findViewById(R.id.txtlogin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (aBoolean) {

                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contentMainFragment, new LoginFragment())
                            .addToBackStack(null)
                            .commit();

                } else {

                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contentMainFragment, new StudentProfileFragment())
                            .addToBackStack(null)
                            .commit();

                }


            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}   // Main Class
