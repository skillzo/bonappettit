package com.alcineo.bonappetit.databinding;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTransactionBindingImpl extends FragmentTransactionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.transaction_ledgroup, 12);
        sViewsWithIds.put(R.id.constraintLayout, 13);
        sViewsWithIds.put(R.id.transaction_we_accept_vertical_line, 14);
        sViewsWithIds.put(R.id.transaction_bottom_bar_txt, 15);
        sViewsWithIds.put(R.id.transaction_we_accept_guideline, 16);
        sViewsWithIds.put(R.id.transaction_cancel_button_progress_indicator, 17);
        sViewsWithIds.put(R.id.transaction_end_animation_view, 18);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTransactionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentTransactionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[15]
            , (com.google.android.material.button.MaterialButton) bindings[10]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[17]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (com.visa.SensoryBrandingView) bindings[18]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[7]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[8]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[11]
            , (androidx.constraintlayout.widget.Guideline) bindings[16]
            , (android.view.View) bindings[14]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.transactionCancelButton.setTag(null);
        this.transactionContactlessLogo.setTag(null);
        this.transactionLed1.setTag(null);
        this.transactionLed2.setTag(null);
        this.transactionLed3.setTag(null);
        this.transactionLed4.setTag(null);
        this.transactionLogoKernel1.setTag(null);
        this.transactionLogoKernel2.setTag(null);
        this.transactionLogoKernel3.setTag(null);
        this.transactionMessagesText.setTag(null);
        this.transactionPreparationIndicator.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
        if (BR.transaction == variableId) {
            setTransaction((com.alcineo.bonappetit.ui.transaction.TransactionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTransaction(@Nullable com.alcineo.bonappetit.ui.transaction.TransactionViewModel Transaction) {
        this.mTransaction = Transaction;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.transaction);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTransactionContactlessLogo((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeTransactionTransactionLedList((androidx.lifecycle.MutableLiveData<java.util.List<com.alcineo.bonappetit.model.TransactionLed>>) object, fieldId);
            case 2 :
                return onChangeTransactionPaymentSchemeLogo1((androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable>) object, fieldId);
            case 3 :
                return onChangeTransactionPaymentSchemeLogo3((androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable>) object, fieldId);
            case 4 :
                return onChangeTransactionTransactionStartedEvent((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 5 :
                return onChangeTransactionTransactionMessage((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeTransactionPaymentSchemeLogo2((androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTransactionContactlessLogo(androidx.lifecycle.MutableLiveData<java.lang.Boolean> TransactionContactlessLogo, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionTransactionLedList(androidx.lifecycle.MutableLiveData<java.util.List<com.alcineo.bonappetit.model.TransactionLed>> TransactionTransactionLedList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionPaymentSchemeLogo1(androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> TransactionPaymentSchemeLogo1, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionPaymentSchemeLogo3(androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> TransactionPaymentSchemeLogo3, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionTransactionStartedEvent(androidx.lifecycle.MutableLiveData<java.lang.Boolean> TransactionTransactionStartedEvent, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionTransactionMessage(androidx.lifecycle.MutableLiveData<java.lang.String> TransactionTransactionMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransactionPaymentSchemeLogo2(androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> TransactionPaymentSchemeLogo2, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        int transactionTransactionLedListGetInt2BackgroundColor = 0;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> TransactionContactlessLogo1 = null;
        androidx.lifecycle.MutableLiveData<java.util.List<com.alcineo.bonappetit.model.TransactionLed>> transactionTransactionLedList = null;
        android.graphics.drawable.Drawable transactionPaymentSchemeLogo3GetValue = null;
        com.alcineo.bonappetit.model.TransactionLed transactionTransactionLedListGetInt0 = null;
        java.lang.Boolean transactionTransactionStartedEventGetValue = null;
        android.graphics.drawable.Drawable transactionPaymentSchemeLogo1GetValue = null;
        androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> transactionPaymentSchemeLogo1 = null;
        androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> transactionPaymentSchemeLogo3 = null;
        int transactionTransactionStartedEventViewGONEViewVISIBLE = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxTransactionContactlessLogoGetValue = false;
        android.graphics.drawable.Drawable transactionPaymentSchemeLogo2GetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxTransactionTransactionStartedEventGetValue = false;
        int transactionContactlessLogoViewVISIBLEViewGONE = 0;
        com.alcineo.bonappetit.model.TransactionLed transactionTransactionLedListGetInt3 = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> transactionTransactionStartedEvent = null;
        int transactionTransactionLedListGetInt1BackgroundColor = 0;
        int transactionTransactionStartedEventViewVISIBLEViewINVISIBLE = 0;
        java.lang.String transactionTransactionMessageGetValue = null;
        com.alcineo.bonappetit.model.TransactionLed transactionTransactionLedListGetInt1 = null;
        int transactionTransactionLedListGetInt0BackgroundColor = 0;
        androidx.lifecycle.MutableLiveData<java.lang.String> transactionTransactionMessage = null;
        java.lang.Boolean transactionContactlessLogoGetValue = null;
        androidx.lifecycle.MutableLiveData<android.graphics.drawable.Drawable> transactionPaymentSchemeLogo2 = null;
        int transactionTransactionLedListGetInt3BackgroundColor = 0;
        java.util.List<com.alcineo.bonappetit.model.TransactionLed> transactionTransactionLedListGetValue = null;
        com.alcineo.bonappetit.model.TransactionLed transactionTransactionLedListGetInt2 = null;
        com.alcineo.bonappetit.ui.transaction.TransactionViewModel transaction = mTransaction;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x181L) != 0) {

                    if (transaction != null) {
                        // read transaction.contactlessLogo
                        TransactionContactlessLogo1 = transaction.contactlessLogo;
                    }
                    updateLiveDataRegistration(0, TransactionContactlessLogo1);


                    if (TransactionContactlessLogo1 != null) {
                        // read transaction.contactlessLogo.getValue()
                        transactionContactlessLogoGetValue = TransactionContactlessLogo1.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(transaction.contactlessLogo.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxTransactionContactlessLogoGetValue = androidx.databinding.ViewDataBinding.safeUnbox(transactionContactlessLogoGetValue);
                if((dirtyFlags & 0x181L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxTransactionContactlessLogoGetValue) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(transaction.contactlessLogo.getValue()) ? View.VISIBLE : View.GONE
                    transactionContactlessLogoViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxTransactionContactlessLogoGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x182L) != 0) {

                    if (transaction != null) {
                        // read transaction.transactionLedList
                        transactionTransactionLedList = transaction.transactionLedList;
                    }
                    updateLiveDataRegistration(1, transactionTransactionLedList);


                    if (transactionTransactionLedList != null) {
                        // read transaction.transactionLedList.getValue()
                        transactionTransactionLedListGetValue = transactionTransactionLedList.getValue();
                    }


                    if (transactionTransactionLedListGetValue != null) {
                        // read transaction.transactionLedList.getValue().get(0)
                        transactionTransactionLedListGetInt0 = transactionTransactionLedListGetValue.get(0);
                        // read transaction.transactionLedList.getValue().get(3)
                        transactionTransactionLedListGetInt3 = transactionTransactionLedListGetValue.get(3);
                        // read transaction.transactionLedList.getValue().get(1)
                        transactionTransactionLedListGetInt1 = transactionTransactionLedListGetValue.get(1);
                        // read transaction.transactionLedList.getValue().get(2)
                        transactionTransactionLedListGetInt2 = transactionTransactionLedListGetValue.get(2);
                    }


                    if (transactionTransactionLedListGetInt0 != null) {
                        // read transaction.transactionLedList.getValue().get(0).backgroundColor
                        transactionTransactionLedListGetInt0BackgroundColor = transactionTransactionLedListGetInt0.getBackgroundColor();
                    }
                    if (transactionTransactionLedListGetInt3 != null) {
                        // read transaction.transactionLedList.getValue().get(3).backgroundColor
                        transactionTransactionLedListGetInt3BackgroundColor = transactionTransactionLedListGetInt3.getBackgroundColor();
                    }
                    if (transactionTransactionLedListGetInt1 != null) {
                        // read transaction.transactionLedList.getValue().get(1).backgroundColor
                        transactionTransactionLedListGetInt1BackgroundColor = transactionTransactionLedListGetInt1.getBackgroundColor();
                    }
                    if (transactionTransactionLedListGetInt2 != null) {
                        // read transaction.transactionLedList.getValue().get(2).backgroundColor
                        transactionTransactionLedListGetInt2BackgroundColor = transactionTransactionLedListGetInt2.getBackgroundColor();
                    }
            }
            if ((dirtyFlags & 0x184L) != 0) {

                    if (transaction != null) {
                        // read transaction.paymentSchemeLogo1
                        transactionPaymentSchemeLogo1 = transaction.paymentSchemeLogo1;
                    }
                    updateLiveDataRegistration(2, transactionPaymentSchemeLogo1);


                    if (transactionPaymentSchemeLogo1 != null) {
                        // read transaction.paymentSchemeLogo1.getValue()
                        transactionPaymentSchemeLogo1GetValue = transactionPaymentSchemeLogo1.getValue();
                    }
            }
            if ((dirtyFlags & 0x188L) != 0) {

                    if (transaction != null) {
                        // read transaction.paymentSchemeLogo3
                        transactionPaymentSchemeLogo3 = transaction.paymentSchemeLogo3;
                    }
                    updateLiveDataRegistration(3, transactionPaymentSchemeLogo3);


                    if (transactionPaymentSchemeLogo3 != null) {
                        // read transaction.paymentSchemeLogo3.getValue()
                        transactionPaymentSchemeLogo3GetValue = transactionPaymentSchemeLogo3.getValue();
                    }
            }
            if ((dirtyFlags & 0x190L) != 0) {

                    if (transaction != null) {
                        // read transaction.transactionStartedEvent
                        transactionTransactionStartedEvent = transaction.transactionStartedEvent;
                    }
                    updateLiveDataRegistration(4, transactionTransactionStartedEvent);


                    if (transactionTransactionStartedEvent != null) {
                        // read transaction.transactionStartedEvent.getValue()
                        transactionTransactionStartedEventGetValue = transactionTransactionStartedEvent.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxTransactionTransactionStartedEventGetValue = androidx.databinding.ViewDataBinding.safeUnbox(transactionTransactionStartedEventGetValue);
                if((dirtyFlags & 0x190L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxTransactionTransactionStartedEventGetValue) {
                            dirtyFlags |= 0x400L;
                            dirtyFlags |= 0x4000L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                            dirtyFlags |= 0x2000L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.GONE : View.VISIBLE
                    transactionTransactionStartedEventViewGONEViewVISIBLE = ((androidxDatabindingViewDataBindingSafeUnboxTransactionTransactionStartedEventGetValue) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                    // read androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.VISIBLE : View.INVISIBLE
                    transactionTransactionStartedEventViewVISIBLEViewINVISIBLE = ((androidxDatabindingViewDataBindingSafeUnboxTransactionTransactionStartedEventGetValue) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            }
            if ((dirtyFlags & 0x1a0L) != 0) {

                    if (transaction != null) {
                        // read transaction.transactionMessage
                        transactionTransactionMessage = transaction.transactionMessage;
                    }
                    updateLiveDataRegistration(5, transactionTransactionMessage);


                    if (transactionTransactionMessage != null) {
                        // read transaction.transactionMessage.getValue()
                        transactionTransactionMessageGetValue = transactionTransactionMessage.getValue();
                    }
            }
            if ((dirtyFlags & 0x1c0L) != 0) {

                    if (transaction != null) {
                        // read transaction.paymentSchemeLogo2
                        transactionPaymentSchemeLogo2 = transaction.paymentSchemeLogo2;
                    }
                    updateLiveDataRegistration(6, transactionPaymentSchemeLogo2);


                    if (transactionPaymentSchemeLogo2 != null) {
                        // read transaction.paymentSchemeLogo2.getValue()
                        transactionPaymentSchemeLogo2GetValue = transactionPaymentSchemeLogo2.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x190L) != 0) {
            // api target 1

            this.transactionCancelButton.setVisibility(transactionTransactionStartedEventViewVISIBLEViewINVISIBLE);
            this.transactionPreparationIndicator.setVisibility(transactionTransactionStartedEventViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            this.transactionContactlessLogo.setVisibility(transactionContactlessLogoViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x182L) != 0) {
            // api target 1

            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.transactionLed1, androidx.databinding.adapters.Converters.convertColorToDrawable(transactionTransactionLedListGetInt0BackgroundColor));
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.transactionLed2, androidx.databinding.adapters.Converters.convertColorToDrawable(transactionTransactionLedListGetInt1BackgroundColor));
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.transactionLed3, androidx.databinding.adapters.Converters.convertColorToDrawable(transactionTransactionLedListGetInt2BackgroundColor));
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.transactionLed4, androidx.databinding.adapters.Converters.convertColorToDrawable(transactionTransactionLedListGetInt3BackgroundColor));
        }
        if ((dirtyFlags & 0x184L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.transactionLogoKernel1, transactionPaymentSchemeLogo1GetValue);
        }
        if ((dirtyFlags & 0x1c0L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.transactionLogoKernel2, transactionPaymentSchemeLogo2GetValue);
        }
        if ((dirtyFlags & 0x188L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.transactionLogoKernel3, transactionPaymentSchemeLogo3GetValue);
        }
        if ((dirtyFlags & 0x1a0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.transactionMessagesText, transactionTransactionMessageGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): transaction.contactlessLogo
        flag 1 (0x2L): transaction.transactionLedList
        flag 2 (0x3L): transaction.paymentSchemeLogo1
        flag 3 (0x4L): transaction.paymentSchemeLogo3
        flag 4 (0x5L): transaction.transactionStartedEvent
        flag 5 (0x6L): transaction.transactionMessage
        flag 6 (0x7L): transaction.paymentSchemeLogo2
        flag 7 (0x8L): transaction
        flag 8 (0x9L): null
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.GONE : View.VISIBLE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.GONE : View.VISIBLE
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.contactlessLogo.getValue()) ? View.VISIBLE : View.GONE
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.contactlessLogo.getValue()) ? View.VISIBLE : View.GONE
        flag 13 (0xeL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.VISIBLE : View.INVISIBLE
        flag 14 (0xfL): androidx.databinding.ViewDataBinding.safeUnbox(transaction.transactionStartedEvent.getValue()) ? View.VISIBLE : View.INVISIBLE
    flag mapping end*/
    //end
}