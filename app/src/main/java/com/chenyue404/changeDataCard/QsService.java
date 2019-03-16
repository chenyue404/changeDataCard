package com.chenyue404.changeDataCard;

import android.content.Intent;
import android.service.quicksettings.TileService;

public class QsService extends TileService {

    @Override
    public void onClick() {
        super.onClick();
        startActivityAndCollapse(new Intent(this, ChooseDialogActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
