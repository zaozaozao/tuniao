package wantao.wt.myapplication.http;

import android.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wantao on 2017/5/19
 * 使用databing+fresco加载图片
 */

public class BaseImageModel {

        @BindingAdapter({"imageUrl"})
        public static void loadImage(SimpleDraweeView view, String name) {
                view.setImageURI(name);
        }
}
