package com.example.pvny.thuvien.vip;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.example.pvny.thuvien.R;

/**
 * Created by PVNY on 19/08/2015.
 */
public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_view_add, parent, false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idtxt = (TextView) view.findViewById(R.id.textview_id);
        TextView nametxt = (TextView) view.findViewById(R.id.textview_name);
        TextView contenttxt = (TextView) view.findViewById(R.id.textview_content);

        int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String txtname = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String txtcontent = cursor.getString(cursor.getColumnIndexOrThrow("content"));

        idtxt.setText(String.valueOf(txtid));
        nametxt.setText(txtname);
        contenttxt.setText(txtcontent);

    }
}