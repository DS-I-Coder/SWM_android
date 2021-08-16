package com.duksung.studywithme.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.duksung.studywithme.R;

public class RoomInfoDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_study_room_info, null));  // 커스텀한 다이얼로그 화면 전개해서 setView.

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // dialog 테두리 투명하게
        alertDialog.setCanceledOnTouchOutside(true); // 다이얼로그 외부 영역 터치시 닫기
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); // 다이얼로그 외부영역 어두운 거 없애기

        return alertDialog;
    }

    /**
     * 대화상자가 사라질 때 특정 작업을 실행해야하는 경우 onDismiss()메서드를 구현하면 됨.
     */
}
