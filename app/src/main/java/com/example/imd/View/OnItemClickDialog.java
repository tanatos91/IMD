package com.example.imd.View;

import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;

public class OnItemClickDialog extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";
    private int itemPosition;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle("")
                .setPositiveButton("Edit", this)
                .setNegativeButton("Remove", this)
                .setNeutralButton("Cancel", this)
                .setMessage("What to do?");
        return adb.create();
    }

    public void onClick(DialogInterface dialog, int which) {

        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                //i = R.string.yes;
                break;
            case Dialog.BUTTON_NEGATIVE:
                // if(this.getActivity() instanceof FuelLogActivity)this.getActivity().removePosition(itemPosition);
                break;
            case Dialog.BUTTON_NEUTRAL:
                //i = R.string.maybe;
                break;
        }

    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 2: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 2: onCancel");
    }
}