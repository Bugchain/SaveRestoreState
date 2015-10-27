package com.bugchain.saverstorestate.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bugchain.saverstorestate.R;
import com.bugchain.saverstorestate.cards.NewsCard;
import com.bugchain.saverstorestate.model.News;
import com.bugchain.saverstorestate.tools.Connect;
import com.bugchain.saverstorestate.tools.MyProgressDialog;

import java.util.List;

/**
 * Created by POSEIDON on 27/10/2558.
 */
public class ActivityState extends AppCompatActivity {

    private static final String TAG = ActivityState.class.getSimpleName();
    private static final String KEY_POSITION = "position";

    private RecyclerView recyclerView;
    private List<News> list;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        setupActionbar();
        viewMatching();

        new LoadNews().execute();
    }

    private void viewMatching(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter(){
        recyclerView.setAdapter(new NewsCard(list));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private class LoadNews extends AsyncTask<Void,Void,Void>{

        private MyProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new MyProgressDialog(ActivityState.this);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String result = new Connect().getNewsFeed();
            list = new News().setup(result);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            setAdapter();
        }
    }

    private void setupActionbar(){
        final Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.state_in_activity));
    }
}
