package com.realandylawton.bitcampwear;

import android.test.InstrumentationTestCase;
import com.realandylawton.bitcampwear.util.NotificationUtil;

/**
 * Created by realandylawton on 4/4/14.
 */
public class NotificationTestDriver extends InstrumentationTestCase {


    public void testCreateSimpleNotification() {

        NotificationUtil.createSimpleNotification(getInstrumentation().getContext(),
            "Bitcamp Rocks", "Gary Williams Lives!");

    }

}
