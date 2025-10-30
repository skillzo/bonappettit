package com.alcineo.bonappetit.databinding;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AdapterFooditemBindingImpl extends AdapterFooditemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.minusButton, 5);
        sViewsWithIds.put(R.id.plusButton, 6);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AdapterFooditemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private AdapterFooditemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            );
        this.itemIcon.setTag(null);
        this.itemPrice.setTag(null);
        this.itemTitle.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.quantityView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.foodItem == variableId) {
            setFoodItem((com.alcineo.bonappetit.model.FoodItem) variable);
        }
        else if (BR.foodItemAdapter == variableId) {
            setFoodItemAdapter((com.alcineo.bonappetit.ui.shopping.adapter.FoodItemAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFoodItem(@Nullable com.alcineo.bonappetit.model.FoodItem FoodItem) {
        this.mFoodItem = FoodItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.foodItem);
        super.requestRebind();
    }
    public void setFoodItemAdapter(@Nullable com.alcineo.bonappetit.ui.shopping.adapter.FoodItemAdapter FoodItemAdapter) {
        this.mFoodItemAdapter = FoodItemAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.foodItemAdapter);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.alcineo.bonappetit.model.FoodItem foodItem = mFoodItem;
        int foodItemImgRes = 0;
        java.util.Currency foodItemAdapterTransactionCurrencyGetCurrency = null;
        java.lang.String foodItemAdapterTransactionCurrencyGetCurrencyGetSymbol = null;
        java.lang.String stringValueOfFoodItemQuantity = null;
        com.neovisionaries.i18n.CurrencyCode foodItemAdapterTransactionCurrency = null;
        java.lang.String foodItemPriceFoodItemAdapterTransactionCurrencyGetCurrencyGetSymbol = null;
        java.lang.String foodItemName = null;
        java.math.BigDecimal foodItemPrice = null;
        int foodItemQuantity = 0;
        com.alcineo.bonappetit.ui.shopping.adapter.FoodItemAdapter foodItemAdapter = mFoodItemAdapter;

        if ((dirtyFlags & 0x7L) != 0) {


            if ((dirtyFlags & 0x5L) != 0) {

                    if (foodItem != null) {
                        // read foodItem.imgRes
                        foodItemImgRes = foodItem.getImgRes();
                        // read foodItem.name
                        foodItemName = foodItem.getName();
                        // read foodItem.quantity
                        foodItemQuantity = foodItem.getQuantity();
                    }


                    // read String.valueOf(foodItem.quantity)
                    stringValueOfFoodItemQuantity = java.lang.String.valueOf(foodItemQuantity);
            }

                if (foodItem != null) {
                    // read foodItem.price
                    foodItemPrice = foodItem.getPrice();
                }
                if (foodItemAdapter != null) {
                    // read foodItemAdapter.transactionCurrency
                    foodItemAdapterTransactionCurrency = foodItemAdapter.transactionCurrency;
                }


                if (foodItemAdapterTransactionCurrency != null) {
                    // read foodItemAdapter.transactionCurrency.getCurrency()
                    foodItemAdapterTransactionCurrencyGetCurrency = foodItemAdapterTransactionCurrency.getCurrency();
                }


                if (foodItemAdapterTransactionCurrencyGetCurrency != null) {
                    // read foodItemAdapter.transactionCurrency.getCurrency().getSymbol()
                    foodItemAdapterTransactionCurrencyGetCurrencyGetSymbol = foodItemAdapterTransactionCurrencyGetCurrency.getSymbol();
                }


                // read (foodItem.price) + (foodItemAdapter.transactionCurrency.getCurrency().getSymbol())
                foodItemPriceFoodItemAdapterTransactionCurrencyGetCurrencyGetSymbol = (foodItemPrice) + (foodItemAdapterTransactionCurrencyGetCurrencyGetSymbol);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.alcineo.bonappetit.ui.shopping.adapter.RecyclerViewImageBindingAdapter.loadImage(this.itemIcon, foodItemImgRes);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemTitle, foodItemName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.quantityView, stringValueOfFoodItemQuantity);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemPrice, foodItemPriceFoodItemAdapterTransactionCurrencyGetCurrencyGetSymbol);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): foodItem
        flag 1 (0x2L): foodItemAdapter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}