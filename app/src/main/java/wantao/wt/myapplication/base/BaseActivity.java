package wantao.wt.myapplication.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import wantao.wt.myapplication.MainActivity;
import wantao.wt.myapplication.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    public ViewDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPre();
        binding = DataBindingUtil.setContentView(this, getLayoutResId());
        initState();
        initToolBar();
        initBackBtn();
        initData();
        initView();

    }

    private void initToolBar() {
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        if (toolbar!=null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null){
                actionBar.setDisplayShowTitleEnabled(false);//隐藏默认标题
            }
        }
    }

    public void initView() {

    }

    public void initData() {
    }


    public void initPre() {

    }


    public void initBackBtn() {
        ImageView mBtnBack = (ImageView) this.findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(this);
    }

    public void setCenterTitle(String title) {
        TextView mTvTitle = (TextView) this.findViewById(R.id.tv_title);
        mTvTitle.setText(title);
    }
    public void setTitleBackground(int id)
    {
        TextView mTvTitle = (TextView) this.findViewById(R.id.tv_title);
        mTvTitle.setBackgroundResource(id);
    }

    public void setRightImg(int resouceId) {
        View rightView = findViewById(R.id.fl_right);
        rightView.setOnClickListener(this);
        rightView.setVisibility(View.VISIBLE);

        ImageView mIvImg = (ImageView) this.findViewById(R.id.btn_right);
        mIvImg.setImageResource(resouceId);
    }

    public void setLeftImg(int resouceId) {
        findViewById(R.id.fl_left).setVisibility(View.VISIBLE);

        ImageView mIvImg = (ImageView) this.findViewById(R.id.btn_back);
        mIvImg.setImageResource(resouceId);
    }

    public void initSnackeBar(String text,View container) {
        Snackbar snackbar = Snackbar.make(container,text , Snackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(ContextCompat.getColor(this,R.color.panel_black));
        snackbar.getView().setBackgroundResource(R.color.line_btn);
        snackbar.show();
    }

    /**
     * 沉浸式状态栏
     */
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.fl_right)
        {
            rightViewClick(v);

        }else if (v.getId()==R.id.btn_back)
        {
            if (this.getClass().equals(MainActivity.class))
            {
                leftViewClick(v);
            }else {
                BaseActivity.this.finish();
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
            }
        }

    }

    /**
     * 头部左侧按钮点击事件
     * @param v
     */
    public void leftViewClick(View v) {

    }

    /**
     * 头部右侧按钮点击事件
     * @param v
     */
    public void rightViewClick(View v)
    {

    }

    protected abstract int getLayoutResId();
}
