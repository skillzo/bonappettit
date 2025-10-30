package com.alcineo.bonappetit.ui.transaction;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

import com.alcineo.softpos.payment.model.transaction.TransactionParameters;
import org.jetbrains.annotations.NotNull;

public class TransactionViewModelFactory implements Factory {

    private final Context context;
    private final TransactionParameters transactionParameters;
    private final FragmentManager fragmentManager;

    public TransactionViewModelFactory(Context context, TransactionParameters transactionParameters, FragmentManager fragmentManager) {
        this.context = context;
        this.transactionParameters = transactionParameters;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new TransactionViewModel(context, transactionParameters, fragmentManager);
    }
}
