package com.example.chetana.fyp_final;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class monitor_profile extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_profile2);
        button=(Button)findViewById(R.id.button5);
    }

    public void btnClick(View v){
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:47.4925,19.0513"));
        Intent chooser= Intent.createChooser(i,"Launch Maps");
        startActivity(chooser);
    }
}
