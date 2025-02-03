package hainguyen.github.aod.actions.alwayson.draw

import android.graphics.Canvas
import hainguyen.github.aod.helpers.P
import hainguyen.github.aod.services.NotificationService

object NotificationCount {
    internal fun draw(
        canvas: Canvas,
        utils: Utils,
    ) {
        utils.drawRelativeText(
            canvas,
            if (NotificationService.count != 0) NotificationService.count.toString() else "",
            utils.padding16,
            utils.padding16,
            utils.getPaint(
                utils.mediumTextSize,
                utils.prefs.get(P.DISPLAY_COLOR_NOTIFICATION, P.DISPLAY_COLOR_NOTIFICATION_DEFAULT),
            ),
        )
    }
}
