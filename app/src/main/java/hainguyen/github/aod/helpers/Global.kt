package hainguyen.github.aod.helpers

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.service.quicksettings.TileService
import androidx.preference.PreferenceManager
import hainguyen.github.aod.receivers.AlwaysOnAppWidgetProvider
import hainguyen.github.aod.services.AlwaysOnTileService

internal object Global {
    const val LOG_TAG: String = "AlwaysOn"

    const val ALWAYS_ON_STATE_CHANGED: String =
        "hainguyen.github.aod.ALWAYS_ON_STATE_CHANGED"

    fun currentAlwaysOnState(context: Context): Boolean =
        PreferenceManager
            .getDefaultSharedPreferences(context)
            .getBoolean(P.ALWAYS_ON, P.ALWAYS_ON_DEFAULT)

    fun changeAlwaysOnState(context: Context): Boolean {
        val value =
            !PreferenceManager.getDefaultSharedPreferences(context).getBoolean(P.ALWAYS_ON, P.ALWAYS_ON_DEFAULT)
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(P.ALWAYS_ON, value)
            .apply()
        TileService.requestListeningState(
            context,
            ComponentName(context, AlwaysOnTileService::class.java),
        )
        context.sendBroadcast(
            Intent(context, AlwaysOnAppWidgetProvider::class.java)
                .setAction(ALWAYS_ON_STATE_CHANGED),
        )
        return value
    }
}
