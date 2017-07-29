package com.sha.mycart;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sha.mycart.Model.dataclass;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by SHA on 25/7/2017.
 */

public class CartSession {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "CartSessionPref";

    public static final String CartDetail="";


    public CartSession(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createCartSession(List<dataclass> cart){


        Gson gson= new Gson();


        String use=gson.toJson(cart);
        editor.putString(CartDetail,use);
        editor.commit();
    }
    public List<dataclass> getCartDetails(){
        Type type = new TypeToken<List<dataclass>>(){}.getType();
        List<dataclass> cart = new Gson().fromJson(pref.getString(CartDetail, null), type);
        return cart;
    }
    public String getCartJson(){
        return pref.getString(CartDetail, null);
    }
    public void clearAllCartSession(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

}
