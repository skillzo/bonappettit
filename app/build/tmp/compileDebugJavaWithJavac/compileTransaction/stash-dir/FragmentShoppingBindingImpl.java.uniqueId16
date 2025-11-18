package com.alcineo.bonappetit.databinding;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentShoppingBindingImpl extends FragmentShoppingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.shopping_toolbar, 2);
        sViewsWithIds.put(R.id.shopping_items_recyclerview, 3);
        sViewsWithIds.put(R.id.shopping_bottombar, 4);
        sViewsWithIds.put(R.id.shopping_bottombar_guideline, 5);
        sViewsWithIds.put(R.id.shopping_charge_button, 6);
        sViewsWithIds.put(R.id.shopping_charge_button_indicator, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentShoppingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentShoppingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (com.google.android.material.button.MaterialButton) bindings[6]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.shoppingBottombarTotalamountText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.shopping == variableId) {
            setShopping((com.alcineo.bonappetit.ui.shopping.ShoppingViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setShopping(@Nullable com.alcineo.bonappetit.ui.shopping.ShoppingViewModel Shopping) {
        this.mShopping = Shopping;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.shopping);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeShoppingTransactionAmount((androidx.lifecycle.MutableLiveData<java.math.BigDecimal>) object, fieldId);
            case 1 :
                return onChangeShoppingTransactionCurrencyCode((androidx.lifecycle.MutableLiveData<com.neovisionaries.i18n.CurrencyCode>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeShoppingTransactionAmount(androidx.lifecycle.MutableLiveData<java.math.BigDecimal> ShoppingTransactionAmount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeShoppingTransactionCurrencyCode(androidx.lifecycle.MutableLiveData<com.neovisionaries.i18n.CurrencyCode> ShoppingTransactionCurrencyCode, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        androidx.lifecycle.MutableLiveData<java.math.BigDecimal> shoppingTransactionAmount = null;
        java.lang.String javaLangStringTotalShoppingTransactionAmount = null;
        java.util.Currency shoppingTransactionCurrencyCodeGetCurrency = null;
        java.lang.String shoppingTransactionCurrencyCodeGetCurrencyGetSymbol = null;
        java.lang.String javaLangStringTotalShoppingTransactionAmountShoppingTransactionCurrencyCodeGetCurrencyGetSymbol = null;
        java.math.BigDecimal shoppingTransactionAmountGetValue = null;
        com.alcineo.bonappetit.ui.shopping.ShoppingViewModel shopping = mShopping;
        androidx.lifecycle.MutableLiveData<com.neovisionaries.i18n.CurrencyCode> shoppingTransactionCurrencyCode = null;
        com.neovisionaries.i18n.CurrencyCode shoppingTransactionCurrencyCodeGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {



                if (shopping != null) {
                    // read shopping.transactionAmount
                    shoppingTransactionAmount = shopping.transactionAmount;
                    // read shopping.transactionCurrencyCode
                    shoppingTransactionCurrencyCode = shopping.transactionCurrencyCode;
                }
                updateLiveDataRegistration(0, shoppingTransactionAmount);
                updateLiveDataRegistration(1, shoppingTransactionCurrencyCode);


                if (shoppingTransactionAmount != null) {
                    // read shopping.transactionAmount.getValue()
                    shoppingTransactionAmountGetValue = shoppingTransactionAmount.getValue();
                }
                if (shoppingTransactionCurrencyCode != null) {
                    // read shopping.transactionCurrencyCode.getValue()
                    shoppingTransactionCurrencyCodeGetValue = shoppingTransactionCurrencyCode.getValue();
                }


                // read ("Total: ") + (shopping.transactionAmount.getValue())
                javaLangStringTotalShoppingTransactionAmount = ("Total: ") + (shoppingTransactionAmountGetValue);
                if (shoppingTransactionCurrencyCodeGetValue != null) {
                    // read shopping.transactionCurrencyCode.getValue().getCurrency()
                    shoppingTransactionCurrencyCodeGetCurrency = shoppingTransactionCurrencyCodeGetValue.getCurrency();
                }


                if (shoppingTransactionCurrencyCodeGetCurrency != null) {
                    // read shopping.transactionCurrencyCode.getValue().getCurrency().getSymbol()
                    shoppingTransactionCurrencyCodeGetCurrencyGetSymbol = shoppingTransactionCurrencyCodeGetCurrency.getSymbol();
                }


                // read (("Total: ") + (shopping.transactionAmount.getValue())) + (shopping.transactionCurrencyCode.getValue().getCurrency().getSymbol())
                javaLangStringTotalShoppingTransactionAmountShoppingTransactionCurrencyCodeGetCurrencyGetSymbol = (javaLangStringTotalShoppingTransactionAmount) + (shoppingTransactionCurrencyCodeGetCurrencyGetSymbol);
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.shoppingBottombarTotalamountText, javaLangStringTotalShoppingTransactionAmountShoppingTransactionCurrencyCodeGetCurrencyGetSymbol);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): shopping.transactionAmount
        flag 1 (0x2L): shopping.transactionCurrencyCode
        flag 2 (0x3L): shopping
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}