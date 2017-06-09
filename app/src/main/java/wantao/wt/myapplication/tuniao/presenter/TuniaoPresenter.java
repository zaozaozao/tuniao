package wantao.wt.myapplication.tuniao.presenter;

import java.util.List;

import wantao.wt.myapplication.tuniao.model.TuniaoModel;
import wantao.wt.myapplication.tuniao.view.IViewModel;

/**
 * Created by wantao on 2017/5/31.
 */

public class TuniaoPresenter {
    IViewModel view;
    TuniaoModel model;

    public TuniaoPresenter(IViewModel view) {
        this.view = view;
        model=new TuniaoModel(this);
    }
    public void getBigTitle()
    {
        model.getSmallTitles();
    }

    public void getBigTitleSuccess(List<String > titles)
    {
        view.loadBigTitleSuccess(titles);
    }
    public void getTitleFail()
    {
        view.loadFail();
    }

    public void getSmallTitle(int id)
    {
        model.getSmallTitles(id);
    }
    public void getSmallTitleSuccess(List<String> titles)
    {
        view.loadSmallTitleSuccess(titles);
    }

    public void loadCompete()
    {
        view.loadCompete();
    }


}
