package com.realandylawton.bitcampwear.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.preview.support.v4.app.NotificationManagerCompat;
import android.preview.support.wearable.notifications.RemoteInput;
import android.preview.support.wearable.notifications.WearableNotifications;
import android.support.v4.app.NotificationCompat;
import com.realandylawton.bitcampwear.LeaveAccService;
import com.realandylawton.bitcampwear.R;
import com.realandylawton.bitcampwear.activity.GaryActivity;
import com.realandylawton.bitcampwear.activity.ChampionshipActivity;
import com.realandylawton.bitcampwear.activity.MainActivity;
import com.realandylawton.bitcampwear.model.Train;
import java.util.List;

/**
 * Created by realandylawton on 4/4/14.
 */
public class NotificationUtil {

    public static void createSimpleNotification(Context context, String title, String text) {

        // Create a Pending Intent that will launch the Gary Activity
        // when a user clicks the Open Action in Wear
        Intent openIntent = new Intent(context, GaryActivity.class);
        PendingIntent openPendingIntent =
            PendingIntent.getActivity(context, 0, openIntent, 0);

        // Add an Action that will start the LeaveAccService
        Intent leaveAccIntent = LeaveAccService.createLeaveAccIntent(context);
        PendingIntent leavePendingIntent = PendingIntent.getService(context, 0, leaveAccIntent, 0);

        // Build the Notification
        NotificationCompat.Builder notificationBuilder =
            new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setContentIntent(openPendingIntent)
                .setLargeIcon(
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.gary))
                .addAction(R.drawable.ic_launcher, "Leave ACC", leavePendingIntent);


        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify((int)System.currentTimeMillis(), notificationBuilder.build());


    }

    public static void createdPagedNotification(Context context) {

        Intent viewIntent = new Intent(context, MainActivity.class);
        PendingIntent viewPendingIntent =
            PendingIntent.getActivity(context, 0, viewIntent, 0);

        NotificationCompat.Builder notificationBuilder =
            new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Choo Choo!")
                .setContentText("Swipe to see some trains.")
                .setContentIntent(viewPendingIntent);

        // Create WearableNotifications builder!
        WearableNotifications.Builder wearableNotificationsBuilder
            = new WearableNotifications.Builder(notificationBuilder);

        List<Train> trainList = Train.getTrainList(context);
        for(Train train : trainList) {

            NotificationCompat.BigTextStyle trainPageStyle = new NotificationCompat.BigTextStyle();
            trainPageStyle.setBigContentTitle(train.getDestinationName())
                .bigText(train.getLine() + " line train towards "
                    + train.getDestinationName() + " arrives in " + train.getMinutes() + " minutes.");


            Notification trainPageNotification = new NotificationCompat.Builder(context)
                .setStyle(trainPageStyle)
                .build();

            wearableNotificationsBuilder.addPage(trainPageNotification);

        }

        Notification notification = wearableNotificationsBuilder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify((int)System.currentTimeMillis(), notification);

    }

    public static void createRemoteInputNotification(Context context) {

        Intent championshipIntent = new Intent(context, ChampionshipActivity.class);
        PendingIntent replyPendingIntent =
            PendingIntent.getActivity(context, 0, championshipIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle("You've won!")
            .setContentText("How will you celebrate in College Park?")
            .setContentIntent(replyPendingIntent);

        String label = "Choose Celebration";
        String[] choices = new String[] {
            "High Five",
            "Visit Barking Dog",
            "Study",
            "Burn Couches"
        } ;

        RemoteInput remoteInput = new RemoteInput.Builder(ChampionshipActivity.EXTRA_HANDLE_CHAMPIONSHIP)
            .setLabel(label)
            .setChoices(choices)
            .build();

        Notification notification = new WearableNotifications.Builder(notificationBuilder)
            .addRemoteInputForContentIntent(remoteInput)
            .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify((int)System.currentTimeMillis(), notification);

    }
}
