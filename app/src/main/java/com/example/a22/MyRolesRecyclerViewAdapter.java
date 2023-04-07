package com.example.a22;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a22.RoleContent.RoleItem;
import com.example.a22.databinding.FragmentRoleBinding;

import java.util.List;

public class MyRolesRecyclerViewAdapter extends RecyclerView.Adapter<MyRolesRecyclerViewAdapter.ViewHolder> {

    private final List<RoleItem> mValues;

    public MyRolesRecyclerViewAdapter(List<RoleItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRoleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public RoleItem mItem;

        public ViewHolder(FragmentRoleBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;

            mContentView.setOnClickListener(view -> {
                RolesFragmentDirections.ActionRolesFragmentToDetailFragment action =
                        RolesFragmentDirections.actionRolesFragmentToDetailFragment(mItem.details);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(action);
            });

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}