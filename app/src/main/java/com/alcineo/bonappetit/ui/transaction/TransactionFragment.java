package com.alcineo.bonappetit.ui.transaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;

import com.alcineo.administrative.Kernel;
import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.databinding.FragmentTransactionBinding;
import com.alcineo.bonappetit.model.TransactionFullDataDto;
import com.alcineo.bonappetit.ui.transaction.TransactionFragmentDirections.ActionTransactionToReceipt;
import com.visa.SensoryBrandingView;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TransactionFragment extends Fragment {

    private static final String TAG = TransactionFragment.class.getSimpleName();

    private static TransactionViewModel mTransactionViewModel = null;
    private FragmentTransactionBinding mFragmentTransactionBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFragmentTransactionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_transaction, container, false);

        deactivateBackButton();

        setupViewModel();
        setupObservers();

        mFragmentTransactionBinding.setTransaction(mTransactionViewModel);
        mFragmentTransactionBinding.setLifecycleOwner(getViewLifecycleOwner());

        return mFragmentTransactionBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mTransactionViewModel.startTransaction(getViewLifecycleOwner());
        Log.i(TAG, "onViewCreated Transaction Fragment");

    }

    private void setupViewModel() {
        mTransactionViewModel = TransactionViewModel.INSTANCE;
    }

    private void setupObservers() {

        LifecycleOwner l =  getViewLifecycleOwner();

        mTransactionViewModel.onTransactionFinishedEvent
                .observe(getViewLifecycleOwner(), this::launchTransactionEndingAnimationAndNavigate);

        mFragmentTransactionBinding.transactionCancelButton.setOnClickListener(v -> cancelTransactionAndNavigateBack());
    }

    private void deactivateBackButton() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
    }

    private void launchTransactionEndingAnimationAndNavigate(TransactionFullDataDto transactionFullDataDto) {
        ViewPropertyAnimator viewPropertyAnimator;

        if(transactionFullDataDto != null) {
            if (Objects.equals(mTransactionViewModel.transactionKernel.getValue(), Kernel.K_PAYWAVE)) {
                viewPropertyAnimator = launchVisaAnimation();
            } else {
                viewPropertyAnimator = mFragmentTransactionBinding.transactionCancelButton.animate().translationY(0);
            }
            viewPropertyAnimator.withEndAction(() -> navigateToReceiptFragment(transactionFullDataDto)).start();
        }
        mTransactionViewModel.onTransactionFinishedEvent.postValue(null);
    }


    private ViewPropertyAnimator launchVisaAnimation() {
        SensoryBrandingView visaSensoryBrandingView = requireView().findViewById(R.id.transaction_end_animation_view);
        visaSensoryBrandingView.setBackdropColor(requireContext().getResources().getColor(R.color.white, null));
        visaSensoryBrandingView.setVisibility(View.VISIBLE);
        visaSensoryBrandingView.animate();
        return new View(requireContext()).animate().setDuration(1300);
    }

    private void navigateToReceiptFragment(TransactionFullDataDto transactionFullDataDto) {
        final ActionTransactionToReceipt actionTransactionToReceipt = TransactionFragmentDirections
                .actionTransactionToReceipt(transactionFullDataDto);
        Navigation.findNavController(requireView()).navigate(actionTransactionToReceipt);
    }


    private void cancelTransactionAndNavigateBack() {
        mTransactionViewModel.cancelTransaction();

        mFragmentTransactionBinding.transactionCancelButton.setText("");

        mFragmentTransactionBinding.transactionCancelButtonProgressIndicator.setVisibility(View.VISIBLE);
        mFragmentTransactionBinding.transactionCancelButtonProgressIndicator.animate();
    }
}