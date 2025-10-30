package com.alcineo.bonappetit;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.alcineo.bonappetit.databinding.AdapterFooditemBindingImpl;
import com.alcineo.bonappetit.databinding.FragmentReceiptBindingImpl;
import com.alcineo.bonappetit.databinding.FragmentShoppingBindingImpl;
import com.alcineo.bonappetit.databinding.FragmentTransactionBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ADAPTERFOODITEM = 1;

  private static final int LAYOUT_FRAGMENTRECEIPT = 2;

  private static final int LAYOUT_FRAGMENTSHOPPING = 3;

  private static final int LAYOUT_FRAGMENTTRANSACTION = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.alcineo.bonappetit.R.layout.adapter_fooditem, LAYOUT_ADAPTERFOODITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.alcineo.bonappetit.R.layout.fragment_receipt, LAYOUT_FRAGMENTRECEIPT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.alcineo.bonappetit.R.layout.fragment_shopping, LAYOUT_FRAGMENTSHOPPING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.alcineo.bonappetit.R.layout.fragment_transaction, LAYOUT_FRAGMENTTRANSACTION);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ADAPTERFOODITEM: {
          if ("layout/adapter_fooditem_0".equals(tag)) {
            return new AdapterFooditemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for adapter_fooditem is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRECEIPT: {
          if ("layout/fragment_receipt_0".equals(tag)) {
            return new FragmentReceiptBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_receipt is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHOPPING: {
          if ("layout/fragment_shopping_0".equals(tag)) {
            return new FragmentShoppingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shopping is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTRANSACTION: {
          if ("layout/fragment_transaction_0".equals(tag)) {
            return new FragmentTransactionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_transaction is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "foodItem");
      sKeys.put(2, "foodItemAdapter");
      sKeys.put(3, "receipt");
      sKeys.put(4, "shopping");
      sKeys.put(5, "transaction");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/adapter_fooditem_0", com.alcineo.bonappetit.R.layout.adapter_fooditem);
      sKeys.put("layout/fragment_receipt_0", com.alcineo.bonappetit.R.layout.fragment_receipt);
      sKeys.put("layout/fragment_shopping_0", com.alcineo.bonappetit.R.layout.fragment_shopping);
      sKeys.put("layout/fragment_transaction_0", com.alcineo.bonappetit.R.layout.fragment_transaction);
    }
  }
}
