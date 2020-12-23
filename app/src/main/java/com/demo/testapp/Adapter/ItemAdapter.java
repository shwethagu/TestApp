package com.demo.testapp.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.testapp.Activity.ItemViewActivity;
import com.demo.testapp.Model.ItemModel;
import com.demo.testapp.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Activity activity;
    ArrayList<ItemModel> itemList = new ArrayList<>();
    Dialog dialog;

    public ItemAdapter(Activity activity, ArrayList<ItemModel> itemList) {

        this.activity = activity;
        this.itemList = itemList;

    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_single_item, parent, false);

        return new ItemAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {

        ItemModel model = itemList.get(position);

        holder.tvTitle.setText(model.getLabel());
        holder.tvDescription.setText(model.getDescription());
        holder.ivImage.setImageBitmap(model.getImage());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(activity);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_edit_layout);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                EditText etName = dialog.findViewById(R.id.name);
                EditText etDes = dialog.findViewById(R.id.des);
                Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

                etName.setText(model.getLabel());
                etDes.setText(model.getDescription());

                dialog.show();
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ItemModel item = new ItemModel(etName.getText().toString(),etDes.getText().toString(),itemList.get(position).getImage());
                        itemList.set(position,item);
                        notifyDataSetChanged();
                        Toast.makeText(activity,"Updated Successfully",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemViewActivity.itemList.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, edit, delete;
        ImageView ivImage;

        public ViewHolder(View view) {
            super(view);

            tvTitle = (TextView)view.findViewById(R.id.tvLabel);
            tvDescription = (TextView)view.findViewById(R.id.tvDesc);
            ivImage = (ImageView)view.findViewById(R.id.iv_image);
            edit = view.findViewById(R.id.edit);
            delete = view.findViewById(R.id.delete);

        }

    }


}
