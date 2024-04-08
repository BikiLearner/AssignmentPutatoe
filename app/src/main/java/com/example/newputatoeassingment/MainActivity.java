package com.example.newputatoeassingment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().setStatusBarColor(Color.parseColor("#00a1a9"));

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CardView profileCardView=findViewById(R.id.profile_card);
        LinearLayout profileLinearLayout=findViewById(R.id.profile_linearlayout);

        profileCardView.setOnClickListener(v->{
            Intent intent=new Intent(MainActivity.this, Profile_activity.class);
            startActivity(intent);
        });
        profileLinearLayout.setOnClickListener(v->{
            Intent intent=new Intent(MainActivity.this, Profile_activity.class);
            startActivity(intent);
        });

        RecyclerView recyclerView=findViewById(R.id.home_recycler_view);
        RecyclerView recyclerView2=findViewById(R.id.home_recycler_view_2);
        setCorosol();
        setRecyclerView(recyclerView,getList1());
        setRecyclerView(recyclerView2,getList2());
    }

    private void setCorosol() {
        ImageCarousel carousel = findViewById(R.id.carousel);

        // Register lifecycle. For activity, use lifecycle, and for fragment, use viewLifecycleOwner
        carousel.registerLifecycle(getLifecycle());

        List<CarouselItem> list = new ArrayList<>();

        // Add the provided image links
        list.add(new CarouselItem("https://storage.googleapis.com/putatoeapp/Image/testImage/V2I25QX"));
        list.add(new CarouselItem("https://storage.googleapis.com/putatoeapp/Image/testImage/HFY0ZD9"));
        list.add(new CarouselItem("https://storage.googleapis.com/putatoeapp/Image/testImage/4NXEA6H"));
        list.add(new CarouselItem("https://storage.googleapis.com/putatoeapp/Image/testImage/8HBMUHJ"));

        // Set data to carousel
        carousel.setData(list);
        carousel.setAutoPlay(true);
        carousel.setAutoWidthFixing(true);
        carousel.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        carousel.setShowNavigationButtons(false);
    }
    private void setRecyclerView(RecyclerView recyclerView,ArrayList<ImageData> datas){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerHomeAdapter recyclerHomeAdapter=new RecyclerHomeAdapter(this,datas);
        recyclerView.setAdapter(recyclerHomeAdapter);
    }
    private ArrayList<ImageData> getList1(){
        ArrayList<ImageData> imageDataArrayList=new ArrayList<>();
        imageDataArrayList.add(new ImageData(
                "https://static.vecteezy.com/system/resources/thumbnails/019/994/069/small_2x/recharge-mobile-icon-vector.jpg",
                "Mobile recharge"));
        imageDataArrayList.add(new ImageData(
                "https://cdn.iconscout.com/icon/free/png-256/free-dth-1817183-1538051.png",
                "DTH recharge"));
        imageDataArrayList.add(new ImageData(
                "https://img.freepik.com/premium-vector/infographic-fastag-icon-logo-marketing-vector-illustration_689526-970.jpg",
                "Fast Tag"));
        imageDataArrayList.add(new ImageData(
                "https://cdn.iconscout.com/icon/free/png-256/free-data-card-729031.png",
                "Data Card"));

        imageDataArrayList.add(new ImageData(
                "https://en.pimg.jp/100/386/986/1/100386986.jpg",
                "Metro Card Recharge"));
        return imageDataArrayList;
    }
    private ArrayList<ImageData> getList2(){
        ArrayList<ImageData> imageDataArrayList=new ArrayList<>();
        imageDataArrayList.add(new ImageData(
                "https://cdn.iconscout.com/icon/free/png-256/free-gas-cylinder-1817278-1538148.png",
                "Gas Booking"));
        imageDataArrayList.add(new ImageData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwt1CJTlBDwC-1TV3CpKMuuWd6hx8iGQ-t0c_AIRQzNg&s",
                "Electricity Bill Payment"));
        imageDataArrayList.add(new ImageData(
                "https://static.vecteezy.com/system/resources/previews/002/265/446/original/water-utility-bill-payment-icon-vector.jpg",
                "Water Bill Payment"));
        imageDataArrayList.add(new ImageData(
                "https://cdn.iconscout.com/icon/free/png-256/free-traffic-challan-1817252-1538125.png",
                "Challan payment"));
        imageDataArrayList.add(new ImageData(
                "https://cdn.iconscout.com/icon/premium/png-256-thumb/tuition-fee-2-534372.png",
                "Education fees"));
        return imageDataArrayList;
    }
}