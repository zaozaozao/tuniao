package wantao.wt.myapplication.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.base.BaseActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.SearchAddressAdapter;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.bean.builder.MsgBeanBuilder;
import wantao.wt.myapplication.databinding.ActivitySearchAddressBinding;
import wantao.wt.myapplication.utils.Constants;

/**
 * 对于简单的界面，就用一般的模式开发
 */
public class SearchAddressActivity extends BaseActivity implements TextWatcher, PoiSearch.OnPoiSearchListener, AdapterView.OnItemClickListener {


    ActivitySearchAddressBinding mbinding;


    private PoiSearch.Query query;// Poi查询条件类
    private PoiSearch poiSearch;// POI搜索


    List<AddressBean.MsgBean> list;
    SearchAddressAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search_address;
    }

    @Override
    public void initData() {
        super.initData();
        mbinding = (ActivitySearchAddressBinding) binding;
        list = new ArrayList<>();
        adapter = new SearchAddressAdapter(this, list);
    }

    @Override
    public void initView() {
        super.initView();
        setCenterTitle("选取位置");
        mbinding.searchEt.addTextChangedListener(this);
        mbinding.listview.setOnItemClickListener(this);
        mbinding.listview.setAdapter(adapter);


    }

    private void doSerach(CharSequence s) {
        query = new PoiSearch.Query(s.toString(), "", "宜昌");// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(20);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);// 设置查第一页
        query.setCityLimit(true);

        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        showLoading();
        doSerach(s);
    }

    private void showLoading() {
        mbinding.loading.setVisibility(View.VISIBLE);
        mbinding.listview.setVisibility(View.GONE);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onPoiSearched(PoiResult result, int rCode) {
        if (rCode == 1000) {
            if (result != null && result.getQuery() != null) {// 搜索poi的结果
                if (result.getQuery().equals(query)) {// 是否是同一条
                    ArrayList<PoiItem> poiItems = result.getPois();  // 取得第一页的poiitem数据，页数从数字0开始
                    if (poiItems == null || poiItems.size() == 0) {
                        Snackbar.make(mbinding.listview, "对不起，没有搜索到相关商圈喔！", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    list.clear();
                    for (int i = 0; i < poiItems.size(); i++) {
                        PoiItem poiItem = poiItems.get(i);
                        AddressBean.MsgBean bean = new MsgBeanBuilder()
                                .setPoi(poiItem.getSnippet())
                                .setAddr1(poiItem.getAdName() + poiItem.getTitle())
                                .setAddr2("")
                                .setPhone("15872531297")
                                .createMsgBean();
                        list.add(bean);
                    }
                    adapter.notifyDataSetChanged();
                } else if (rCode == 27) {
                    Snackbar.make(mbinding.listview, "搜索失败,请检查网络连接喔！", Snackbar.LENGTH_SHORT).show();
                }
            } else if (rCode == 32) {
                Snackbar.make(mbinding.listview, "地址无效喔！",
                        Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(mbinding.listview,
                        "未知错误，请稍后重试!错误码为" + rCode, Toast.LENGTH_SHORT).show();
            }
        }
        dismissLoading();
    }

    private void dismissLoading() {
        mbinding.loading.setVisibility(View.GONE);
        mbinding.listview.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("address", list.get(position));
        setResult(Constants.SEARCHADDRESS_ACTIVITY_RESULT, intent);
        finish();
    }

}
