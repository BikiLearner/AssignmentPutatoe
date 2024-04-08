package com.example.newputatoeassingment;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Profile_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().setStatusBarColor(Color.parseColor("#00a1a9"));
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton backButton=findViewById(R.id.back_button);
        backButton.setOnClickListener(v->{
            finish();
        });

        RecyclerView recyclerView=findViewById(R.id.recycler_view_profile);
        setRecyclerView(recyclerView,getList1());

    }
    private void setRecyclerView(RecyclerView recyclerView, ArrayList<ImageData> datas){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerHomeAdapter recyclerHomeAdapter=new RecyclerHomeAdapter(this,datas);
        recyclerView.setAdapter(recyclerHomeAdapter);
    }
    private ArrayList<ImageData> getList1(){
        ArrayList<ImageData> imageDataArrayList=new ArrayList<>();
        imageDataArrayList.add(new ImageData(
                "https://cdn-icons-png.flaticon.com/128/1514/1514415.png",
                "My Service"));
        imageDataArrayList.add(new ImageData(
                "https://cdn-icons-png.flaticon.com/512/950/950320.png",
                "My Bills"));
        imageDataArrayList.add(new ImageData(
                "https://cdn-icons-png.flaticon.com/128/1008/1008010.png",
                "My order"));
        imageDataArrayList.add(new ImageData(
                "https://cdn-icons-png.flaticon.com/512/6317/6317814.png",
                "My Account"));
        imageDataArrayList.add(new ImageData(
                "https://icons.veryicon.com/png/o/miscellaneous/car-dealer-app/my-wallet-4.png",
                "My Wallet"));
        return imageDataArrayList;
    }
}