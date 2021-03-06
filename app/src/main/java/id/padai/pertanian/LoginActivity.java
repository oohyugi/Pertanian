package id.padai.pertanian;

import android.content.Context;
import android.content.Intent;

import id.gits.mvvmcore.activity.GitsActivity;

public class LoginActivity extends GitsActivity<LoginController> {


    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginController createController() {
        return new LoginController();
    }


    public static void startActivity(Context context){
        context.startActivity(new Intent(context,LoginActivity.class));
    }
}
