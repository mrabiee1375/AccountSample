package com.example.accountsample.Utilities;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.accountsample.R;

import java.util.List;

public class Utility {
    public static void oprnCustomToast(List<String> list, Context dialogContext) {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(dialogContext);
        dialogBuilder.setView(R.layout.custom_alert);
        final AlertDialog dialog=dialogBuilder.create();
        dialog.show();

        ListView listView = (ListView) dialog.findViewById(R.id.message_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(dialogContext, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        Button dialogOk = (Button) dialog.findViewById(R.id.dialog_ok);
        dialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height=list.size()*100;
        if(list.size()*100>500)
        {
            params.height=500;
        }
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
