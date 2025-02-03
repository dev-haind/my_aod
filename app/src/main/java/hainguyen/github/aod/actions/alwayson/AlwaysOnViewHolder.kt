package hainguyen.github.aod.actions.alwayson

import android.app.Activity
import hainguyen.github.aod.R
import hainguyen.github.aod.custom.CustomFrameLayout
import hainguyen.github.aod.custom.FingerprintView

class AlwaysOnViewHolder(activity: Activity) {
    @JvmField
    val frame: CustomFrameLayout = activity.findViewById(R.id.frame)

    @JvmField
    val customView: AlwaysOnCustomView = activity.findViewById(R.id.customView)

    @JvmField
    val fingerprintIcn: FingerprintView = activity.findViewById(R.id.fingerprintIcn)
}
