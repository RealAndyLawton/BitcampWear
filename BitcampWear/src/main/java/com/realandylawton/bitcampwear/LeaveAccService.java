package com.realandylawton.bitcampwear;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class LeaveAccService extends IntentService {

    private static final String ACTION_LEAVE = "com.realandylawton.bitcampwear.action.leave_acc";

    public static Intent createLeaveAccIntent(Context context) {
        Intent intent = new Intent(context, LeaveAccService.class);
        intent.setAction(ACTION_LEAVE);
        return intent;
    }

    public LeaveAccService() {
        super("LeaveAccService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
                if(ACTION_LEAVE.equals(action)) {
                    Toast.makeText(getApplicationContext(), "Leaving ACC...", Toast.LENGTH_LONG);
            }
        }
    }
}
