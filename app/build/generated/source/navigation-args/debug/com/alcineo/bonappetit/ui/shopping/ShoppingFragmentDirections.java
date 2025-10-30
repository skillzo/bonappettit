package com.alcineo.bonappetit.ui.shopping;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.alcineo.bonappetit.R;

public class ShoppingFragmentDirections {
  private ShoppingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionShoppingToTransaction() {
    return new ActionOnlyNavDirections(R.id.action_shopping_to_transaction);
  }

  @NonNull
  public static NavDirections actionShoppingToSettings() {
    return new ActionOnlyNavDirections(R.id.action_shopping_to_settings);
  }
}
