package com.example.Fragment_example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FindFragment extends Fragment {
    EditText mEditTextSearch;
    Button mButtonSearch;
    SharedPreferencesHelper mSharedPreferencesHelper;

    public static FindFragment newInstance() {
        Bundle args = new Bundle();
        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View.OnClickListener OnClickButtonSearchListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (mSharedPreferencesHelper.getId()){
                case(R.id.rb_yandex):
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://yandex.ru/search/?text="+mEditTextSearch.getText()));
                    startActivity(intent);
                    break;
                case(R.id.rb_bing):
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.bing.com/search?q="+mEditTextSearch.getText()));
                    startActivity(intent);
                    break;
                default:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://google.com/search?q="+mEditTextSearch.getText()));
                    startActivity(intent);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_ma_find, container, false);
        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        mEditTextSearch = v.findViewById(R.id.et_search);
        mButtonSearch = v.findViewById(R.id.b_search);
        mButtonSearch.setOnClickListener(OnClickButtonSearchListener);

        return v;
    }
}
