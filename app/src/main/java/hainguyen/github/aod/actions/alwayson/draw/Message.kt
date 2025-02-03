package hainguyen.github.aod.actions.alwayson.draw

import android.graphics.Canvas
import hainguyen.github.aod.helpers.P

object Message {
    internal fun draw(
        canvas: Canvas,
        utils: Utils,
    ) {
        utils.drawRelativeText(
            canvas,
            utils.prefs.get(P.MESSAGE, P.MESSAGE_DEFAULT),
            utils.padding2,
            utils.padding2,
            utils.getPaint(
                utils.smallTextSize,
                utils.prefs.get(P.DISPLAY_COLOR_MESSAGE, P.DISPLAY_COLOR_MESSAGE_DEFAULT),
            ),
        )
    }
}
