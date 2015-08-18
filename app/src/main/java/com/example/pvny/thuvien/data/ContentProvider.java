package com.example.pvny.thuvien.data;

/**
 * Created by PVNY on 19/08/2015.
 */
public class ContentProvider {

    private int _id;
    private String _name;
    private String _content;

    public ContentProvider(){
        //Constructor Vacio
    }
    public ContentProvider(String name, String content) {
        this._name = name;
        this._content = content;
    }

    //id
    public int get_id() {
        return _id;
    }
    public void set_id(int id) {
        this._id = id;
    }

    //name
    public String get_name() {
        return _name;
    }
    public void set_name(String name) {
        this._name = name;
    }

    //content
    public String get_content() {
        return _content;
    }
    public void set_content(String content) {
        this._content = content;
    }

}