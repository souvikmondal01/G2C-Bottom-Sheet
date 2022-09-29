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
        List<ItemObject> list = new ArrayList<>();
        list.add(new ItemObject("Souvik"));
        list.add(new ItemObject("Mondal"));
        list.add(new ItemObject("Souvik"));
        list.add(new ItemObject("Mondal"));
        list.add(new ItemObject("Souvik"));
        list.add(new ItemObject("Mondal"));

        MyBottomSheetFragment myBottomSheetFragment = new MyBottomSheetFragment(list, new IClickListener() {
            @Override
            public void clickItem(ItemObject itemObject) {
                Toast.makeText(MainActivity.this, itemObject.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        myBottomSheetFragment.show(getSupportFragmentManager(), myBottomSheetFragment.getTag());

    }


}