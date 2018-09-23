package manop.mytutor.com.mytutor.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import manop.mytutor.com.mytutor.R;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private ArrayList<String> nameCourseStringArrayList,
            periorStringArrayList, contentStringArrayList;
    private LayoutInflater layoutInflater;

    public CourseAdapter(Context context, ArrayList<String> nameCourseStringArrayList,
                         ArrayList<String> periorStringArrayList,
                         ArrayList<String> contentStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameCourseStringArrayList = nameCourseStringArrayList;
        this.periorStringArrayList = periorStringArrayList;
        this.contentStringArrayList = contentStringArrayList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_view_course, parent, false);
        CourseViewHolder courseViewHolder = new CourseViewHolder(view);

        return courseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        String nameCourse = nameCourseStringArrayList.get(position);
        String periorStrint = periorStringArrayList.get(position);
        String contentString = contentStringArrayList.get(position);

        holder.nameCourseTextView.setText(nameCourse);
        holder.periorTextView.setText(periorStrint);
        holder.contentTextView.setText(contentString);


    }

    @Override
    public int getItemCount() {
        return nameCourseStringArrayList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView nameCourseTextView, periorTextView, contentTextView;

        public CourseViewHolder(View itemView) {
            super(itemView);

            nameCourseTextView = itemView.findViewById(R.id.txtNameCourse);
            periorTextView = itemView.findViewById(R.id.txtPeriod);
            contentTextView = itemView.findViewById(R.id.txtContent);


        }
    }

}
