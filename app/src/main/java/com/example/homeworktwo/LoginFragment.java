package com.example.homeworktwo;

import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private SharedPreferences sharedPreferences;

    private EditText fgEtUsername,fgEtPassword;
    private Button fgBtnCreate,fgBtnLogin;
    private CheckBox fgCbRemember;
    View view;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载 xml 布局
        Log.d("yum","(:)-->> 11111");
        view = inflater.inflate(R.layout.login_fragment, container, false);
        initView();
        setView();
        return view;
    }
    
    public void initView(){
        fgEtUsername = view.findViewById(R.id.et_fragment_username);
        fgEtPassword = view.findViewById(R.id.et_fragment_password);
        fgBtnCreate = view.findViewById(R.id.btn_fragment_create);
        fgBtnLogin = view.findViewById(R.id.btn_fragment_login);
        fgCbRemember = view.findViewById(R.id.cb_fragment_remember);
        sharedPreferences = requireContext().getSharedPreferences("data",Context.MODE_PRIVATE );
    }

    public void setView(){
        fgBtnCreate.setOnClickListener(this);
        fgBtnLogin.setOnClickListener(this);
        fgCbRemember.setOnClickListener(this);
        fgCbRemember.setChecked(true);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fragment_login:
                String username = fgEtUsername.getText().toString();
                String password = fgEtPassword.getText().toString();
                loginJudgment(username,password);
                break;
            case R.id.btn_fragment_create:
                create();
        }
    }

    public void loginJudgment(String username,String password){
        if(username.equals(sharedPreferences.getString("username", ""))){
            if(password.equals(sharedPreferences.getString("password", ""))){
                Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
                loginSucceed();
            }else{
                Toast.makeText(getActivity(), "密码错误！\n请检查!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(), "未查询到用户名", Toast.LENGTH_SHORT).show();
        }
    }

    public void loginSucceed(){

    }

    public void create(){

    }
}