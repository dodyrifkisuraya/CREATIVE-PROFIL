package com.example.dorizu.tablayout;

import android.content.DialogInterface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homeActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = (TabLayout) findViewById(R.id.tablayoutid);
        appBarLayout = (AppBarLayout) findViewById(R.id.topapp);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        viewpageAdapter adapter = new viewpageAdapter(getSupportFragmentManager());
        //tambahkan framen
        adapter.AddFragment(new FragmentProfil(),"P R O F I L");
        adapter.AddFragment(new FragmentHubungi(),"H U B U N G I");
        //aturan fragmen
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);

    }
    public void clickExit(View v){
        finish();
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(homeActivity.this);
        builder.setMessage("Yakin Ingin Keluar?");
        builder.setCancelable(true);
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
