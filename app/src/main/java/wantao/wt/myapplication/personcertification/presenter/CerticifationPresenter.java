package wantao.wt.myapplication.personcertification.presenter;

import android.content.Intent;
import android.graphics.Bitmap;

import java.io.File;
import java.util.List;
import java.util.Map;

import wantao.wt.myapplication.databinding.FragmentStepOnePcBinding;
import wantao.wt.myapplication.personcertification.model.CertificationModel;
import wantao.wt.myapplication.personcertification.view.IViewModel;

/**
 * Created by wantao on 2017/5/23.
 */

public class CerticifationPresenter {
    CertificationModel model;
    IViewModel view;

    public CerticifationPresenter(IViewModel view) {
        model=new CertificationModel(this);
        this.view=view;
    }

    public void nextToStep(String realName,String etCart,File card_img_1)
    {
        model.isValidate(realName, etCart, card_img_1);
    }


    public void wrongful(String msg)
    {
        view.wrongful(msg);
    }

    public void showOtherFragment()
    {
        view.showOtherFragment();
    }


    public void commitCertification(String city_code,String realName,String etCart,Map<String,File> fileMap)
    {
        model.commitCertification(city_code,realName,etCart,fileMap);
    }

    public void isValidate2(String city_code,String realName,String etCart,boolean isAgree,Map<String,File> fileMap)
    {
        model.isValidate2(city_code,realName,etCart,isAgree,fileMap);
    }

    public void certificatFail()
    {
        view.certificatFail();
    }
    public void certificatOk()
    {
        view.certificatOk();
    }

    public File getImageFromCamera()
    {
        return model.getImageFromCamera();
    }
    public void getImageFromAlbum()
    {
        model.getImageFromAlbum();
    }

    public void skipActivity(Intent intent,int code)
    {
        view.skipActivity(intent,code);
    }





}
