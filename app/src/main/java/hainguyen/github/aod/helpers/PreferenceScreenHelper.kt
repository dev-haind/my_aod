package hainguyen.github.aod.helpers

import android.content.Intent
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

object PreferenceScreenHelper {
    fun linkPreferenceToActivity(
        fragment: PreferenceFragmentCompat,
        key: String,
        intent: Intent,
    ) {
        fragment.findPreference<Preference>(key)?.setOnPreferenceClickListener {
            fragment.startActivity(intent)
            true
        }
    }
}
