package com.bwie.taobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bwie.cart.fragment.Fragment_cart;
import com.bwie.home.fragment.Fragment_home;
import com.bwie.sort.fragment.Fragment_class;
import com.bwie.user.activity.LoginActivity;
import com.bwie.user.fragment.Fragment_user;
import com.bwie.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radiogroup_main)
    RadioGroup radiogroupMain;
    @BindView(R.id.main_footer)
    LinearLayout mainFooter;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    private FragmentTransaction beginTransaction;
    private FragmentManager fragmentManager;
    private Fragment_home fragment_home;
    private Fragment_class fragment_class;
    private Fragment_cart fragment_cart;
    private Fragment_user fragment_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SharedPreferencesUtils.setParam(MainActivity.this, "LOGIN_CODE", "1");

        radiogroupMain.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        /*默认登录首页面*/
        fragment_home = new Fragment_home();
        beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.frag_container,fragment_home);
        beginTransaction.commit();

        fragment_class = new Fragment_class();
        fragment_cart = new Fragment_cart();
        fragment_user = new Fragment_user();



    }

    @OnClick(R.id.radiogroup_main)
    public void onViewClicked() {
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        switch (checkedId){
            case R.id.button_home_main:
                beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.replace(R.id.frag_container,fragment_home);
                beginTransaction.commit();
                break;
            case R.id.button_class_main:
                beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.replace(R.id.frag_container,fragment_class);
                beginTransaction.commit();
                break;
            case R.id.button_cart_main:
                beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.replace(R.id.frag_container,fragment_cart);
                beginTransaction.commit();
                break;
            case R.id.button_user_main:
                //获取数据
                Object shared = SharedPreferencesUtils.getParam(MainActivity.this, "LOGIN_CODE", "").toString();
                if(shared.equals("0")){
                    beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.replace(R.id.frag_container,fragment_user);
                    beginTransaction.commit();
                }else{
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
            default:
                break;
        }
    }
}
