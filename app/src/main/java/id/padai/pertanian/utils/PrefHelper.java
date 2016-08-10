package id.padai.pertanian.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import id.padai.padaiapi.dao.LoginDao;
import id.padai.pertanian.App;

/**
 * Created by yogi on 09/08/16.
 */
public class PrefHelper {

    public static String ACCOUNT = "account";



    private static SharedPreferences getSP(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static String getPref(Context context, String key) {
        return getSP(context).getString(key, null);
    }
    public static void saveAccount(Context context , LoginDao mData) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        preferences.edit().putString(ACCOUNT, App.getGson().toJson(mData)).apply();
    }


    public static LoginDao getAccount(Context context){
        return App.gson.fromJson(getPref(context,ACCOUNT),LoginDao.class);
    }
}
