package uk.ac.tees.b1065781.kidspreschoolplayandlearn.activity.video;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import uk.ac.tees.b1065781.kidspreschoolplayandlearn.R;
import uk.ac.tees.b1065781.kidspreschoolplayandlearn.adapter.VideoListAdapter;
import uk.ac.tees.b1065781.kidspreschoolplayandlearn.database.DatabaseHelper;
import uk.ac.tees.b1065781.kidspreschoolplayandlearn.model.ModelVideo;
import uk.ac.tees.b1065781.kidspreschoolplayandlearn.utils.Utils;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ListVideoActivity extends AppCompatActivity {

    Context context;
    DatabaseHelper databaseHelper;
    RelativeLayout llAdView;
    LinearLayout llAdViewFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);
        getSupportActionBar().hide();
        context=this;
        initDefine();
    }



    private void initDefine() {
        rvVideoList=findViewById(R.id.rvVideoList);
        TextView txtTitleSubHome=findViewById(R.id.txtTitleSubHome);
        Intent intent=getIntent();
        txtTitleSubHome.setText(intent.getStringExtra("Category"));
        setRvVideoListAdapter();
        llAdView = findViewById(R.id.llAdView);
        llAdViewFacebook = findViewById(R.id.llAdViewFacebook);
        Utils.loadBannerAd(this,llAdView,llAdViewFacebook);
    }

    RecyclerView rvVideoList;
    ArrayList<ModelVideo> arrOfVideoList;
    VideoListAdapter videoListAdapter;
    private void setRvVideoListAdapter() {
        databaseHelper=new DatabaseHelper(context);
        arrOfVideoList=databaseHelper.getVideoDetails();
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rvVideoList.setLayoutManager(staggeredGridLayoutManager);
        videoListAdapter=new VideoListAdapter(context,arrOfVideoList);
        rvVideoList.setAdapter(videoListAdapter);
    }

    public void onClickBack(View view) {
        finish();
    }
}
