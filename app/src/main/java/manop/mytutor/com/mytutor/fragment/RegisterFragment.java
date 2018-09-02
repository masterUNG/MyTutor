package manop.mytutor.com.mytutor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.utility.MyAlert;

public class RegisterFragment extends Fragment{

    private String nameString, emailString, passwordString, rePasswaordString, idcardString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        Student Controller
        studentController();

//        Teacher Controller
        teacherController();


    }   //Main Method

    private void teacherController() {
        Button button = getView().findViewById(R.id.btnTeacher);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckData("Teacher");
            }
        });
    }

    private void studentController() {
        Button button = getView().findViewById(R.id.btnStudent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckData("Student");
            }
        });
    }

    private void CheckData(String childString) {

//        Get Value From Edittext to String
        EditText nameEditText = getView().findViewById(R.id.edtName);
        EditText idcardEditText = getView().findViewById(R.id.edtIDcard);
        EditText emailEditText = getView().findViewById(R.id.edtEmail);
        EditText passwordEditText = getView().findViewById(R.id.edtPassword);
        EditText rePasswordEditText = getView().findViewById(R.id.edtRePassword);

        nameString = nameEditText.getText().toString().trim();
        idcardString = idcardEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        rePasswaordString = rePasswordEditText.getText().toString().trim();

        Log.d("2SepV1", "Pass=" + passwordString);
        Log.d("2SepV1", "rePass=" + rePasswaordString);

        MyAlert myAlert = new MyAlert(getActivity());

        if (nameString.isEmpty()|| idcardString.isEmpty() ||
                emailString.isEmpty() || passwordString.isEmpty() ||
                rePasswaordString.isEmpty()) {
//            Have space
            myAlert.normalDialog("Have Space","Please All Blank");
        } else if (idcardString.length() != 13) {
            myAlert.normalDialog("Id Card False",
                    "Please Fill ID Card 13 Digi");
        } else if (!passwordString.equals(rePasswaordString)) {
//            Password False
            myAlert.normalDialog("Password Not Match",
                    "Please Fill Password Marching");
        } else {
//            Password True


        }



    }   // CheckData

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
}
