package com.bvhloc.general.base.adapter;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 10/26/2016.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context context;
    protected List<T> items;

    protected abstract int getItemLayout();

    protected View getItemView() {
        return null;
    }

    protected abstract void onCreateViewHolder(ViewDataBinding dataBinding, RecyclerView.ViewHolder holder);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@SuppressWarnings("NullableProblems") ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false);
//        return onCreateViewHolder(view);
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                getItemLayout(), parent, false);
        return new ItemViewHolder(binding);
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding dataBinding;

        private ItemViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            onCreateViewHolder(dataBinding, this);
            this.dataBinding = dataBinding;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        T item = getItem(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        onBindViewHolder(itemViewHolder.dataBinding, position, item);
    }

    protected abstract void onBindViewHolder(ViewDataBinding dataBinding, int position, T item);

    @Override
    public int getItemCount() {
        if (items == null) {
            items = new ArrayList<T>();
        }
        return items.size();
    }

    public T getItem(int position) {
        if (position >= 0 && position < getItemCount())
            return items.get(position);
        else
            return null;
    }

    public void insertItem(T newItem) {
        items.add(newItem);
        notifyItemChanged(items.size() - 1);
//        notifyDataSetChanged();
    }

    public void insertItems(List<T> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public void removeItem(T itemToRemove) {
        items.remove(itemToRemove);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }


    public void removeAllItems() {
        items = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void updateItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public List<T> getAllItems() {
        return items;
    }

    protected AdapterView.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private AdapterView.OnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
