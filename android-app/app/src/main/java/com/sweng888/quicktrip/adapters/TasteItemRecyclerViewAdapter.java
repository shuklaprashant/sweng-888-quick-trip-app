package com.sweng888.quicktrip.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sweng888.quicktrip.R;
import com.sweng888.quicktrip.fragments.TasteItemFragment.OnListFragmentInteractionListener;
import com.sweng888.quicktrip.model.Taste;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Taste} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TasteItemRecyclerViewAdapter extends RecyclerView.Adapter<TasteItemRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "TasteItemRVAdapter";
    private final List<Taste> mValues;
    private final OnListFragmentInteractionListener mListener;

    public TasteItemRecyclerViewAdapter(List<Taste> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tasteitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.configure(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View mView;
        private TextView mTastename, mTasteDescription;
        private CheckBox mTasteSelected;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTastename = itemView.findViewById(R.id.textTasteName);
            mTasteDescription = itemView.findViewById(R.id.textTasteDescription);
            mTasteSelected = itemView.findViewById(R.id.tasteSelected);
        }

        public void configure(Taste item){
            this.mTasteDescription.setText(item.getDescription());
            this.mTastename.setText(item.getName());
            this.mTasteSelected.setChecked(item.isSelected());

            this.mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            int selectedPosition = getAdapterPosition();
            Taste t =  mValues.get(selectedPosition);
            t.changeSelection();
            Log.d(TasteItemRecyclerViewAdapter.TAG, "Changed List Item Selection for " +t.getName()+" to "+t.isSelected());
            this.mTasteSelected.setChecked(t.isSelected());
            mListener.onListFragmentInteraction(t);
        }
    }
}
