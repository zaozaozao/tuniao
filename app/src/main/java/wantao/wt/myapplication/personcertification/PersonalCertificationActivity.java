package wantao.wt.myapplication.personcertification;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import wantao.wt.myapplication.base.BaseManageFragmentActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.databinding.ActivityPersonalCertificationBinding;
import wantao.wt.myapplication.personcertification.model.CertificationModel;
import wantao.wt.myapplication.personcertification.presenter.CerticifationPresenter;
import wantao.wt.myapplication.personcertification.view.IViewModel;
import wantao.wt.myapplication.utils.ImageFactory;


public class PersonalCertificationActivity extends BaseManageFragmentActivity implements IViewModel {


    StepOneImageListener oneImageListener;
    StepTwoImageListener twoImageListener;

    CerticifationPresenter presenter;

    ActivityPersonalCertificationBinding mBinding;


    private String realName;
    private String iDcard;
    private String cityCode="420502";
    private Map<String ,File> fileMap;

    private File tempFile;



    @Override
    protected int getLayoutResId() {
        return R.layout.activity_personal_certification;
    }

    @Override
    public void initData() {
        super.initData();
        setCenterTitle("个人认证");
        
        mBinding= (ActivityPersonalCertificationBinding) binding;
        presenter=new CerticifationPresenter(this);
        fileMap=new HashMap<>();

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, 1, 0, "相机");
        menu.add(Menu.NONE, 2, 0, "相册");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:// 相机
                tempFile= presenter.getImageFromCamera();
                break;
            case 2:// 相册
                presenter.getImageFromAlbum();
                break;
        }
        return true;
    }

    @Override
    public Fragment instantFragment(int currIndex) {
        switch (currIndex) {
            case 0:
                return new StepOnePCFragment();
            case 1:
                return new StepTwoPCFragment();
            default:
                return null;
        }
    }

    @Override
    public ArrayList initFragmentTag() {
        return new ArrayList<>(Arrays.asList("StepOnePCFragment", "StepTwoPCFragment"));
    }

    @Override
    public int getFragmentContainer() {
        return R.id.container;
    }

    /**
     * 点击下一步
     */
    public void nextToStep(String realName,String card,File card_img_1)
    {
        this.realName=realName;
        this.iDcard=card;
        fileMap.put("card_img_1",card_img_1);
        presenter.nextToStep(realName,card,card_img_1);
    }

    public void isValidate2(  boolean isAgree,File card_img_2,File card_img_3)
    {
        fileMap.put("card_img_2",card_img_2);
        fileMap.put("card_img_3",card_img_3);
        presenter.isValidate2(cityCode, realName, iDcard, isAgree, fileMap);
    }


    @Override
    public void wrongful(String msg) {
        Snackbar.make(mBinding.coordinatorlayout,msg,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showOtherFragment() {
        showFragment(1);
    }

    @Override
    public void certificatFail() {

    }

    @Override
    public void certificatOk() {
        Snackbar.make(mBinding.coordinatorlayout,"提交成功",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void skipActivity(Intent intent, int code) {
        startActivityForResult(intent,code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path=null;
        try {
            if (requestCode == CertificationModel.REQUEST_CODE_PICK_IMAGE) {
                if (data != null) {
                    path=ImageFactory.cancleData(data,PersonalCertificationActivity.this);
                }
            } else if (requestCode == CertificationModel.REQUEST_CODE_CAPTURE_CAMEIA) {
                if (tempFile != null)
                    path=tempFile.getAbsolutePath();

            }
        } catch (Exception e) {

        }
        if (!TextUtils.isEmpty(path))
        {
            if (oneImageListener != null)
                oneImageListener.getBitmapPath(path);
            if (twoImageListener!=null)
                twoImageListener.getBitmapPath(path);
        }
    }

    public void setOneImageListener(StepOneImageListener oneImageListener) {
        this.oneImageListener = oneImageListener;
    }

    public void setTwoImageListener(StepTwoImageListener twoImageListener) {
        this.twoImageListener = twoImageListener;
    }

    public interface StepOneImageListener
    {
        void getBitmapPath(String path);
    }
    public interface StepTwoImageListener
    {
        void getBitmapPath(String path);
    }
}
