package com.example.Fragment_example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    RadioGroup mRadioGroup;
    RadioButton mRadioButton;
    SharedPreferencesHelper mSharedPreferencesHelper;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    private RadioGroup.OnCheckedChangeListener ChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            //RadioButton rb = radioGroup.findViewById(id);
            //Toast.makeText(getActivity(), rb.getText() +" "+ rb.isChecked(), Toast.LENGTH_SHORT).show();
            //Сохраняем id выбранной кнопки в SharedPreferences
            mSharedPreferencesHelper.addId(id);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_ma_settings, container, false);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        mRadioGroup = v.findViewById(R.id.rg);
        mRadioGroup.setOnCheckedChangeListener(ChangeListener);

        int id_search = mSharedPreferencesHelper.getId();
        if (id_search == R.id.rb_google || id_search == R.id.rb_yandex || id_search == R.id.rb_bing)
            mRadioButton = mRadioGroup.findViewById(id_search);
        else
            mRadioButton = mRadioGroup.findViewById(R.id.rb_google);
        mRadioButton.setChecked(true);

        return v;
    }
}
