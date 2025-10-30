package com.alcineo.bonappetit.ui.transaction;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.model.TransactionFullDataDto;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TransactionFragmentDirections {
  private TransactionFragmentDirections() {
  }

  @NonNull
  public static ActionTransactionToReceipt actionTransactionToReceipt(
      @NonNull TransactionFullDataDto transactionFullDataDto) {
    return new ActionTransactionToReceipt(transactionFullDataDto);
  }

  @NonNull
  public static NavDirections actionTransactionToPinpad() {
    return new ActionOnlyNavDirections(R.id.action_transaction_to_pinpad);
  }

  public static class ActionTransactionToReceipt implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionTransactionToReceipt(@NonNull TransactionFullDataDto transactionFullDataDto) {
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transactionFullDataDto", transactionFullDataDto);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTransactionToReceipt setTransactionFullDataDto(
        @NonNull TransactionFullDataDto transactionFullDataDto) {
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transactionFullDataDto", transactionFullDataDto);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("transactionFullDataDto")) {
        TransactionFullDataDto transactionFullDataDto = (TransactionFullDataDto) arguments.get("transactionFullDataDto");
        if (Parcelable.class.isAssignableFrom(TransactionFullDataDto.class) || transactionFullDataDto == null) {
          __result.putParcelable("transactionFullDataDto", Parcelable.class.cast(transactionFullDataDto));
        } else if (Serializable.class.isAssignableFrom(TransactionFullDataDto.class)) {
          __result.putSerializable("transactionFullDataDto", Serializable.class.cast(transactionFullDataDto));
        } else {
          throw new UnsupportedOperationException(TransactionFullDataDto.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_transaction_to_receipt;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public TransactionFullDataDto getTransactionFullDataDto() {
      return (TransactionFullDataDto) arguments.get("transactionFullDataDto");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionTransactionToReceipt that = (ActionTransactionToReceipt) object;
      if (arguments.containsKey("transactionFullDataDto") != that.arguments.containsKey("transactionFullDataDto")) {
        return false;
      }
      if (getTransactionFullDataDto() != null ? !getTransactionFullDataDto().equals(that.getTransactionFullDataDto()) : that.getTransactionFullDataDto() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getTransactionFullDataDto() != null ? getTransactionFullDataDto().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionTransactionToReceipt(actionId=" + getActionId() + "){"
          + "transactionFullDataDto=" + getTransactionFullDataDto()
          + "}";
    }
  }
}
