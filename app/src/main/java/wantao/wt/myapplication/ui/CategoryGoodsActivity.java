package wantao.wt.myapplication.ui;

import android.content.Intent;
import android.view.View;

import wantao.wt.myapplication.base.BaseActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.databinding.ActivityCategoryGoodsBinding;
import wantao.wt.myapplication.utils.Constants;

public class CategoryGoodsActivity extends BaseActivity {

    ActivityCategoryGoodsBinding mBinding;
    int type;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_category_goods;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (ActivityCategoryGoodsBinding) binding;
        type=getIntent().getIntExtra(Constants.BASETYPE,0);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding.btnQr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == mBinding.btnQr.getId()) {
            Intent intent = new Intent();
            intent.putExtra("price", getPrice());
            setResult(Constants.CATEGORYGOODS_ACTIVITY_RESUTL, intent);
            finish();
        }
    }

    public String getPrice() {
        if (type==Constants.JISHIDA_FRAMENT_QEQUEST)
        {
            return "100";
        }else if (type== Constants.XIAOJIAN_FRAMENT_QEQUEST)
        {
            return "200";
        }else if (type==Constants.HUODI_FRAMENT_QEQUEST)
        {
            return "300";
        }
        return "错误";
    }
}
