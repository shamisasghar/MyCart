package com.sha.mycart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.mycart.Model.dataclass;

import java.util.List;

/**
 * Created by SHA on 26/7/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    public CartAdapter(List<dataclass> cartlist, Context context) {
        this.cartlist = cartlist;
        this.context = context;
    }

    private List<dataclass> cartlist;
    private Context context;

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartlistitem, parent, false);
        CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {
        final dataclass list=cartlist.get(position);
        holder.cat.setText(list.getCategory());
        holder.des.setText(list.getDesc());
        holder.cnt.setText(list.getCounter().toString());
        holder.tot.setText(list.getTotal());
    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cat;
        private TextView des;
        private TextView cnt;
        private TextView tot;

        public ViewHolder(View itemView) {
            super(itemView);
            cat=(TextView)itemView.findViewById(R.id.cat_id);
            des=(TextView)itemView.findViewById(R.id.dec_id);
            cnt=(TextView)itemView.findViewById(R.id.cout_id);
            tot=(TextView)itemView.findViewById(R.id.tot_id);
        }
    }
}
