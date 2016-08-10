package id.padai.pertanian.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import id.gits.mvvmcore.activity.GitsActivity;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;

public class DetailActivity extends GitsActivity<DetailController> {
    private static final String PARAM = "data";
    TanamanDao tanamanDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //mController.callAPI(tanamanDao.getId());
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected DetailController createController() {
        return new DetailController();
    }

    public static void startActivity(Context context, TanamanDao data){
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra(PARAM,data);
        context.startActivity(intent);
    }

}
