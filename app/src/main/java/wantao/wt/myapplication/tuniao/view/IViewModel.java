package wantao.wt.myapplication.tuniao.view;

import java.util.List;

/**
 * Created by wantao on 2017/5/31.
 */

public interface IViewModel {

    void showLoading();
    void hideLoading();
    void loadBigTitleSuccess(List<String > titles);
    void loadSmallTitleSuccess(List<String > titles);
    void loadFail();
    void loadCompete();
}
