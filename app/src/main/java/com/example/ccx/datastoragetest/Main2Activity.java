package com.example.ccx.datastoragetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ccx.bean.Weight;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.ccx.datastoragetest.BaseApplication.dataStorage;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    Weight w3 = new Weight();
    Weight w4 = new Weight();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        bindviews();
        Hawk.init(this)
                .build();
    }

    private void bindviews() {
        w3.setBarcodesx("3");
        w4.setBarcodesx("4");
    }

    @OnClick(R.id.bt_save)
    public void save() {
        LinkedList<Weight> wl = new LinkedList<>();
        wl.add(w3);
        wl.add(w4);
        Hawk.put("hawkwl", wl);
        dataStorage.deleteAll(Weight.class);
        dataStorage.storeOrUpdate(wl, "datawl");
    }

    @OnClick(R.id.bt_read)
    public void read() {

        Object object;
        LinkedList<Weight> rwlh = null;
        object = Hawk.get("hawkwl");
        if (object != null) {
            rwlh = new LinkedList<>((ArrayList) object);
        }
        LinkedList<Weight> rwld = new LinkedList<>(dataStorage.load(LinkedList.class, "datawl"));

        tv1.setText("");
        if (rwlh != null) {
            for (Weight w : rwlh) {
                tv1.append(w.toString());
                Log.i("hawkwl", w.toString());
            }
        }

        tv2.setText("");
        for (Weight w : rwld) {
            tv2.append(w.toString());
            Log.i("datawl", w.toString());
        }
        //tv_1.setText(Hawk.get("hawkwl").getClass().getName());
    }
}
