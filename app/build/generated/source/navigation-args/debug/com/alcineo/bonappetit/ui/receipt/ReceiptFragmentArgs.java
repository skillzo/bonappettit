package com.alcineo.bonappetit.ui.receipt;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.alcineo.bonappetit.model.TransactionFullDataDto;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ReceiptFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ReceiptFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ReceiptFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings({
      "unchecked",
      "deprecation"
  })
  public static ReceiptFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ReceiptFragmentArgs __result = new ReceiptFragmentArgs();
    bundle.setClassLoader(ReceiptFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("transactionFullDataDto")) {
      TransactionFullDataDto transactionFullDataDto;
      if (Parcelable.class.isAssignableFrom(TransactionFullDataDto.class) || Serializable.class.isAssignableFrom(TransactionFullDataDto.class)) {
        transactionFullDataDto = (TransactionFullDataDto) bundle.get("transactionFullDataDto");
      } else {
        throw new UnsupportedOperationException(TransactionFullDataDto.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("transactionFullDataDto", transactionFullDataDto);
    } else {
      throw new IllegalArgumentException("Required argument \"transactionFullDataDto\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ReceiptFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ReceiptFragmentArgs __result = new ReceiptFragmentArgs();
    if (savedStateHandle.contains("transactionFullDataDto")) {
      TransactionFullDataDto transactionFullDataDto;
      transactionFullDataDto = savedStateHandle.get("transactionFullDataDto");
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("transactionFullDataDto", transactionFullDataDto);
    } else {
      throw new IllegalArgumentException("Required argument \"transactionFullDataDto\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public TransactionFullDataDto getTransactionFullDataDto() {
    return (TransactionFullDataDto) arguments.get("transactionFullDataDto");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("transactionFullDataDto")) {
      TransactionFullDataDto transactionFullDataDto = (TransactionFullDataDto) arguments.get("transactionFullDataDto");
      if (Parcelable.class.isAssignableFrom(TransactionFullDataDto.class) || transactionFullDataDto == null) {
        __result.set("transactionFullDataDto", Parcelable.class.cast(transactionFullDataDto));
      } else if (Serializable.class.isAssignableFrom(TransactionFullDataDto.class)) {
        __result.set("transactionFullDataDto", Serializable.class.cast(transactionFullDataDto));
      } else {
        throw new UnsupportedOperationException(TransactionFullDataDto.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ReceiptFragmentArgs that = (ReceiptFragmentArgs) object;
    if (arguments.containsKey("transactionFullDataDto") != that.arguments.containsKey("transactionFullDataDto")) {
      return false;
    }
    if (getTransactionFullDataDto() != null ? !getTransactionFullDataDto().equals(that.getTransactionFullDataDto()) : that.getTransactionFullDataDto() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getTransactionFullDataDto() != null ? getTransactionFullDataDto().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ReceiptFragmentArgs{"
        + "transactionFullDataDto=" + getTransactionFullDataDto()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ReceiptFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull TransactionFullDataDto transactionFullDataDto) {
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transactionFullDataDto", transactionFullDataDto);
    }

    @NonNull
    public ReceiptFragmentArgs build() {
      ReceiptFragmentArgs result = new ReceiptFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setTransactionFullDataDto(
        @NonNull TransactionFullDataDto transactionFullDataDto) {
      if (transactionFullDataDto == null) {
        throw new IllegalArgumentException("Argument \"transactionFullDataDto\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transactionFullDataDto", transactionFullDataDto);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public TransactionFullDataDto getTransactionFullDataDto() {
      return (TransactionFullDataDto) arguments.get("transactionFullDataDto");
    }
  }
}
