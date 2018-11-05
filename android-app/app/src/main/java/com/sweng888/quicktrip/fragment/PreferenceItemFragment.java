package com.sweng888.quicktrip.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sweng888.quicktrip.R;
import com.sweng888.quicktrip.adapter.PreferenceItemRecyclerViewAdapter;
import com.sweng888.quicktrip.model.UserPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PreferenceItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PreferenceItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreferenceItemFragment extends Fragment {
    private List<UserPreference> userPreference;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PreferenceItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PreferenceItemFragment newInstance(int columnCount) {
        PreferenceItemFragment fragment = new PreferenceItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preferenceitem_list, container, false);

        userPreference = new ArrayList<>();
        userPreference.add(new UserPreference("1", "Food", "Spicy", false));
        userPreference.add(new UserPreference("2", "Food", "Sweet", false));
        userPreference.add(new UserPreference("3", "Food", "Healthy", false));
        userPreference.add(new UserPreference("1", "Food", "Meat.", false));
        userPreference.add(new UserPreference("2", "Food", "Pizza", false));
        userPreference.add(new UserPreference("1", "Food", "Spicy", false));
        userPreference.add(new UserPreference("2", "Food", "Sweet", false));
        userPreference.add(new UserPreference("3", "Food", "Healthy", false));
        userPreference.add(new UserPreference("1", "Food", "Meat.", false));
        userPreference.add(new UserPreference("2", "Food", "Pizza", false));
        userPreference.add(new UserPreference("1", "Food", "Spicy", false));
        userPreference.add(new UserPreference("2", "Food", "Sweet", false));
        userPreference.add(new UserPreference("3", "Food", "Healthy", false));
        userPreference.add(new UserPreference("1", "Food", "Meat.", false));
        userPreference.add(new UserPreference("2", "Food", "Pizza", false));
        userPreference.add(new UserPreference("1", "Food", "Spicy", false));
        userPreference.add(new UserPreference("2", "Food", "Sweet", false));
        userPreference.add(new UserPreference("3", "Food", "Healthy", false));
        userPreference.add(new UserPreference("1", "Food", "Meat.", false));
        userPreference.add(new UserPreference("2", "Food", "Pizza", false));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new PreferenceItemRecyclerViewAdapter(userPreference, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(UserPreference item);
    }
}
