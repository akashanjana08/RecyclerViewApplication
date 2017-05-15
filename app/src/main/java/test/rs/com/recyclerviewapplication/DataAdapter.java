package test.rs.com.recyclerviewapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Akash.Sharma on 5/15/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder>
{
    List<test.rs.com.recyclerviewapplication.Worldpopulation.WorldpopulationBean> list;
    Context mContexrt;

    public DataAdapter(List<test.rs.com.recyclerviewapplication.Worldpopulation.WorldpopulationBean> list , Context mContexrt)
    {
        this.list      = list;
        this.mContexrt = mContexrt;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, null);

        CustomViewHolder customViewHolder = new CustomViewHolder(view);

        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position)
    {
        holder.textView1.setText(list.get(position).getCountry());
        holder.textView2.setText(list.get(position).getPopulation());
        Picasso.with(mContexrt).load(list.get(position).getFlag()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

         TextView textView1,textView2;
         ImageView imageView;
         public CustomViewHolder(View view)
         {
             super(view);
             textView1 = (TextView)view.findViewById(R.id.textView1);
             textView2 = (TextView)view.findViewById(R.id.textView2);
             imageView = (ImageView)view.findViewById(R.id.imageView);
         }

    }


}
