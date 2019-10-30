package com.example.viewpagerdemo.web;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.viewpagerdemo.DialogUtil;
import com.example.viewpagerdemo.LoadingDialogUtil;
import com.example.viewpagerdemo.R;

public class BaseFragment extends Fragment {


    View view;
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    private final Handler mHandler = new Handler();
    private final Runnable mRequestFocus = new Runnable() {
        public void run() {
           BaseFragment.this.mList.focusableViewAvailable(BaseFragment.this.mList);
        }
    };
    private final AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
           BaseFragment.this.onListItemClick((ListView)parent, v, position, id);
        }
    };
    ListAdapter mAdapter;
    ListView mList;
    View mEmptyView;
    TextView mStandardEmptyView;
    View mProgressContainer;
    View mListContainer;
    CharSequence mEmptyText;
    boolean mListShown;

    public BaseFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_fragment,container,false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected void sendHttpPostRequest(String url, CommonRequest request, ResponseHandler responseHandler) {
        new HttpPostTask(request, mHandler, responseHandler).execute(url);

    }




    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mEmptyView = this.mProgressContainer = this.mListContainer = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
    }









    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }


}
