package wantao.wt.myapplication.base;


import android.support.v4.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.MainActivity;
import wantao.wt.myapplication.fragment.BaseFragment;
import wantao.wt.myapplication.view.CustomTiteBar;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseTitleFragment extends BaseFragment implements CustomTiteBar.ItemClickListener{

    public List<String> smallTitles=new ArrayList<>();
    public int currentPostion=0; //当前的小标题位置
    public int id;
    public MainActivity mActivity;

    @Override
    public void initData() {
        super.initData();
        id=getArguments().getInt("id");
        mActivity= (MainActivity) activity;
    }

    @Override
    public void getListTitle(List<String> titles) {
        smallTitles.clear();
        smallTitles.addAll(titles);
        initTab(titles);
    }

    @Override
    public void itemClick(View v, int position) {
        currentPostion=position;
    }

    public abstract void initTab(List<String> titles);

    public  String getTitle()
    {
        return  smallTitles.get(currentPostion);
    }

}
