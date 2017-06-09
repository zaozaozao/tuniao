package wantao.wt.myapplication.personcertification.view;

import android.content.Intent;

/**
 * Created by wantao on 2017/5/23.
 */

public interface IViewModel {

    void wrongful(String msg);
    void showOtherFragment();

    void certificatFail();
    void certificatOk();

    void skipActivity(Intent intent, int code);
}
