package com.developmentsettings;
import com.developmentsettings.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.RemoteViews;


public class DevSettingsWidgetProvider extends AppWidgetProvider 
{
	
	@Override
	public void onEnabled (Context context)
	{
		super.onEnabled(context);
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		final int N = appWidgetIds.length;
		
        // Perform this loop procedure for each App Widget that belongs to this provider
		for (int i = 0; i < N; i++)
		{
			int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch Development Settings
			Intent intent = new Intent("com.android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dev_settings_widget_layout);
            views.setOnClickPendingIntent(R.id.dev_settings_widget_view, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}
}
