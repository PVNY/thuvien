package com.example.pvny.thuvien.vip;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
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

public class UpdateActivity extends ActionBarActivity {

    MySQLiteHelper dbHandler;
    EditText name_input;
    EditText content_input;
    int _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name_input = (EditText) findViewById(R.id.edittext_name_update_input);
        content_input = (EditText) findViewById(R.id.edittext_content_update_input);
        dbHandler = new MySQLiteHelper(this, null, null, 1);
        ContentProvider persona = new ContentProvider();
        Intent intent = getIntent();
        String stringid = intent.getStringExtra("id_add");
        int id = Integer.parseInt(stringid);
        Cursor cursor = dbHandler.CursorId(id);

        name_input.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        content_input.setText(cursor.getString(cursor.getColumnIndexOrThrow("content")));
        _id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));

    }

    public void UpdateData(View view){

        ContentProvider persona = new ContentProvider(name_input.getText().toString(), content_input.getText().toString() );
        persona.set_id(_id);
        dbHandler.UpdateData(persona);
        confirmacion();
        Clean();
        finish();
    }

    public void Clean(){

        name_input.setText("");
        content_input.setText("");
    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Successful change!");
        dlgAlert.setTitle("Change");
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
        getMenuInflater().inflate(R.menu.menu_update, menu);
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
