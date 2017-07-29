package com.sha.mycart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.mycart.Model.datamodel;

import java.util.List;

/**
 * Created by SHA on 28/7/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<datamodel> dataModelArrayList;

    public RecycleAdapter(List<datamodel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }
    class Myholder extends RecyclerView.ViewHolder {
        TextView fname, lname;

        public Myholder(View itemView) {
            super(itemView);

            fname = (TextView) itemView.findViewById(R.id.fn);
            lname = (TextView) itemView.findViewById(R.id.ln);
        }
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forthlistitem, null);
        return new Myholder(view);
    }
    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        datamodel dm=dataModelArrayList.get(position);
        holder.fname.setText(dm.getFName());
        holder.lname.setText(dm.getLName());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

}

