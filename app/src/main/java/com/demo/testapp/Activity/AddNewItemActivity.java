package com.demo.testapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.demo.testapp.Model.ItemModel;
import com.demo.testapp.R;

public class AddNewItemActivity extends AppCompatActivity {

    private EditText etName, etDesription;
    private Button btnSubmit;
    private ImageView ivBack, ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        defComponents();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Item Name",Toast.LENGTH_LONG).show();
                }else if(etDesription.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Description",Toast.LENGTH_LONG).show();
                }else{
                    submit();
                }
            }
        });
    }

    private void submit() {

        String label = etName.getText().toString();
        String description = etDesription.getText().toString();
        BitmapDrawable drawable = (BitmapDrawable) ivImg.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ItemViewActivity.itemList.add(new ItemModel(label, description, bitmap));

        Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show();
        Log.v("newItem","arr = "+ItemViewActivity.itemList.toString());

        finish();

    }

    private void defComponents() {
        etName = findViewById(R.id.name);
        etDesription = findViewById(R.id.des);
        ivBack = findViewById(R.id.back);
        ivImg = findViewById(R.id.ivImg);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}