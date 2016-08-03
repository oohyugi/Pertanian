package id.padai.pertanian;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.padaiapi.core.MyObserver;
import id.padai.padaiapi.dao.BaseDao;
import id.padai.padaiapi.dao.LoginDao;
import id.padai.padaiapi.repository.LoginRepo;
import id.padai.pertanian.dasboard.MainActivity;
import id.padai.pertanian.databinding.ActivityLoginBinding;
import id.padai.pertanian.utils.ChatHelper;
import id.padai.pertanian.utils.Constan;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yogi on 05/06/16.
 */
public class LoginController extends GitsController<LoginVM, ActivityLoginBinding> {

    private String TAG="LOGIN";
    Firebase mFirebase;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    public LoginVM createViewModel(ActivityLoginBinding binding) {
        return new LoginVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityLoginBinding binding, LoginVM viewModel) {
        binding.setVm(viewModel);

    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);
        mFirebase =new Firebase("https://project-2197379670504232022.firebaseio.com/");
        mAuth= FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if (user !=null){
                    Log.d(TAG, "onAuthStateChanged: sign "+user.getUid());


                }else{
                    Log.d(TAG, "onAuthStateChanged: sign out");
                }

            }

        };

    }

    public void callUser(final String bUserName, String bUserPass, String kategori) {
        LoginRepo loginRepo = new LoginRepo(App.getApi(),bUserName,bUserPass,kategori);
        addSubscription(App.getApi().getApiService().postLogin(bUserName,bUserPass,kategori)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<BaseDao<LoginDao>>() {
                    @Override
                    public void onApiResultCompleted() {

                    }

                    @Override
                    public void onApiResultError(String message) {
                        Log.wtf(App.TAG, String.valueOf(message));
                    }

                    @Override
                    public void onApiResultOk(BaseDao<LoginDao> loginDaoBaseDao) {

                if (loginDaoBaseDao.STATUS){
                   mViewModel.setValue(loginDaoBaseDao.DATA);
                    Log.wtf(App.TAG, String.valueOf(loginDaoBaseDao.DATA.getUsername()));
                    MainActivity.startActivity(mActivity);
                }

                Log.wtf(App.TAG, String.valueOf(loginDaoBaseDao.STATUS));



                /*if (baseDao.STATUS==true){
                    MainActivity.startActivityMain(mActivity);
                }else{
                    Toast.makeText(mActivity,"Salah",Toast.LENGTH_SHORT).show();
                }*/





            }


        }));

    }

    public void LoginFireBase(String bUserName, String bUserPass) {
        Log.d(TAG, "signIn:" + bUserName);
        mAuth.signInWithEmailAndPassword(bUserName,bUserPass).addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Log.w(TAG, "signInWithEmail", task.getException());
                    Toast.makeText(mActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void onStart() {
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    public void onStop() {
        if (mAuthStateListener !=null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    public void RegisterFireBase(final String bUserName, final String bUserPass) {
        mFirebase.createUser(bUserName, bUserPass, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                Toast.makeText(mActivity, "Successfully registered!", Toast.LENGTH_SHORT).show();

                mFirebase.authWithPassword(bUserName, bUserPass, new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        Map<String ,Object>map = new HashMap<String, Object>();
                        map.put(Constan.KEY_PROVIDER,authData.getProvider());
                        map.put(Constan.KEY_FIRST_NAME,"YOGI");
                        map.put(Constan.KEY_USER_EMAIL,authData.getProviderData().get(Constan.KEY_EMAIL));
                        map.put(Constan.CHILD_CONNECTION,Constan.KEY_ONLINE);
                        map.put(Constan.KEY_AVATAR_ID, ChatHelper.generateRandomAvatarForUser());
                        long createTime = new Date().getTime();
                        map.put(Constan.KEY_TIMESTAMP, String.valueOf(createTime));
                        mFirebase.child(Constan.CHILD_USERS).child(authData.getUid()).setValue(map);



                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        Toast.makeText(mActivity, "An error occurred!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(FirebaseError firebaseError) {

                showErrorMessageToUser(firebaseError.getMessage());
            }
        });
      /*  mAuth.createUserWithEmailAndPassword(bUserName,bUserPass )
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        Map<String ,Object>map = new HashMap<String, Object>();
                        map.put(Constan.KEY_PROVIDER,task.)
                        if (!task.isSuccessful()){
                            Toast.makeText(mActivity,"Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });*/
    }

    private void showErrorMessageToUser(String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
        builder.setMessage(errorMessage)
                .setTitle(getString(R.string.login_error_title))
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
