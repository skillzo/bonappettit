package com.alcineo.bonappetit.ui.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.databinding.FragmentShoppingBinding;
import com.alcineo.bonappetit.domain.SoftposInitialization;
import com.alcineo.bonappetit.ui.MainActivity;
import com.alcineo.bonappetit.ui.settings.SettingsFragment;
import com.alcineo.bonappetit.ui.shopping.adapter.FoodItemAdapter;
import com.alcineo.bonappetit.domain.utils.SharedPreferencesHelper;
import com.alcineo.bonappetit.ui.transaction.TransactionViewModel;
import com.alcineo.softpos.payment.api.interfaces.NFCListener;
import com.alcineo.softpos.payment.model.transaction.TransactionParameters;
import com.alcineo.transaction.TransactionType;
import com.alcineo.utils.common.StringUtils;
import com.neovisionaries.i18n.CurrencyCode;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Observable;

public class ShoppingFragment extends Fragment {

    private static final String TAG = ShoppingFragment.class.getSimpleName();

    private ShoppingViewModel       mShoppingViewModel;
    private FoodItemAdapter         foodItemAdapter;
    private FragmentShoppingBinding mShoppingFragmentBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mShoppingViewModel = new ViewModelProvider(this, new ShoppingViewModelFactory()).get(ShoppingViewModel.class);
        mShoppingViewModel.transactionAmount.setValue(new BigDecimal(0));

        mShoppingFragmentBinding = FragmentShoppingBinding.inflate(inflater, container, false);

        mShoppingFragmentBinding.setShopping(mShoppingViewModel);
        mShoppingFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());

        RecyclerView recyclerView = mShoppingFragmentBinding.shoppingItemsRecyclerview;


        SharedPreferencesHelper.getCurrencyCodeFromPrefs(requireContext(), currencyCode -> {
                    foodItemAdapter = new FoodItemAdapter(mShoppingViewModel.transactionAmount, currencyCode);
                    recyclerView.setAdapter(foodItemAdapter);

                    mShoppingViewModel.updateCurrency(currencyCode);
                    foodItemAdapter.transactionCurrency = currencyCode;
                });


        mShoppingFragmentBinding.shoppingChargeButton.setOnClickListener(this::onStartTransactionClick);

        if (((SoftposInitialization) ((MainActivity) requireActivity()).softposInitializationObservable).isDeviceReady()) {
            mShoppingFragmentBinding.shoppingChargeButton.setEnabled(true);
            mShoppingFragmentBinding.shoppingChargeButtonIndicator.setVisibility(View.INVISIBLE);
        } else {
            ((MainActivity) requireActivity()).softposInitializationObservable.addObserver((Observable o, Object arg) -> {
                if (o instanceof SoftposInitialization) {
                    requireActivity().runOnUiThread(() -> {
                        mShoppingFragmentBinding.shoppingChargeButton.setEnabled((Boolean) arg);
                        mShoppingFragmentBinding.shoppingChargeButtonIndicator.setVisibility(View.INVISIBLE);
                    });
                }
            });
        }

        return mShoppingFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = requireView().findViewById(R.id.shopping_toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Navigation.findNavController(requireView()).navigate(ShoppingFragmentDirections.actionShoppingToSettings());
        }
        return super.onOptionsItemSelected(item);
    }

    static public TransactionViewModel mTransactionViewModel;
    void onStartTransactionClick(View v) {
        TransactionParameters transactionParameters = setupTransaction();
        mTransactionViewModel = new TransactionViewModel(requireContext(), transactionParameters, this.getParentFragmentManager());
        mTransactionViewModel.startTransaction(new LifecycleOwner() {
            @NonNull
            @NotNull
            @Override
            public Lifecycle getLifecycle() {
                return getActivity().getLifecycle();
            }
        });

        Navigation.findNavController(requireView()).navigate(ShoppingFragmentDirections.actionShoppingToTransaction());
    }

    private TransactionParameters setupTransaction() {
        final int cardInteractionWaitingTime = 15;
        final BigDecimal transactionRefund = null;
        final BigDecimal balanceBefore = null;
        final BigDecimal balanceAfter = null;
        final TransactionType transactionType = TransactionType.PURCHASE;
//        final byte transactionType = (byte)TransactionType.PURCHASE.getValue();
        final String transactionCategoryCode = "F";
        final String transactionMerchantData = StringUtils.convertBytesToHex("Alcineo".getBytes(StandardCharsets.UTF_8));
        final CurrencyCode transactionCurrency = mShoppingViewModel.transactionCurrencyCode.getValue();
        final BigDecimal transactionAmount = mShoppingViewModel.transactionAmount.getValue();
//        transactionAmount = new BigDecimal("150.00");
//        transactionAmount = new BigDecimal("10.00");

        return new TransactionParameters(cardInteractionWaitingTime,
                transactionAmount,
                transactionRefund,
                balanceBefore,
                balanceAfter,
                transactionType,
                transactionCurrency,
                transactionCategoryCode,
                transactionMerchantData);
    }

}