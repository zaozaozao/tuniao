package wantao.wt.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.encryption.EncrypUtil;

public class TestActivity extends AppCompatActivity {


    public static final String t="wantao";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final TextView tv1= (TextView) findViewById(R.id.test1);

        tv1.setText(t);
        final String a= EncrypUtil.encryp(t);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(t+"     加密后      "+ a );
            }
        });

        final TextView tv2= (TextView) findViewById(R.id.test2);
        tv2.setText(a);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(a+"     解密后      "+ EncrypUtil.decryp(a));
            }
        });

    }

}
