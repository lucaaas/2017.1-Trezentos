package fga.mds.gpp.trezentos.View;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;
import fga.mds.gpp.trezentos.Model.UserClass;
import fga.mds.gpp.trezentos.R;

public class ClassAdapter extends RecyclerView.Adapter implements Filterable{
    private ArrayList<UserClass> userClasses;
    public ArrayList<UserClass> filteredClasses;
    private Context context;
    private RecyclerView recyclerView;
    private FriendFilter friendFilter;
    private ClassViewHolder.OnItemClickListener listener;

    public void setOnItemClickListener(ClassViewHolder.OnItemClickListener listener) {
        this.listener = listener;
    }


    public ClassAdapter(ArrayList<UserClass> userClasses, Context context, RecyclerView recyclerView){
        this.userClasses = userClasses;
        this.filteredClasses = userClasses;
        this.context = context;
        this.recyclerView =  recyclerView;
        getFilter();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_item, parent, false);
        ClassViewHolder holder = new ClassViewHolder(view);
        holder.setOnItemClickListener(listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserClass userClass  = filteredClasses.get(position);
        ClassViewHolder classViewHolder = (ClassViewHolder) holder;
        classViewHolder.name.setText(userClass.getClassName());
        classViewHolder.institution.setText(userClass.getInstitution());

    }

    @Override
    public int getItemCount() {
        return filteredClasses.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public Filter getFilter() {
        if (friendFilter == null) {
            friendFilter = new FriendFilter(userClasses, this);
        }

        return friendFilter;
    }

}