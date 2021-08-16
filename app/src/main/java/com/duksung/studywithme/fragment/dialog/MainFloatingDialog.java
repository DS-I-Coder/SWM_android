package com.duksung.studywithme.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.common.preferences.AppData;

public class MainFloatingDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = requireActivity().getLayoutInflater().inflate(R.layout.dialog_main_floating, null);

        TextView c = view.findViewById(R.id.tv_dailyAccTime);

        AppData data = AppData.getInstance(getContext());
        c.setText(Common.secToTimeString(data.getPREF_ACC_TIME()));


        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // dialog 테두리 투명하게
        alertDialog.setCanceledOnTouchOutside(true); // 다이얼로그 외부 영역 터치시 닫기
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); // 다이얼로그 외부영역 어두운 거 없애기

        return alertDialog;
    }

}
