package com.example.sidharth.pocketexpensemanager.data;

/**
 * Created by root on 28/3/17.
 */

public class Category_DB {
    private int _id;
    private String _date;
    private String _money;
    private String _description;
    private String _category;
    public Category_DB(){

    }
    public Category_DB(String _date,String _description,String _money,String _category){
        this._date=_date;
        this._description=_description;
        this._money=_money;
        this._category=_category;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_money(String _money) {
        this._money = _money;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_category(String _category) {this._category = _category; }

    public int get_id() {
        return _id;
    }

    public String get_date() {
        return _date;
    }

    public String get_money() {
        return _money;
    }

    public String get_description() {
        return _description;
    }

    public String get_category() { return _category; }
}
