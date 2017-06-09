package wantao.wt.myapplication.http.request;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.bean.CarType;
import wantao.wt.myapplication.http.BaseCallModel;
import wantao.wt.myapplication.http.BaseInfo;

/**
 * Created by wantao on 2017/5/18.
 */

public interface CallService {

    /**
     *
     * @param cityCode
     * @return
     *  根据cityCode获取城市车型
     */
    @GET("city/city_car_infoall_new")
    Call<BaseCallModel<CarType>> getCarType(@QueryMap Map<String,String> basePrams, @Query("city_code")int cityCode);


    /**
     *
     * @param cityCode
     * @return
     *  根据cityCode获取城市车型
     */
    @GET("city/city_car_infoall_new")
    Call<BaseCallModel<CarType>> testEncryption(@QueryMap Map<String,String> basePrams, @Query("city_code")int cityCode);
    /**
     *
     * @param type 1 是发货地址 2是收货地址
     * @return
     */
    @FormUrlEncoded
    @POST("user/list_address")
    Call<BaseCallModel<AddressBean>> getAddressList(@FieldMap Map<String,String> basePrams, @Field("type") String type);

    /**
     * @param basePrams
     * @param params
     * @return
     */

    @FormUrlEncoded
    @POST("user/address")
    Call<BaseCallModel<BaseInfo>> addAddressMap(@FieldMap Map<String,String> basePrams, @FieldMap Map<String ,String> params);

    @FormUrlEncoded
    @POST("user/del_address")
    Call<BaseCallModel<BaseInfo>>  deleteAddress(@FieldMap Map<String,String> basePrams, @Field("id") String id );

    @Multipart
    @POST("Identify/personSendIdentify")
    Call<BaseCallModel<BaseInfo>>  commitID(@PartMap Map<String, RequestBody> baseParams,@PartMap Map<String, RequestBody> params,
                                            @Part List<MultipartBody.Part> parts);



}
