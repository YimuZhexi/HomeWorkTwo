package com.example.homeworktwo;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateFragment extends DialogFragment implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private EditText cEtUsername, cEtPassword_1, cEtPassword_2;
    private Button cBtnYes, cBtnLast;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog);
    }

    public static CreateFragment newInstance() {

        Bundle args = new Bundle();
        CreateFragment fragment = new CreateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载 xml 布局
        view = inflater.inflate(R.layout.create_fragment, null, false);
        view.setElevation(30);
        initView();
        setView();
        return view;
    }

    private void initView() {
        sharedPreferences = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        cEtUsername = view.findViewById(R.id.et_fragment_username_create);
        cEtPassword_1 = view.findViewById(R.id.et_fragment_password_create_1);
        cEtPassword_2 = view.findViewById(R.id.et_fragment_password_create_2);
        cBtnYes = view.findViewById(R.id.btn_fragment_create_yes);
        cBtnLast = view.findViewById(R.id.btn_fragment_create_last);
    }

    private void setView() {
        cBtnYes.setOnClickListener(this);
        cBtnLast.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragment_create_yes:
                createJudge();
                break;
            case R.id.btn_fragment_create_last:
                last();
                break;
        }
    }

    public void createJudge() {
        String password1, password2, username;
        username = cEtUsername.getText().toString();
        password1 = cEtPassword_1.getText().toString();
        password2 = cEtPassword_2.getText().toString();
        if(username.equals("")){
            Toast.makeText(getActivity(), "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if(password1.equals("")||password2.equals("")){
            Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
        }else {
            if (password1.equals(password2)) {
                editor.remove("username");
                editor.remove("password");
                editor.putString("username", username);
                editor.putString("password", password1);
                editor.commit();
                Toast.makeText(getActivity(), "创建成功", Toast.LENGTH_SHORT).show();
                dismiss();
            }else{
                Toast.makeText(getActivity(), "密码不匹配\n请重新检查！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void last(){
        Toast.makeText(getActivity(), "取消注册 ", Toast.LENGTH_SHORT).show();
        dismiss();
    }
}