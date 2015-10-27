package com.bugchain.saverstorestate.tools;

import android.app.ProgressDialog;
import android.content.Context;

public class MyProgressDialog {

    private ProgressDialog dialog;

    public MyProgressDialog(Context context){
        dialog = new ProgressDialog(context);

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setMessage("Please wait ...");
    }

    public void setMessage(String message){
        dialog.setMessage(message);
    }

    public void show(){
        dialog.show();
    }

    public void dismiss(){
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
