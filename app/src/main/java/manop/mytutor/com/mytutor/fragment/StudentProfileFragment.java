package manop.mytutor.com.mytutor.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.utility.StudentPagerAdepter;

public class StudentProfileFragment extends Fragment {

    private ImageView imageView;
    private Uri uri;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView textView;


    //    Student Image Controller
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageView = getView().findViewById(R.id.btnStudent);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Please Choose IMage"),
                        1);


            }   //onclick
        });

//        creatTablayout
        creatTablayout();

//        CreatViewPager
        creatViewPager();



    }   //main method

    private void creatViewPager() {
        viewPager = getView().findViewById(R.id.viewPagerStudent);
        StudentPagerAdepter studentPagerAdapter = new StudentPagerAdepter(
                getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(studentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void creatTablayout() {
        tabLayout = getView().findViewById(R.id.tabStudentData);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
//            Success Choose Image
            try {

                uri = data.getData();
                Bitmap bitmap = BitmapFactory
                        .decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);


            } catch (Exception e) {
                e.printStackTrace();
            }


        }   //if


    }   // onactivityResult


    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        return view;

    }
}
