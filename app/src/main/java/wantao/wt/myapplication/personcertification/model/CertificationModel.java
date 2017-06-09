package wantao.wt.myapplication.personcertification.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import wantao.wt.myapplication.http.BaseCallModel;
import wantao.wt.myapplication.http.BaseInfo;
import wantao.wt.myapplication.http.ObjectCallBack;
import wantao.wt.myapplication.http.RetrofitFactory;
import wantao.wt.myapplication.personcertification.presenter.CerticifationPresenter;
import wantao.wt.myapplication.utils.SDcardUtil;

/**
 * Created by wantao on 2017/5/23.
 */

public class CertificationModel {

    CerticifationPresenter presenter;

    // 照片选取
    public final static int REQUEST_CODE_PICK_IMAGE = 1;
    public final static int REQUEST_CODE_CAPTURE_CAMEIA = 2;
    // 临时文件路径
    public static String TEMP_FILE_PATH = "/temp/";


    public CertificationModel(CerticifationPresenter presenter) {
        this.presenter = presenter;
    }


    public boolean isValidate(String realName,String etCart,File card_img_1)
    {
        if (TextUtils.isEmpty(realName)) {
            presenter.wrongful("请填写真实姓名");
            return false;
        }
        if (TextUtils.isEmpty(etCart)) {
            presenter.wrongful("请填写身份证号");
            return false;
        }
        if (card_img_1 == null) {
            presenter.wrongful("请上传手持身份证照");
            return false;
        }
        presenter.showOtherFragment();
        return true;
    }

    public boolean isValidate2(String city_code,String realName,String etCart, boolean isAgree,Map<String,File> fileMap)
    {
        if (fileMap==null||fileMap.get("card_img_2")==null) {
            presenter.wrongful("请上传身份证正面照");
            return false;
        }
        if (fileMap==null||fileMap.get("card_img_3")==null) {
            presenter.wrongful("请上传身份证反面照");
            return false;
        }
        if (!isAgree) {
            presenter.wrongful("请勾选途鸟派单协议");
            return  false;
        }
        presenter.commitCertification(city_code,realName, etCart,fileMap);
        return true;
    }

    public void commitCertification(String city_code, String realName, String etCart, Map<String, File> fileMap) {
        Call<BaseCallModel<BaseInfo>> call = RetrofitFactory.getCallService().commitID(RetrofitFactory.createBaseBody(),getRequestBodyMap(city_code, realName, etCart), RetrofitFactory.getMultipartBodyPart(fileMap));
        call.enqueue(new ObjectCallBack<BaseCallModel<BaseInfo>>() {
            @Override
            public void onSuccessed(BaseCallModel<BaseInfo> object) {
                presenter.certificatOk();
            }

            @Override
            public void onErrored(int code, Response<BaseCallModel<BaseInfo>> response) {

            }

            @Override
            public void onFailMessage(String msg) {
                super.onFailMessage(msg);
                presenter.wrongful(msg);
            }
        });
    }

    public  Map<String ,RequestBody> getRequestBodyMap(String city_code, String realName, String etCart)
    {
        Map<String ,RequestBody> map=new HashMap<>();
        map.put("city_code",RetrofitFactory.getRequestBody(city_code));
        map.put("realname",RetrofitFactory.getRequestBody(realName));
        map.put("card",RetrofitFactory.getRequestBody(etCart));
        return map;
    }


    // 照相获取图片
    public File getImageFromCamera()
    {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File tempFile = new File(SDcardUtil.getImageDir()+TEMP_FILE_PATH + System.currentTimeMillis() + ".jpg");
            Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            picIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
            presenter.skipActivity(picIntent,REQUEST_CODE_CAPTURE_CAMEIA);
            return  tempFile;
        } else {
            presenter.wrongful("请插入SD卡");
            return  null;
        }
    }

    // 从相册中获取图片
    public void getImageFromAlbum()
    {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");// 相片类型
        presenter.skipActivity(intent, REQUEST_CODE_PICK_IMAGE);
    }



}
