package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Field;

public class MakeStudyRoom extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    private static String TAG = "MakeStudyRoom";
    private ImageView img_backToMain;
    private EditText et_studyName, et_studyField,et_setStudyPassword;
    private TextView tv_cameraSetting, tv_micSetting, tv_speakerSetting;
    private TextInputEditText et_studyNotice;
    private Spinner sp_studyCategory;
    private Button btn_makeStudyRoom;
    private RadioButton radioBtn_private;
    Boolean chipState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_study_room);

        img_backToMain = findViewById(R.id.iv_back);
        btn_makeStudyRoom = findViewById(R.id.btn_makeStudyRoom);
        et_studyName = findViewById(R.id.et_studyName);
        et_studyNotice = findViewById(R.id.et_studyNotice);
        et_setStudyPassword = findViewById(R.id.et_setStudyPassword);
        tv_cameraSetting = findViewById(R.id.tv_cameraSetting);
        tv_micSetting = findViewById(R.id.tv_micSetting);
        tv_speakerSetting = findViewById(R.id.tv_speakerSetting);

        et_studyName.addTextChangedListener(this);
        et_studyNotice.addTextChangedListener(this);
        et_setStudyPassword.addTextChangedListener(this);

        btn_makeStudyRoom.setOnClickListener(this);
        img_backToMain.setOnClickListener(this);
        tv_cameraSetting.setOnClickListener(this);
        tv_micSetting.setOnClickListener(this);
        tv_speakerSetting.setOnClickListener(this);

        spinnerInit();
        radioButtonInit();

    }

    private void spinnerInit(){
        sp_studyCategory = findViewById(R.id.sp_studyCategory);
        sp_studyCategory.setDropDownVerticalOffset(Math.round(Common.dipToPixels(this, 34)));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //custom item ????????????.

        sp_studyCategory.setAdapter(adapter);

    }
    private void radioButtonInit() {
        RadioGroup radioGroup_studyAccess = findViewById(R.id.radioGroup_studyAccess);
        RadioButton radioBtn_public = findViewById(R.id.radioBtn_public);
        radioBtn_private = findViewById(R.id.radioBtn_private);

        LinearLayout layout_setRoomPassword = findViewById(R.id.layout_setRoomPassword);

        radioBtn_public.setChecked(true);  // ???????????? public??? ?????????????????? ???.

        //* RadioGroup ????????? - ???????????? ????????? ??????????????? ????????? ???????????? ???????????? ???????????? ??????????????? ??????.
        radioGroup_studyAccess.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn_public) {        //PUBLIC
                    layout_setRoomPassword.setVisibility(View.GONE); // ?????? ???????????? ?????????????????? ?????????
                    // (invisible??? ????????? ?????????, ????????? ??????????????? gone?????? ?????? ?????????)

                } else if (checkedId == R.id.radioBtn_private) {    // PRIVATE
                    layout_setRoomPassword.setVisibility(View.VISIBLE);
                    et_setStudyPassword.setText("");
                    btn_makeStudyRoom.setBackgroundResource(R.drawable.button_inactive_gray_border);
                }
            }
        });

    }

    /*--------------------------------------------------------------------
       onClick, TextWatcher ????????? ??????
     *--------------------------------------------------------------------*/

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.iv_back){             // ???????????? ??????
            //TODO ????????? ??????????????? ???, ??????????????? ????????? ?????? ????????? ???????
            finish();
        }
        else if (v.getId() == R.id.btn_makeStudyRoom){  // ?????? MAKE STUDY ROOM ??????
            //TODO ??? ?????? ????????? ?????? + ?????? ????????? ???????
        }

        else if(v.getId() == R.id.tv_cameraSetting) {
            toggleSettingChip(tv_cameraSetting);
        }
        else if(v.getId() == R.id.tv_micSetting){
            toggleSettingChip(tv_micSetting);
        }
        else if(v.getId() == R.id.tv_speakerSetting){
            toggleSettingChip(tv_speakerSetting);
        }
    }

    private void toggleSettingChip(TextView view){
        if (view.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.chip_off).getConstantState())){
            // chip??? off???????????? on??????
            view.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_on));
            view.setTextColor(ContextCompat.getColor(this, R.color.white));
            chipState = false;
        }else{
            // chip??? on???????????? off???
            view.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_off));
            view.setTextColor(ContextCompat.getColor(this, R.color.black));
            chipState = true;
        }
        Log.d(TAG, chipState+"");
    }

    private boolean isAllFilled(){  // ????????? ?????? ??????????????? ??????

        if( Common.isStringEmpty(et_studyName.getText().toString())
                //|| Common.isStringEmpty(et_studyField.getText().toString())
                || Common.isStringEmpty(et_studyNotice.getText().toString())){
            // ???????????? ??????????????? return false
            return false;
        }

        if(radioBtn_private.isChecked()) { //private ??????????????? ???????????? ??????????????? ??????
            if (Common.isStringEmpty(et_setStudyPassword.getText().toString())) {
                return false;
            }
        }
        return true;
    }

    //* editText ????????? ?????? ???
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    //* editText ????????? ?????? ???
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    //* editText ????????? ?????? ?????? ???
    @Override
    public void afterTextChanged(Editable s) {
        if(isAllFilled()){
            btn_makeStudyRoom.setEnabled(true);
            btn_makeStudyRoom.setBackgroundResource(R.drawable.button_active_darkblue_border);
        }else{
            btn_makeStudyRoom.setEnabled(false);
            btn_makeStudyRoom.setBackgroundResource(R.drawable.button_inactive_gray_border);
        }
    }
}