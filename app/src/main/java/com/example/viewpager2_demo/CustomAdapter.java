package com.example.viewpager2_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.holder>{

    int images[]=new int[]{R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4
            ,R.drawable.photo5,R.drawable.photo6};
    Context context;

    public CustomAdapter(Context context ) {
                     this.context=context;

    }

    @NonNull
    @Override
    public CustomAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(context).inflate(R.layout.item_viewpager,parent,false);
         return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.holder holder, int position) {
               int pos=position%getItemCount();
                holder.view.setImageResource(images[pos]);


    }



    @Override
    public int getItemCount() {
        return images.length;
    }
    public class holder extends RecyclerView.ViewHolder{

        ImageView view;

        public holder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.image_view);


        }
    }
}
