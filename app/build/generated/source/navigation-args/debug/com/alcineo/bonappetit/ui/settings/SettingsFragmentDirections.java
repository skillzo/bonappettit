package com.alcineo.bonappetit.ui.settings;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.alcineo.bonappetit.R;

public class SettingsFragmentDirections {
  private SettingsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSettingsToShopping() {
    return new ActionOnlyNavDirections(R.id.action_settings_to_shopping);
  }
}
