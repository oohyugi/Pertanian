package id.padai.pertanian.utils;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by yogi on 03/06/16.
 */
public abstract class MyTextWatcher implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public abstract void afterTextChanged(Editable editable);
}
