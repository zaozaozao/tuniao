package wantao.wt.myapplication.tuniao;

import android.os.Bundle;
import android.view.View;

import com.amap.api.maps.TextureMapView;

import wantao.wt.myapplication.base.BaseManageFragmentActivity;
import wantao.wt.myapplication.R;

/**
 * 该activity用来管理map
 */
public abstract class MapActivity extends BaseManageFragmentActivity {

    TextureMapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapView= (TextureMapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
    }

    public void showMap(int position)
    {
        if (position==1||position==3)
        {
            mapView.setVisibility(View.GONE);
        }else
        {
            mapView.setVisibility(View.VISIBLE);
        }
    }

}
