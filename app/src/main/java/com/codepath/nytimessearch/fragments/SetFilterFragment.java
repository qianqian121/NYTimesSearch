package com.codepath.nytimessearch.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ToggleButton;

import com.codepath.nytimessearch.R;
import com.codepath.nytimessearch.models.Filter;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qiming on 7/30/2016.
 */
public class SetFilterFragment extends DialogFragment {
    @BindView(R.id.dpBeginDate)
    DatePicker dpBeginDate;
    @BindView(R.id.tbSortOrder)
    ToggleButton tbSortOrder;
    @BindView(R.id.cbArts)
    CheckBox cbArts;
    @BindView(R.id.cbFashion)
    CheckBox cbFashion;
    @BindView(R.id.cbSports)
    CheckBox cbSports;
    @BindView(R.id.btnSave)
    Button btnSave;

    Filter mFilter;
    SetFilterDialogListener mSetFilterDialogListener;

    public interface SetFilterDialogListener {
        void onFinishEditDialog(Filter filter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSetFilterDialogListener = (SetFilterDialogListener) activity;
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_filter, container);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mEditItem = (Item) getArguments().getSerializable("editItem");
        mFilter = (Filter) Parcels.unwrap(getArguments().getParcelable("filter"));
        if (mFilter.getBeginDate().isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            dpBeginDate.updateDate(calendar.get(Calendar.YEAR) - 1, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            String beginDate = mFilter.getBeginDate();
            dpBeginDate.updateDate(Integer.valueOf(beginDate.substring(0,4)),
                    Integer.parseInt(beginDate.substring(4,6)) - 1, Integer.parseInt(beginDate.substring(6, 8)));
        }
        tbSortOrder.setChecked("oldest".equals(mFilter.getSortOrder()) ? true : false);
        cbArts.setChecked(mFilter.getNewsDesk().getArts().isEmpty() ? false : true);
        cbFashion.setChecked(mFilter.getNewsDesk().getFashion().isEmpty() ? false : true);
        cbSports.setChecked(mFilter.getNewsDesk().getSports().isEmpty() ? false : true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar= Calendar.getInstance();
                calendar.set(dpBeginDate.getYear(),
                        dpBeginDate.getMonth(),
                        dpBeginDate.getDayOfMonth());
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
                String beginDate = dateformat.format(calendar.getTime());
                mFilter.setBeginDate(beginDate);
                mFilter.setSortOrder(String.valueOf(tbSortOrder.isChecked() ? "oldest" : "newest"));
                mFilter.newsDesk.setArts(cbArts.isChecked() ? "Arts" : "");
                mFilter.newsDesk.setFashion(cbFashion.isChecked() ? "Fashion" : "");
                mFilter.newsDesk.setSports(cbSports.isChecked() ? "Sports" : "");
                mSetFilterDialogListener.onFinishEditDialog(mFilter);
                dismiss();
            }
        });
    }

    public SetFilterFragment() {
    }

    public static SetFilterFragment newInstance(Filter filter) {
        SetFilterFragment frag = new SetFilterFragment();
        Bundle args = new Bundle();
        args.putParcelable("filter", Parcels.wrap(filter));
        frag.setArguments(args);

        return frag;
    }

//    public void onClick(View view) {
//        dismiss();
//    }
}
