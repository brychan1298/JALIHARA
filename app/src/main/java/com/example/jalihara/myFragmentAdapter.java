package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class myFragmentAdapter extends FragmentStateAdapter{
    public myFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return new ContactUsFragment();
        }
        return new AboutUsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
