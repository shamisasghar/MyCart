package com.sha.mycart.Model;

public class Contact {

    //private variables
    private int _id;
    private String _fname;
    private String _lname;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String _last_name){
        this._id = id;
        this._fname = name;
        this._lname = _last_name;
    }

    // constructor
    public Contact(String name, String _last_name){
        this._fname = name;
        this._lname = _last_name;
    }

    public String get_fname() {
        return _fname;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public String get_lname() {
        return _lname;
    }

    public void set_lname(String _lname) {
        this._lname = _lname;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
