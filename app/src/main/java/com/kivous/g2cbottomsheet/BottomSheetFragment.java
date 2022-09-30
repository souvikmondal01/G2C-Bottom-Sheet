package com.kivous.g2cbottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private List<HorizontalObject> listItems;
    private IClickListener iClickListener;

    private List<VerticalObject> pacListItems;


    public BottomSheetFragment(List<HorizontalObject> listItems, IClickListener iClickListener, List<VerticalObject> pacListItems) {
        this.listItems = listItems;
        this.iClickListener = iClickListener;
        this.pacListItems = pacListItems;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet, null);
        bottomSheetDialog.setContentView(view);

        RecyclerView rvData = view.findViewById(R.id.rv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rvData.setLayoutManager(linearLayoutManager);

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(listItems, new IClickListener() {
            @Override
            public void clickItem(HorizontalObject itemObject) {
                iClickListener.clickItem(itemObject);
            }
        });
        rvData.setAdapter(horizontalAdapter);

//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL);
//        rvData.addItemDecoration(itemDecoration);


        RecyclerView rvPac = view.findViewById(R.id.rv_people_also_choose);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(RecyclerView.VERTICAL);
        rvPac.setLayoutManager(linearLayoutManager1);
        VerticalAdapter verticalAdapter = new VerticalAdapter(pacListItems);
        rvPac.setAdapter(verticalAdapter);


        return bottomSheetDialog;
    }
}
