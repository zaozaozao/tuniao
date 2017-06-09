package wantao.wt.myapplication.personcertification;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.databinding.FragmentStepTwoPcBinding;
import wantao.wt.myapplication.fragment.BaseFragment;
import wantao.wt.myapplication.utils.ImageFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoPCFragment extends BaseFragment implements PersonalCertificationActivity.StepTwoImageListener{

    PersonalCertificationActivity mActivity;
    FragmentStepTwoPcBinding mBinding;

    File card_img_2;
    File card_img_3;
    ImageView imageView;

    public StepTwoPCFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_step_two_pc;
    }

    @Override
    public void initData() {
        super.initData();
        mActivity= (PersonalCertificationActivity) activity;
        mActivity.setTwoImageListener(this);

        mBinding= (FragmentStepTwoPcBinding) binding;
        mBinding.setStepTwoPCFragment(this);
    }

    @Override
    public void initView() {
        super.initView();
        registerForContextMenu(mBinding.ivCardImg2);
        registerForContextMenu(mBinding.ivCardImg3);
    }

    public void isValidate2(View view)
    {
        mActivity.isValidate2(mBinding.ivAgreeFlag.isChecked(),card_img_2,card_img_3);
    }


    @Override
    public void getBitmapPath(String path) {
        Bitmap bitmap= ImageFactory.getSmallBitmap(path);
        imageView.setImageBitmap(bitmap);

        if (imageView.getId()==R.id.iv_card_img_2)
        {
            card_img_2=new File(path);
        }else if (imageView.getId()==R.id.iv_card_img_3)
        {
            card_img_3=new File(path);
        }

    }
    public void getIdImage(View view)
    {
        view.showContextMenu();
        imageView= (ImageView) view;
    }

}
