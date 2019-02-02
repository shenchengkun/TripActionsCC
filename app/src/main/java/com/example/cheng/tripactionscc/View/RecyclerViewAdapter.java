package com.example.cheng.tripactionscc.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cheng.tripactionscc.Model.Beans.SearchDocs;
import com.example.cheng.tripactionscc.Model.Beans.SearchMultiMedia;
import com.example.cheng.tripactionscc.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private OnItemClickListener mClickListener;
    private Context context;
    private List<SearchDocs> list;

    public RecyclerViewAdapter(Context context, List<SearchDocs> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_result,viewGroup,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.textView.setText(list.get(i).getHeadline().getMain());
        List<SearchMultiMedia> searchMultiMediaList = list.get(i).getMultimedia();
        if(searchMultiMediaList.size() > 0) Glide.with(context).
                load("https://www.nytimes.com/"+
                searchMultiMediaList.get(0).getUrl()).into(myViewHolder.imageView);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnViewItemClickListener(OnItemClickListener onViewItemClickListener){
        mClickListener = onViewItemClickListener;
    }
}
