package com.example.ccx.datastoragetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ccx.bean.Weight;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.ccx.datastoragetest.BaseApplication.dataStorage;

public class Main2Activity extends AppCompatActivity {
    private TextView tv_1;
    private TextView tv_2;
    private LinkedList<Weight> wl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bindviews();
        Hawk.init(this)
                .build();
    }

    private void bindviews(){
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
    }

    public void save(View view){
        LinkedList<Weight> wl = new LinkedList<>();
        Hawk.put("hawkwl",wl);
        dataStorage.deleteAll(Weight.class);
        dataStorage.storeOrUpdate(wl);
    }

    public void read(View view){

        Object object;
        LinkedList<Weight> rwlh = null;
        object = Hawk.get("hawkwl");
        if(object != null){
            rwlh = new LinkedList<>((ArrayList)object);
        }
        LinkedList<Weight> rwld = new LinkedList<>(dataStorage.loadAll(Weight.class));

        tv_1.setText("");
        if(rwlh != null){
            for(Weight w:rwlh){
                tv_1.append(w.toString());
                Log.i("hawkwl",w.toString());
            }
        }

        tv_2.setText("");
        for(Weight w:rwld){
            tv_2.append(w.toString());
            Log.i("datawl",w.toString());
        }
        //tv_1.setText(Hawk.get("hawkwl").getClass().getName());
    }
}
