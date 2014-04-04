package com.realandylawton.bitcampwear.activity;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.realandylawton.bitcampwear.R;
import com.realandylawton.bitcampwear.util.NotificationUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_simple) public void onSimpleClick() {
        NotificationUtil.createSimpleNotification(this, "Bitcamp Rocks", "Gary Williams 4 Lyfe");
    }

    @OnClick(R.id.btn_page) public void onEmailClick() {
        NotificationUtil.createdPagedNotification(this);
    }

    @OnClick(R.id.btn_remote_input) public void onRemoteClick() {
        NotificationUtil.createRemoteInputNotification(this);
    }

}
