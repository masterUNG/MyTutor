package manop.mytutor.com.mytutor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.utility.TeacherModel;

public class TeacherCourseFragment extends Fragment {

    private String uidString;
    private int anInt;

    public static TeacherCourseFragment teacherCourseInstance(String uidString) {
        TeacherCourseFragment teacherCourseFragment = new TeacherCourseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        teacherCourseFragment.setArguments(bundle);
        return teacherCourseFragment;
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getValueFromFirebase();



    }   // Main Method

    private void getValueFromFirebase() {
        uidString = getArguments().getString("Uid");
        Log.d("22SepV2", "Uid of Course ==> " + uidString);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference()
                .child("Teacher").child(uidString);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TeacherModel teacherModel = dataSnapshot.getValue(TeacherModel.class);
                String courseString = teacherModel.getCourse();
                createCourseRecyclerView(courseString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void createCourseRecyclerView(String courseString) {

        Log.d("22SepV2", "Course ==> " + courseString);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_course, container, false);
        return view;
    }
}
