package com.example.ccx.datastoragetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ccx.bean.Weight;
import com.example.ccx.util.MyQueue;
import com.example.ccx.util.MyStack;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.LinkedList;

import xiaofei.library.datastorage.DataStorageFactory;
import static com.example.ccx.datastoragetest.BaseApplication.dataStorage;

public class MainActivity extends AppCompatActivity {
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private LinkedList<Weight> wl = null;
    private MyQueue<Weight> myQueue;
    private MyStack<Weight> myStack;
    Weight w1 = new Weight();
    Weight w2 = new Weight();
    Weight w3 = new Weight();
    Weight w4 = new Weight();
    Weight w5 = new Weight();
    Weight w6 = new Weight();
    Weight w7 = new Weight();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myQueue = new MyQueue<>();
        myStack = new MyStack<>();
        bindviews();
        Hawk.init(this)
                .build();
        dataStorage = DataStorageFactory.getInstance(
                getApplicationContext(),
                DataStorageFactory.TYPE_DATABASE);
    }

    private void bindviews(){
        tv_1 =  findViewById(R.id.tv_1);
        tv_2 =  findViewById(R.id.tv_2);
        tv_3 =  findViewById(R.id.tv_3);
        tv_4 =  findViewById(R.id.tv_4);
        w1.setBarcodesx("1");
        w2.setBarcodesx("2");
        w3.setBarcodesx("3");
        w4.setBarcodesx("4");
        w5.setBarcodesx("5");
        w6.setBarcodesx("6");
        w7.setBarcodesx("7");

        wl = new LinkedList<>();//weightlist


        wl.add(w1);
        wl.add(w2);
        wl.add(w3);
        wl.add(w4);
        wl.add(w5);
        wl.add(w6);
        wl.add(w7);

        myQueue.push(w1);
        myQueue.push(w2);
        myQueue.push(w3);
        myQueue.push(w4);
        myQueue.push(w5);
        myQueue.push(w6);
        myQueue.push(w7);

        myStack.push(w1);
        myStack.push(w2);
        myStack.push(w3);
        myStack.push(w4);
        myStack.push(w5);
        myStack.push(w6);
        myStack.push(w7);
    }

    public void next(View view){
        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }

    public void save(View view){
        Hawk.put("hawkwl",wl);
        dataStorage.storeOrUpdate(wl,"dwl");
        dataStorage.storeOrUpdate(myQueue,"ndel");
        dataStorage.storeOrUpdate(myStack,"ndel");
    }

    public void read(View view){

        Object object;
        LinkedList<Weight> rwlh = null;
        object = Hawk.get("hawkwl");
        if(object != null){
            rwlh = new LinkedList<>((ArrayList)object);
        }

        LinkedList<Weight> rwld = new LinkedList<>(dataStorage.load(LinkedList.class,"dwl"));

        //myQueue = dataStorage.load(MyQueue.class,"ndel");

        tv_1.setText("");
        if(rwlh != null){
            for(Weight w:rwlh){
                tv_1.append(w.toString());
            }
        }

        tv_2.setText("");
        for(Weight w:rwld){
            tv_2.append(w.toString());
        }

        tv_3.setText("");
        while (!(dataStorage.load(MyQueue.class,"ndel")).isEmpity()){
            Weight weight = (Weight) (dataStorage.load(MyQueue.class,"ndel")).pop();
            tv_3.append(weight.toString());
        }
        dataStorage.load(MyQueue.class,"ndel").push(w5);

        tv_4.setText("");
        while (!(dataStorage.load(MyStack.class,"ndel")).isEmpity()){
            Weight weight = (Weight) (dataStorage.load(MyStack.class,"ndel")).pop();
            tv_4.append(weight.toString());
        }
        dataStorage.load(MyStack.class,"ndel").push(w5);
        Log.i("ssss--->","sdlsdlfsldfjsldfjlj");
        /*tv_3.setText("");
        while (!myQueue.isEmpity()){
            tv_3.append(myQueue.pop().toString());
        }
        myQueue.push(w7);
        dataStorage.storeOrUpdate(myQueue,"ndel");*/
        //tv_1.setText(Hawk.get("hawkwl").getClass().getName());
    }

}
