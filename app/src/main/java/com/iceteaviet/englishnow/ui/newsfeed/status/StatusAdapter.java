package com.iceteaviet.englishnow.ui.newsfeed.status;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iceteaviet.englishnow.R;
import com.iceteaviet.englishnow.databinding.StatusItemBinding;
import com.iceteaviet.englishnow.ui.base.BaseRecyclerViewAdapter;
import com.iceteaviet.englishnow.ui.base.BaseViewHolder;
import com.iceteaviet.englishnow.ui.newsfeed.status.viewmodel.StatusItemViewModel;

/**
 * Created by Genius Doan on 02/01/2018.
 * <p>
 * Adapter to convert list data into Views
 */

public class StatusAdapter extends BaseRecyclerViewAdapter<StatusItemViewModel> {
    protected Context mContext;

    public StatusAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StatusItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.status_item, parent, false);
        return new StatusItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindStatusItemView(holder, position);
    }

    private void bindStatusItemView(RecyclerView.ViewHolder holder, int position) {
        StatusItemViewHolder viewHolder = (StatusItemViewHolder) holder;
        viewHolder.onBind(position);
    }

    //ViewHolder pattern
    public class StatusItemViewHolder extends BaseViewHolder {
        private StatusItemBinding statusItemBinding;

        public StatusItemViewHolder(StatusItemBinding binding) {
            super(binding.getRoot());
            statusItemBinding = binding;
        }

        @Override
        public void onBind(int position) {
            statusItemBinding.setViewModel(mItems.get(position));
        }
    }
}
