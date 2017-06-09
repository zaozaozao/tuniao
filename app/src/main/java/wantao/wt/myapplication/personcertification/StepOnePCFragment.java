package wantao.wt.myapplication.personcertification;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.view.View;

import java.io.File;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.databinding.FragmentStepOnePcBinding;
import wantao.wt.myapplication.fragment.BaseFragment;
import wantao.wt.myapplication.utils.ImageFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepOnePCFragment extends BaseFragment implements PersonalCertificationActivity.StepOneImageListener {

    FragmentStepOnePcBinding mbinging;
    PersonalCertificationActivity mActivity;
    File card_img_1=null;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_step_one_pc;
    }

    @Override
    public void initData() {
        super.initData();
        mbinging= (FragmentStepOnePcBinding) binding;
        mbinging.setStepOnePCFragment(this);

        mActivity= (PersonalCertificationActivity) activity;
        mActivity.setOneImageListener(this);

    }

    @Override
    public void initView() {
        super.initView();
        registerForContextMenu(mbinging.ivCardImg1);
    }

    public void nextToStep(View v)
    {
        mActivity.nextToStep(mbinging.etRealname.getText().toString(),mbinging.etCard.getText().toString(),card_img_1);
    }

    public void getIdImage(View v)
    {
        v.showContextMenu();
    }


    @Override
    public void getBitmapPath(String path) {
        card_img_1=new File(path);
        Bitmap bitmap= ImageFactory.getSmallBitmap(path);
        mbinging.ivCardImg1.setImageBitmap(bitmap);
    }
}
