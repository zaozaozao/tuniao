package wantao.wt.myapplication.tuniao.paidanui;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import wantao.wt.myapplication.base.BaseTypeFragment;
import wantao.wt.myapplication.ui.CategoryGoodsActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.databinding.FragmentJiShiDaBinding;
import wantao.wt.myapplication.tuniao.TuniaoHelpActivity;
import wantao.wt.myapplication.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongChenFragment extends BaseTypeFragment {


    FragmentJiShiDaBinding mBinding;
    TuniaoHelpActivity mActivity;
    String title;
    public TongChenFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_ji_shi_da;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (FragmentJiShiDaBinding) binding;
        mActivity= (TuniaoHelpActivity) activity;
        mBinding.tvPinglei.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId()==mBinding.tvPinglei.getId())
        {
            title=mActivity.responseJiShiDaData();
            Intent intent=new Intent(activity, CategoryGoodsActivity.class);
            intent.putExtra(Constants.BASETYPE, Constants.JISHIDA_FRAMENT_QEQUEST);
            startActivityForResult(intent,0);
        }
    }

    /**
     * startActivityForResult返回的数据
     * @param price
     */
    @Override
    public void getData(String price) {
        mBinding.tvYufei.setText(price);
        Snackbar.make(mBinding.tvPinglei,title+"的价格为"+price,Snackbar.LENGTH_SHORT).show();
    }

}
