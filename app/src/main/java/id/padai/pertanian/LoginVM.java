package id.padai.pertanian;

import android.app.ProgressDialog;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.pertanian.databinding.ActivityLoginBinding;
import id.padai.pertanian.utils.MyTextWatcher;

/**
 * Created by yogi on 05/06/16.
 */
public class LoginVM extends GitsVM<LoginController , ActivityLoginBinding> {
    public String bUserName="";
    public String bUserPass="";
    public String kategori="admin";
    public ObservableField<String>bTextLogin = new ObservableField<>();
    int statusButton =0;

    ProgressDialog mProgressDialog;

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



    public void onCLickLogin(View view){
        if (statusButton==0){

            boolean isActive = true;


            if (TextUtils.isEmpty(bUserName)){
                isActive=false;
                mBinding.edUserName.setError("Username tidak boleh kosong");

            }else if (TextUtils.isEmpty(bUserPass)){
                isActive=false;
                mBinding.edPassword.setError("Password tidak boleh kosong");

            }
            if (!TextUtils.isEmpty(bUserName) && !TextUtils.isEmpty(bUserPass)){
                //MainActivity.startActivity(mActivity);
                isActive=true;
                mProgressDialog = ProgressDialog.show(mActivity,null, "Silakan tunggu..");
                mController.callUser(bUserName,bUserPass);

            }

        }else{
            mController.Register(bUserName,bUserPass);
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


    public void hideDialog() {
        mProgressDialog.dismiss();
    }
}
