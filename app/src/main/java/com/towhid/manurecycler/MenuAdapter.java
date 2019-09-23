package com.towhid.manurecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    Context context;
    List<MenuItems> mData;

    public MenuAdapter(Context context, List<MenuItems> data) {
        this.context = context;
        this.mData = data;
    }

    private RecyclerViewAdapterListener recyclerViewAdapterListener;
    public void setRecyclerViewAdapterListener(RecyclerViewAdapterListener recyclerViewAdapterListener){
        this.recyclerViewAdapterListener = recyclerViewAdapterListener;
    }

    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MyViewHolder holder, final int position) {
        // holder.navTitle.setText(mData.get(position));
        final int p=position;
        holder.navTitle.setText(mData.get(position).getItem());
        holder.icon.setImageResource(mData.get(position).getIcon());
        holder.item_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recyclerViewAdapterListener != null){
                    recyclerViewAdapterListener.ItemPosition(mData.get(p).getItem());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView navTitle;
        ImageView icon;
        RelativeLayout item_lay;

        public MyViewHolder(View itemView) {
            super(itemView);
            navTitle = (TextView) itemView.findViewById(R.id.nav);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            item_lay = (RelativeLayout) itemView.findViewById(R.id.item_lay);
        }
    }


}
