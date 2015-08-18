package com.example.pvny.thuvien.vip;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.pvny.thuvien.R;
import com.example.pvny.thuvien.data.ContentProvider;
import com.example.pvny.thuvien.data.MySQLiteHelper;

public class AddActivity extends ActionBarActivity {

    MySQLiteHelper dbHandler;
    EditText name_input;
    EditText content_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name_input = (EditText) findViewById(R.id.edittext_name_add_input);
        content_input = (EditText) findViewById(R.id.edittext_content_add_input);
        dbHandler = new MySQLiteHelper(this, null, null, 1);
    }

    public void AddData(View view){

       /*if (name_input.getText().toString().trim() == "" || content_input.getText().toString().trim() ==""){
           Toast.makeText(getApplicationContext(),"You have not entered information",Toast.LENGTH_SHORT).show();
       }else {*/
        ContentProvider contentProvider = new ContentProvider(name_input.getText().toString(), content_input.getText().toString());
        dbHandler.AddData(contentProvider);
        Confirmacion();
        Clean();
      /* }*/

    }

    public void Clean(){

        name_input.setText("");
        content_input.setText("");
    }

    public void Confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Added successfully!");
        dlgAlert.setTitle("Add Database");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
