package com.sweng888.quicktrip.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sweng888.quicktrip.R;
import com.sweng888.quicktrip.fragment.PreferenceItemFragment;
import com.sweng888.quicktrip.model.UserPreference;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link UserPreference} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PreferenceItemRecyclerViewAdapter extends RecyclerView.Adapter<PreferenceItemRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "PreferenceItemRVAdapter";
    private final List<UserPreference> mValues;
    private final PreferenceItemFragment.OnListFragmentInteractionListener mListener;

    public PreferenceItemRecyclerViewAdapter(List<UserPreference> items, PreferenceItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_preferenceitem, null, false);
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
        private TextView mPreferenceCategory, mPreferenceCharacteristic;
        private CheckBox mpreferencePreferred;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPreferenceCategory = itemView.findViewById(R.id.textPreferenceCategory);
            mPreferenceCharacteristic = itemView.findViewById(R.id.textPreferenceCharacteristic);
            mpreferencePreferred = itemView.findViewById(R.id.preferencePreferred);
        }

        public void configure(UserPreference item){
            this.mPreferenceCategory.setText(item.getCategory());
            this.mPreferenceCharacteristic.setText(item.getCharacteristic());
            this.mpreferencePreferred.setChecked(item.isPreferred());

            this.mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            int selectedPosition = getAdapterPosition();
            UserPreference p =  mValues.get(selectedPosition);
            p.changeSelection();
            Log.d(PreferenceItemRecyclerViewAdapter.TAG, "Changed List Item Selection for " +p.getCharacteristic()+" to "+ p.isPreferred());
            this.mpreferencePreferred.setChecked(p.isPreferred());
            mListener.onListFragmentInteraction(p);
        }
    }
}
