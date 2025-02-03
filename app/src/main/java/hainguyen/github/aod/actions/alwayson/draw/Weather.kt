package hainguyen.github.aod.actions.alwayson.draw

import android.graphics.Canvas
import hainguyen.github.aod.helpers.P

object Weather {
    internal fun draw(
        canvas: Canvas,
        utils: Utils,
        weather: String,
    ) {
        utils.drawRelativeText(
            canvas,
            weather,
            utils.padding2,
            utils.padding2,
            utils.getPaint(
                utils.smallTextSize,
                utils.prefs.get(P.DISPLAY_COLOR_WEATHER, P.DISPLAY_COLOR_WEATHER_DEFAULT),
            ),
        )
    }
}
