package wantao.wt.myapplication.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wantao.wt.myapplication.interfaced.CustomListClickListener;

/**
 * Created by wantao on 2017/5/19.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    private CustomListClickListener customItemClickListener;
    protected  List<T> mData;
    public BaseRecyclerAdapter(List<T> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),getItemLayoutId(viewType),parent,false);
        BaseRecyclerHolder holder=new BaseRecyclerHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseRecyclerHolder baseHolder= (BaseRecyclerHolder) holder;
        baseHolder.itemView.setOnClickListener(getClickListener(baseHolder.itemView,position));
        baseHolder.binding.setVariable(getVariableId(getItemViewType(position)), mData.get(position));
        baseHolder.binding.executePendingBindings();

        bindingViewClick(baseHolder.binding,position);//设置item回调


    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    private View.OnClickListener getClickListener(final View view, final int pos){

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( null != customItemClickListener) {
                    customItemClickListener.onItemClick(view, pos);
                }
            }
        };
    }

    public void setCustomItemClickListener(CustomListClickListener customItemClickListener) {
        this.customItemClickListener = customItemClickListener;
    }

    abstract public int getItemLayoutId(int viewType);
    abstract public int getVariableId(int viewType);

    /**
     * item中的按钮点击
     * @param binding
     * @param position
     */
    abstract public void bindingViewClick(ViewDataBinding binding,int position);



    class BaseRecyclerHolder extends RecyclerView.ViewHolder
    {

        public ViewDataBinding binding;
        public BaseRecyclerHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
