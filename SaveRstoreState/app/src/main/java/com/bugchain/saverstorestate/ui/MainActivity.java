package com.bugchain.saverstorestate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bugchain.saverstorestate.R;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionbar();

        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activity:
                    startActivity(new Intent(this,ActivityState.class));
                break;
            case R.id.btn_fragment:

                break;
        }
    }

    private void setupActionbar(){
        final Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
    }


}
