package com.sweng888.quicktrip.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sweng888.quicktrip.R;
import com.sweng888.quicktrip.model.Taste;

import java.util.List;

public class TasteListAdapter extends RecyclerView.Adapter<TasteListAdapter.TasteViewHolder> {
    private Context mContext;
    private List<Taste> tastes;

    public TasteListAdapter(Context mContext, List<Taste> tastes) {
        this.mContext = mContext;
        this.tastes = tastes;
    }

    @NonNull
    @Override
    public TasteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(mContext);
        try {
            View view = inflator.inflate(R.layout.taste_list_item_layout, null);
            return new TasteViewHolder(view);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TasteViewHolder tasteViewHolder, int i) {
        Taste t = tastes.get(i);
        tasteViewHolder.mTasteDescription.setText(t.getDescription());
        tasteViewHolder.mTastename.setText(t.getName());
        tasteViewHolder.mTasteSelected.setChecked(t.isSelected());
    }

    @Override
    public int getItemCount() {
        return tastes.size();
    }

    class TasteViewHolder extends RecyclerView.ViewHolder {
        private TextView mTastename, mTasteDescription;
        private CheckBox mTasteSelected;

        public TasteViewHolder(@NonNull View itemView) {
            super(itemView);

            mTastename = itemView.findViewById(R.id.textTasteName);
            mTasteDescription = itemView.findViewById(R.id.textTasteDescription);
            mTasteSelected = itemView.findViewById(R.id.tasteSelected);
        }
    }
}
