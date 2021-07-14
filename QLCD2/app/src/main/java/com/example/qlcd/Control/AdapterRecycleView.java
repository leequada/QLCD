package com.example.qlcd.Control;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlcd.Model.Citizen;
import com.example.qlcd.R;
import com.example.qlcd.View.DetailCitizen_Activity;

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder>{
    Context context;
    ArrayList<Citizen> arrayList;

    public AdapterRecycleView(Context context, ArrayList<Citizen> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custome_recyclerview,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterRecycleView.ViewHolder holder, int position) {
        Citizen citizen =arrayList.get(position);
        if(Integer.parseInt(citizen.getSex()) == 0){
            holder.imageView.setBackgroundResource(R.drawable.woman);
        }
        else {
            holder.imageView.setBackgroundResource(R.drawable.man);
        }
        holder.name.setText("Họ và tên: "+citizen.getName());
        holder.cmnd.setText("Số CMND: "+citizen.getCmnd());
        holder.country.setText("Quê quán: "+citizen.getCountry());
        holder.dob.setText("Ngày sinh: "+citizen.getDob());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,cmnd,country,dob;
        Button deletebtn;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            cmnd = itemView.findViewById(R.id.cmnd);
            country = itemView.findViewById(R.id.country);
            dob = itemView.findViewById(R.id.dob);
            deletebtn = itemView.findViewById(R.id.btndelete);

            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(context).setTitle("Xóa công dân")
                            .setMessage("Bạn có muốn xóa công dân này?").setIcon(R.drawable.ic_action_delete)
                            .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    DatabaseDAO databaseDAO = new DatabaseDAO(context);
                                    int res = databaseDAO.deleteCitizen(arrayList.get(getPosition()).getCmnd());
                                    if(res > 0){
                                        Toast.makeText(context,"Đã xóa",Toast.LENGTH_SHORT).show();
                                        arrayList.remove(arrayList.get(getPosition()));
                                        notifyDataSetChanged();
                                    }

                                    }

                            }).setNegativeButton("No",null).show();

                }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailCitizen_Activity.class);
                    intent.putExtra("Citizen",arrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }

}
