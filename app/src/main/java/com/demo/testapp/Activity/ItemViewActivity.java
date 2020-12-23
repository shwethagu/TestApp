package com.demo.testapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.demo.testapp.Adapter.ItemAdapter;
import com.demo.testapp.Model.ItemModel;
import com.demo.testapp.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewActivity extends Activity {

    String TAG = "FActivity";
    ImageView ivAdd;
    public static ArrayList<ItemModel> itemList = new ArrayList<>();
    RecyclerView rvItem;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Log.d(TAG,"onCreate");

        ivAdd = findViewById(R.id.ivAdd);
        rvItem = findViewById(R.id.rvItems);


        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddNewItemActivity.class));
            }
        });

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.veg1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.veg2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.veg3);

        itemList.add(new ItemModel("Brocolli", "Sauran BROCCOLI vegetable (100 per packet) Seed  (100 per packet)",bitmap1));
        itemList.add(new ItemModel("Tomato", "Organic Tomato - Net: 450g-550g",bitmap2));
        itemList.add(new ItemModel("Ridge Gourd", "Organic Ridge Gourd - 1 pack (450g)",bitmap3));


    }


    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ItemAdapter(ItemViewActivity.this,itemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvItem.setLayoutManager(layoutManager);
        rvItem.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

    }
}