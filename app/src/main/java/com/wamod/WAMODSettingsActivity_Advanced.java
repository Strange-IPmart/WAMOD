package com.wamod;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.MenuItem;

/**
 * Created by BrianValente on 3/3/16.
 */
public class WAMODSettingsActivity_Advanced extends WAMODSettings {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        utils.loadColorsBeforeSuper(this);
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new WAMODSettingsFragment()).commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        utils.loadColorsV2(this);
    }

    public static class WAMODSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle paramBundle) {
            super.onCreate(paramBundle);
            getPreferenceManager().setSharedPreferencesName("wamod");
            addPreferencesFromResource(Resources.getXml("wamodsettings_advanced"));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return true;
    }
}