package com.example.sidharth.pocketexpensemanager;

/**
 * Created by root on 25/3/17.
 */

public class Category_Data {
    String category_name;
    Integer image;
    public Category_Data(String category_name,Integer image){
        this.category_name = category_name;
        this.image=image;
    }
    public String getText(){
        return category_name;
    }
    public  Integer getImage(){
        return image;
    }
}
