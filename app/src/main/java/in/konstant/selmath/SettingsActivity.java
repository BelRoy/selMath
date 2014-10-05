package in.konstant.selmath;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.util.Log;

public class SettingsActivity extends PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TAG = "Settings";
    private static final boolean DBG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
            initSummary(getPreferenceScreen().getPreference(i));
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePreference(findPreference(key));
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    private void initFilter(Preference preference) {
        if (preference instanceof EditTextPreference) {
            if (preference.getKey().equals("pref_retries")) {
                preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        try {
                            int val = Integer.parseInt(newValue.toString());

                            if (val >= 1 && val <= 5)
                                return true;
                            else
                                return false;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                });
            } else
            if (preference.getKey().equals("pref_problems")) {
                preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        try {
                            int val = Integer.parseInt(newValue.toString());

                            if (val >= 5 && val <= 100)
                                return true;
                            else
                                return false;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                });
            }
        }
    }

    private void initSummary(Preference preference) {
        if (preference instanceof PreferenceCategory) {
            PreferenceCategory category = (PreferenceCategory) preference;
            for (int i = 0; i < category.getPreferenceCount(); ++i) {
                initSummary(category.getPreference(i));
                initFilter(category.getPreference(i));
            }
        } else {
            updatePreference(preference);
        }
    }

    private void updatePreference(Preference preference) {
        if (preference instanceof EditTextPreference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            preference.setSummary(editTextPreference.getText());
        }
    }

}
