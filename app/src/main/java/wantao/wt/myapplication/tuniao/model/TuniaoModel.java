package wantao.wt.myapplication.tuniao.model;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.tuniao.presenter.TuniaoPresenter;

/**
 * Created by wantao on 2017/5/31.
 */

public class TuniaoModel {
    TuniaoPresenter presenter;

    public TuniaoModel(TuniaoPresenter presenter) {
        this.presenter = presenter;
    }

    public void getSmallTitles() {
        if (true) {
            List<String> titles = new ArrayList<>();
            titles.add("小件速递");
            titles.add("零担专线");
            titles.add("同城货运");
            titles.add("货运整车");

            presenter.getBigTitleSuccess(titles);
        } else {
            presenter.getTitleFail();
        }
        presenter.loadCompete();
    }

    public void getSmallTitles(int id) {
        if (true) {
            List<String> titles = new ArrayList<>();
            if (id == 0) {
                titles.add("及时送" );
            } else if (id == 1) {
                titles.add("零担专线");
            } else if (id == 2) {
                titles.add("小面包");
                titles.add("大面包");
                titles.add("搬家专车");
                titles.add("同城零单");
                titles.add("家具专车");
                titles.add("三轮车");
            } else {
                titles.add("箱式");
                titles.add("平板");
                titles.add("高栏");
                titles.add("冷藏");
                titles.add("中栏");
                titles.add("低栏");
            }
            presenter.getSmallTitleSuccess(titles);
        } else {
            presenter.getTitleFail();
        }
        presenter.loadCompete();
    }


}
