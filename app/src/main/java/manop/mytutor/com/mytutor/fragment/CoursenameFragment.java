package manop.mytutor.com.mytutor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import manop.mytutor.com.mytutor.R;

public class CoursenameFragment extends Fragment {
//<imagemessage click>
    private static ImageView img;
    private RatingBar rb;
    private TextView value;

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_coursename, container, false);

                rb = (RatingBar)view.findViewById(R.id.ratingbar);
                value = (TextView)view.findViewById(R.id.value);
                rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        value.setText("rating is" + v);

                    }
                });

                return view;



            }

        }
