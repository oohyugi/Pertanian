package id.padai.pertanian;

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

    @Override
    protected void onStart() {
        super.onStart();
        mController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mController.onStop();

    }
}
