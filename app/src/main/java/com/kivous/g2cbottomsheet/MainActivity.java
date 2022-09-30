package com.kivous.g2cbottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBottomSheet = findViewById(R.id.btn_bottom_sheet);
        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBottomSheetFragment();
            }
        });

    }


    private void clickBottomSheetFragment() {
        List<HorizontalObject> list = new ArrayList<>();
        list.add(new HorizontalObject("ABC Oil","This is the main reason why you should choose this oil over anything else","₹ 23"));
        list.add(new HorizontalObject("XYZ Oil","This is the main reason why you should choose this oil over anything else","₹ 53"));
        list.add(new HorizontalObject("ASD Oil","This is the main reason why you should choose this oil over anything else","₹ 100"));
        list.add(new HorizontalObject("QWE Oil","This is the main reason why you should choose this oil over anything else","₹ 50"));
        list.add(new HorizontalObject("TestCaseTestCaseTestCase","This is the main reason why you should choose this oil over anything else","₹ 7000000000000000"));

        List<VerticalObject> list2 = new ArrayList<>();
        list2.add(new VerticalObject(0,"Air filter","Adding a Filter means that you will be in control of what it","₹ 300"));
        list2.add(new VerticalObject(0,"Air filter","Adding a Filter means that you will be in control of what it","₹ 30"));
        list2.add(new VerticalObject(0,"Air filter","Adding a Filter means that you will be in control of what it","₹ 200"));
        list2.add(new VerticalObject(0,"Air filter","Adding a Filter means that you will be in control of what it","₹ 500"));

        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(list, new IClickListener() {
            @Override
            public void clickItem(HorizontalObject itemObject) {
                Toast.makeText(MainActivity.this, itemObject.getName(), Toast.LENGTH_SHORT).show();
            }
        },list2);

        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

    }


}