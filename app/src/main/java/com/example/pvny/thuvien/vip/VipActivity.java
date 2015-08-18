package com.example.pvny.thuvien.vip;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.pvny.thuvien.R;

public class VipActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
    }

    public void OpenAdd(View view){

        Intent i = new Intent(this, AddActivity.class);
        startActivity(i);
    }

    public void OpenListView(View view){
        Intent i = new Intent(this, ViewAddActivity.class);
        startActivity(i);
    }

    public void OpenDelete(View view){
        Intent i = new Intent(this, DeleteDataActivity.class);
        startActivity(i);
    }

    public void OpenUpdate(View view){
        Intent i = new Intent(this, OpenUpdateActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
