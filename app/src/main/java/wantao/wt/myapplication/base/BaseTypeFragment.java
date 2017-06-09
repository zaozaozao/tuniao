package wantao.wt.myapplication.base;


import android.support.v4.app.Fragment;
import android.view.View;

import wantao.wt.myapplication.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * 该fragment 用于提取小件,及时，货递的共同方法
 */
public abstract class BaseTypeFragment extends BaseFragment implements View.OnClickListener {


    public BaseTypeFragment() {
        // Required empty public constructor
    }

    public abstract void getData(String price);

    @Override
    public void onClick(View v) {

    }
}
