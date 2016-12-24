package malviya.com.studentregistration_customviews.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import malviya.com.studentregistration_customviews.R;
import malviya.com.studentregistration_customviews.activity.Dashboard;
import malviya.com.studentregistration_customviews.model.Student;

/**
 * Created by Mridul Malviya on 12/22/2016.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {
    private List<Student> mArrayList;
    private Dashboard mDashBoard;

    public DashboardAdapter(List<Student> mArrayList, Context mContext) {
        this.mArrayList = mArrayList;
        this.mDashBoard = (Dashboard) mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_data_row, parent, false);
        return new MyViewHolder(view, mDashBoard);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mArrayList.get(position).getName());
        holder.age.setText(String.valueOf(mArrayList.get(position).getAge()));
        holder.branch.setText(mArrayList.get(position).getBranch());
        holder.avg_marks.setText(String.valueOf(mArrayList.get(position).getAverageMarks()));
        holder.course.setText(mArrayList.get(position).getCourse());
        holder.grade.setText(mArrayList.get(position).getGrade());
        holder.strength.setText(mArrayList.get(position).getStrength());

        if (!mDashBoard.isContextMode) {
            holder.checkBox.setVisibility(View.GONE);
        } else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, age, branch, avg_marks, course, grade, strength;
        CheckBox checkBox;
        Dashboard mDashBoard;
        CardView cardView;

        MyViewHolder(View itemView, Dashboard dashboard) {
            super(itemView);

            mDashBoard = dashboard;
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_dashboard);
            name = (TextView) itemView.findViewById(R.id.txt_StuName);
            age = (TextView) itemView.findViewById(R.id.txt_StuAge);
            branch = (TextView) itemView.findViewById(R.id.txt_StuBranch);
            avg_marks = (TextView) itemView.findViewById(R.id.txt_StuAvgMarks);
            course = (TextView) itemView.findViewById(R.id.txt_StuCourse);
            grade = (TextView) itemView.findViewById(R.id.txt_StuGrade);
            strength = (TextView) itemView.findViewById(R.id.txt_StuStrength);
            cardView = (CardView) itemView.findViewById(R.id.cardLayout_id);
            cardView.setOnClickListener(mDashBoard);
            cardView.setOnLongClickListener(mDashBoard);
            checkBox.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mDashBoard.prepareSelection(view, getAdapterPosition());
        }

    }

    public void updateAdapter(ArrayList<Student> pList) {
        for (Student studentObj : pList) {
            mArrayList.remove(studentObj);
        }
    }
}
