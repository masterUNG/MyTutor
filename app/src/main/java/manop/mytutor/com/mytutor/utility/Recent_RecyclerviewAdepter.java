package manop.mytutor.com.mytutor.utility;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import manop.mytutor.com.mytutor.R;
import manop.mytutor.com.mytutor.tablayout.DataRecyclerFragment;
import manop.mytutor.com.mytutor.tablayout.Data_RecentFragment;

public class Recent_RecyclerviewAdepter extends RecyclerView.Adapter<Recent_RecyclerviewAdepter.RecentViewHolder>{

    private List<Data_RecentFragment> data_recentFragmentList;

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_data_recyclerview_recent, parent, false);

        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {

        Data_RecentFragment data_recentFragment = data_recentFragmentList.get(position);
        holder.coursename.setText(data_recentFragment.getCoursename());
        holder.teachername.setText(data_recentFragment.getTeachername());
        holder.chapter.setText(data_recentFragment.getChapter());
        holder.VDOphoto.setImageResource(data_recentFragment.getVDOphoto());

    }

    @Override
    public int getItemCount() {
        return data_recentFragmentList.size();
    }


    public class RecentViewHolder extends RecyclerView.ViewHolder {
        public TextView coursename, teachername, chapter;
        public ImageView VDOphoto;


        public RecentViewHolder(View itemView) {
            super(itemView);

            coursename = (TextView) itemView.findViewById(R.id.recyclerRecent_Coursename);
            teachername = (TextView) itemView.findViewById(R.id.recyclerRecent_Teacher);
            chapter = (TextView) itemView.findViewById(R.id.recyclerRecent_Chapter);
            VDOphoto = (ImageView) itemView.findViewById(R.id.recyclerRecent_VDO);


        }
    }

    public Recent_RecyclerviewAdepter(List<Data_RecentFragment> data_recentFragmentList) {
        this.data_recentFragmentList = data_recentFragmentList;
    }
}
