package wantao.wt.myapplication.tuniao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.AddressAdapter;
import wantao.wt.myapplication.base.BaseTitleFragment;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.bean.builder.MsgBeanBuilder;
import wantao.wt.myapplication.fragment.BaseFragment;
import wantao.wt.myapplication.base.BaseTypeFragment;
import wantao.wt.myapplication.tuniao.paidanui.BlankFragment;
import wantao.wt.myapplication.tuniao.paidanui.HuoDiFragment;
import wantao.wt.myapplication.tuniao.paidanui.TongChenFragment;
import wantao.wt.myapplication.tuniao.paidanui.XiaoJianFragment;
import wantao.wt.myapplication.ui.SearchAddressActivity;
import wantao.wt.myapplication.utils.Constants;
import wantao.wt.myapplication.view.TimeSelector;

/**
 * 显示不同界面的ui
 * 实现不同界面的数据交换
 */
public abstract class TuniaoHelpActivity extends MapActivity implements AdapterView.OnItemClickListener,RadioGroup.OnCheckedChangeListener,Animation.AnimationListener{



    public List<BaseFragment> fragments = new ArrayList<>();//大标题的fragments
    public int currentPostion = 0; //大标题位置

    View container;  //不同ui的容器
    ListView listView;  //地址的listview
    View upDown;    //下拉按钮
    View bottomView;  //底部隐藏显示的控件;
    RadioGroup radioGroup;   //现在、预约按钮控件

    View timeView; //取货时间
    TextView tvTime;
    TimeSelector timeSelector;


    List<AddressBean.MsgBean> list;
    AddressAdapter adapter;
    int addrPostion=0;

    Animation mHiddenTimeAnim;    //时间隐藏动画
    Animation mHiddenBottomAnim;//底部隐藏动画

    TimeSelector.ResultHandler handler=new TimeSelector.ResultHandler() {
        @Override
        public void handle(String time) {
            tvTime.setText(time);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showCustomFragment(currIndex);
    }

    @Override
    public void initView() {
        super.initView();
        container = findViewById(R.id.paidanview);
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        adapter.setListView(listView);

        upDown=findViewById(R.id.iv_up_down);
        upDown.setOnClickListener(this);

        bottomView=findViewById(R.id.paidan_bottom);

        radioGroup= (RadioGroup) findViewById(R.id.rg_change);
        radioGroup.setOnCheckedChangeListener(this);
        tvTime= (TextView) findViewById(R.id.tv_qu_time);
        timeView=findViewById(R.id.lay_time);
        timeView.setOnClickListener(this);

    }

    @Override
    public void initData() {
        super.initData();
        list = new ArrayList<>();
        AddressBean.MsgBean defaultAddress = new MsgBeanBuilder().createMsgBean();
        defaultAddress.setAddr1("默认地址");
        defaultAddress.setPhone("手机号码");
        AddressBean.MsgBean address1 = new MsgBeanBuilder().createMsgBean();
        address1.setAddr1("您要送哪儿");
        address1.setPhone("手机号码");
        list.add(defaultAddress);
        list.add(address1);
        adapter=new AddressAdapter(this, list);

        mHiddenTimeAnim=AnimationUtils.loadAnimation(this,R.anim.slide_out_top);
        mHiddenTimeAnim.setAnimationListener(this);
        mHiddenBottomAnim=AnimationUtils.loadAnimation(this,R.anim.slide_out_top);
        mHiddenBottomAnim.setAnimationListener(this);

        timeSelector = new TimeSelector(this, handler);
    }

    /**
     * 返回不同界面的碎片
     *
     * @param currIndex
     * @return
     */
    @Override
    public Fragment instantFragment(int currIndex) {
        switch (currIndex) {
            case 0:
                return new TongChenFragment();
            case 1:
                return new BlankFragment();
            case 2:
                return new XiaoJianFragment();
            default:
                return new HuoDiFragment();
        }
    }

    @Override
    public ArrayList initFragmentTag() {
        return new ArrayList<>(Arrays.asList("TongChenFragment", "BlankFragment", "XiaoJianFragment", "HuoDiFragment"));
    }

    @Override
    public int getFragmentContainer() {
        return R.id.container_fragment;
    }

    /**
     * 作为桥梁，让jishidaFragment获取mapFragmet中的数据
     *
     * @return
     */
    public String responseJiShiDaData() {
        BaseTitleFragment fragment = (BaseTitleFragment) fragments.get(currentPostion);
        return fragment.getTitle();
    }


    /**
     * 在onActivityResult中获取的数据,向jishidafragment传输有两种方式
     * 1.直接根据tag,获取fragment
     * 2.设置监听。
     * 我使用的是第一种方式,简单，有点low。
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Constants.CATEGORYGOODS_ACTIVITY_RESUTL:
                BaseTypeFragment fragment = (BaseTypeFragment) getCurrentFragment();
                fragment.getData(data.getStringExtra("price"));
                break;
            case Constants.SEARCHADDRESS_ACTIVITY_RESULT:
                AddressBean.MsgBean bean= (AddressBean.MsgBean) data.getSerializableExtra("address");
                list.get(addrPostion).refreshData(bean);
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        addrPostion=position;
        Intent intent=new Intent(this, SearchAddressActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v==upDown)
        {
            if (bottomView.getVisibility()==View.VISIBLE)
            {
                bottomView.startAnimation(mHiddenBottomAnim);

            }else
            {
                bottomView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_top));
                bottomView.setVisibility(View.VISIBLE);
            }
        }else if (v==timeView)
        {
            timeSelector.show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId==R.id.tv_xianzai)
        {
            radioGroup.setBackgroundResource(R.mipmap.xianzaibg);
            listView.setBackgroundResource(R.drawable.viewstylepd);
            timeView.startAnimation(mHiddenTimeAnim);
        }else {
            radioGroup.setBackgroundResource(R.mipmap.yuyuebg);
            listView.setBackgroundResource(R.drawable.viewstylepd_left_right);
            timeView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_top));
            timeView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation==mHiddenTimeAnim)
        {
            timeView.setVisibility(View.GONE);
        }else if (animation==mHiddenBottomAnim)
        {
            bottomView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


    public void showCustomFragment(int position)
    {
        showMap(position);
        currIndex = position;
        container.setVisibility(View.VISIBLE);
        //用来测试
        if (currIndex == 1) {
            container.setVisibility(View.GONE);
            return;
        }
        showFragment(currIndex);
    }

}
