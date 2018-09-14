package manop.mytutor.com.mytutor.utility;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.tablayout.DataRecyclerFragment;

public class RecyclerviewAdepter extends RecyclerView.Adapter<RecyclerviewAdepter.MyCourseViewHolder>{

    private List<DataRecyclerFragment> dataRecyclerFragmentList;


    @NonNull
    @Override
    public MyCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_data_recyclerview, parent, false);

        return new MyCourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseViewHolder holder, int position) {

        DataRecyclerFragment dataRecyclerFragment = dataRecyclerFragmentList.get(position);
        holder.coursename.setText(dataRecyclerFragment.getCoursename());
        holder.teachername.setText(dataRecyclerFragment.getTeachername());
        holder.detail.setText(dataRecyclerFragment.getDetail());
        holder.teacherphoto.setImageResource(dataRecyclerFragment.getTeacherphoto());
    }

    @Override
    public int getItemCount() {
        return dataRecyclerFragmentList.size();
    }

    public class MyCourseViewHolder extends RecyclerView.ViewHolder {
        public TextView coursename, teachername, detail;
        public ImageView teacherphoto;

        public MyCourseViewHolder(View itemView) {
            super(itemView);
            coursename = (TextView) itemView.findViewById(R.id.recyclerCourse1);
            teachername = (TextView) itemView.findViewById(R.id.recyclerTeacher1);
            detail = (TextView) itemView.findViewById(R.id.recyclerDetail);
            teacherphoto = (ImageView) itemView.findViewById(R.id.recyclerPhoto1);
        }
    }

    public RecyclerviewAdepter(List<DataRecyclerFragment> dataRecyclerFragmentList) {
        this.dataRecyclerFragmentList = dataRecyclerFragmentList;


    }




}
