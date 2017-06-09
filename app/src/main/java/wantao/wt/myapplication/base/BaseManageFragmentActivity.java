package wantao.wt.myapplication.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * 该activity的作用在于管理fragment，切换，隐藏
 */
public abstract class BaseManageFragmentActivity extends BaseActivity {

    private static final String FRAGMENT_TAGS = "fragmentTags";
    private static final String CURR_INDEX = "currIndex";
    public int currIndex = 0; //不同界面的下标
    ArrayList<String> fragmentTags; //不同界面的tag

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            initPaiDan();
        } else {
            initFromSavedInstantsState(savedInstanceState);
        }
        showFragment(currIndex);
    }


    private void initPaiDan() {
        currIndex = 0;
        fragmentTags=initFragmentTag();
    }

    /**
     * 防止后台运行导致数据丢失
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURR_INDEX, currIndex);
        outState.putStringArrayList(FRAGMENT_TAGS, fragmentTags);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        initFromSavedInstantsState(savedInstanceState);
    }

    private void initFromSavedInstantsState(Bundle savedInstanceState) {
        currIndex = savedInstanceState.getInt(CURR_INDEX);
        fragmentTags = savedInstanceState.getStringArrayList(FRAGMENT_TAGS);
        showFragment(currIndex);
    }


    /**
     * 显示fragment
     */
    public void showFragment(int position) {
        currIndex = position;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = getCurrentFragment();
        if (fragment == null) {
            fragment = instantFragment(currIndex);
        }
        for (int i = 0; i < fragmentTags.size(); i++) {
            if (i == currIndex) continue;
            Fragment f = fragmentManager.findFragmentByTag(fragmentTags.get(i));
            if (f != null && f.isAdded()) {
                fragmentTransaction.hide(f);
            }
        }
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(getFragmentContainer(), fragment, fragmentTags.get(currIndex));
        }
        fragmentTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }
    public Fragment getCurrentFragment()
    {
        return  getSupportFragmentManager().findFragmentByTag(fragmentTags.get(currIndex));
    }


    public  abstract Fragment instantFragment(int currIndex);
    public  abstract ArrayList initFragmentTag();
    public  abstract int getFragmentContainer();

}
