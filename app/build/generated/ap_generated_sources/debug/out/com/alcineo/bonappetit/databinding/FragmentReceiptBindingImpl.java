package com.alcineo.bonappetit.databinding;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentReceiptBindingImpl extends FragmentReceiptBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.receipt_animated_vector, 2);
        sViewsWithIds.put(R.id.receipt_leave_button, 3);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentReceiptBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentReceiptBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.receiptMotionlayout.setTag(null);
        this.receiptTicketText.setTag(null);
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
        if (BR.receipt == variableId) {
            setReceipt((com.alcineo.bonappetit.ui.receipt.ReceiptViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setReceipt(@Nullable com.alcineo.bonappetit.ui.receipt.ReceiptViewModel Receipt) {
        this.mReceipt = Receipt;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.receipt);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeReceiptReceipt((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeReceiptReceipt(androidx.lifecycle.LiveData<java.lang.String> ReceiptReceipt, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        java.lang.String receiptReceiptGetValue = null;
        com.alcineo.bonappetit.ui.receipt.ReceiptViewModel receipt = mReceipt;
        androidx.lifecycle.LiveData<java.lang.String> receiptReceipt = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (receipt != null) {
                    // read receipt.receipt
                    receiptReceipt = receipt.receipt;
                }
                updateLiveDataRegistration(0, receiptReceipt);


                if (receiptReceipt != null) {
                    // read receipt.receipt.getValue()
                    receiptReceiptGetValue = receiptReceipt.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.receiptTicketText.setText(receiptReceiptGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): receipt.receipt
        flag 1 (0x2L): receipt
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}