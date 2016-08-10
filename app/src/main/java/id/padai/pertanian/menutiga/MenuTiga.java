package id.padai.pertanian.menutiga;

import android.content.Context;
import android.content.Intent;

import id.gits.mvvmcore.activity.GitsActivity;
import id.padai.pertanian.R;

public class MenuTiga extends GitsActivity<MenuTigaController> {

  public static String PARAMS= "status";

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_menu_tiga;
    }

    @Override
    protected MenuTigaController createController() {
        return new MenuTigaController();
    }

    public static void startActivity(Context context,String status){
        Intent intent = new Intent(context,MenuTiga.class);
        intent.putExtra(PARAMS,status);
        context.startActivity(intent);
    }
}
