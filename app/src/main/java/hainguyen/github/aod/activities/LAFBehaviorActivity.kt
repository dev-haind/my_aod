package hainguyen.github.aod.activities

import android.content.Intent
import android.os.Bundle
import androidx.preference.SwitchPreference
import hainguyen.github.aod.R
import hainguyen.github.aod.custom.BasePreferenceFragment
import hainguyen.github.aod.helpers.P
import hainguyen.github.aod.helpers.PreferenceScreenHelper

class LAFBehaviorActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, PreferenceFragment())
            .commit()
    }

    class PreferenceFragment : BasePreferenceFragment() {
        override fun onCreatePreferences(
            savedInstanceState: Bundle?,
            rootKey: String?,
        ) {
            addPreferencesFromResource(R.xml.pref_laf_behavior)
            checkPermissions()
            PreferenceScreenHelper.linkPreferenceToActivity(
                this,
                P.FORCE_BRIGHTNESS,
                Intent(requireContext(), LAFBrightnessActivity::class.java),
            )
            if (preferenceManager.sharedPreferences?.getBoolean(P.ROOT_MODE, false) != true) {
                findPreference<SwitchPreference>(P.POWER_SAVING_MODE)?.isEnabled = false
                findPreference<SwitchPreference>(P.DISABLE_HEADS_UP_NOTIFICATIONS)
                    ?.isEnabled = false
            }
        }
    }
}
