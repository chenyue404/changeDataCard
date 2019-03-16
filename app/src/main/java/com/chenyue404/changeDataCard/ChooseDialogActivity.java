package com.chenyue404.changeDataCard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import eu.chainfire.libsuperuser.Shell;

public class ChooseDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_01;
    private Button bt_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dialog);
        setFinishOnTouchOutside(true);
        findId();
    }

    private void findId() {
        bt_01 = (Button) findViewById(R.id.bt_01);
        bt_02 = (Button) findViewById(R.id.bt_02);

        bt_01.setOnClickListener(this);
        bt_02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_01:
                changeDataCard(1);
                break;
            case R.id.bt_02:
                changeDataCard(2);
                break;
        }
    }

    private void changeDataCard(int i) {
        if (!Shell.SU.available()) {
            Toast.makeText(this, R.string.get_root_first, Toast.LENGTH_SHORT).show();
            return;
        }
        String cmd = "service call isub 24 i32 " + i;
        Shell.SU.run(cmd);
        Toast.makeText(this, R.string.wait, Toast.LENGTH_SHORT).show();
        finish();
    }
}
