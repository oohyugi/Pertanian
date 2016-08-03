package id.padai.pertanian;

import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.padaiapi.dao.LoginDao;
import id.padai.pertanian.databinding.ActivityLoginBinding;
import id.padai.pertanian.utils.MyTextWatcher;

/**
 * Created by yogi on 05/06/16.
 */
public class LoginVM extends GitsVM<LoginController , ActivityLoginBinding> {
    public String bUserName;
    public String bUserPass;
    public String kategori="admin";
    public ObservableField<String>bTextLogin = new ObservableField<>();
    int statusButton =0;

    public LoginVM(AppCompatActivity activity, LoginController controller, ActivityLoginBinding binding) {
        super(activity, controller, binding);



        if (statusButton==0){
            bTextLogin.set("Login");
        }else{
            bTextLogin.set("Register");
        }
       /* switch ( mBinding.spinKategori.getSelectedItemPosition()){
            case 0:
                kategori= "tidak ada";

                break;
            case 1:
                kategori= "admin";
                Toast.makeText(mActivity,"You selected Admin",Toast.LENGTH_SHORT).show();
                break;

        }*/
    }

    private void checkItemSpinner() {

    }

    public void onCLickLogin(View view){
        if (statusButton==0){
            if (!TextUtils.isEmpty(bUserName) && !TextUtils.isEmpty(bUserPass)
                    && !TextUtils.isEmpty(kategori) ){
                //MainActivity.startActivity(mActivity);
                mController.LoginFireBase(bUserName,bUserPass);
                mController.callUser(bUserName,bUserPass,kategori);
                Log.wtf("DATA",bUserName+bUserPass+kategori);

            }else{
                Toast.makeText(mActivity,"Please Insert username or password",Toast.LENGTH_SHORT).show();
            }
        }else{
            mController.RegisterFireBase(bUserName,bUserPass);
        }


    }
    public void onCLickRegister(View view){
       bTextLogin.set("Register");
        statusButton=1;



    }

    public MyTextWatcher bUserNameWatcher= new MyTextWatcher() {
        @Override
        public void afterTextChanged(Editable editable) {
            bUserName = editable.toString();
        }
    };
    public MyTextWatcher bUserPassWatcher= new MyTextWatcher() {
        @Override
        public void afterTextChanged(Editable editable) {
            bUserPass = editable.toString();
        }
    };


    public void setValue(LoginDao loginDaoBaseDao) {
        Log.w(App.TAG,loginDaoBaseDao.getId());
    }
}
