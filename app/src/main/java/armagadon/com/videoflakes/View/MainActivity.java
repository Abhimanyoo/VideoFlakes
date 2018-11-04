package armagadon.com.videoflakes.View;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import armagadon.com.videoflakes.R;
import armagadon.com.videoflakes.databinding.ActivityMainBinding;
import armagadon.com.videoflakes.ViewModel.MainViewModel;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, LoadingCompletedListener {
    private static final String TAG = "ItemActivity";
    private MainViewModel viewModel;
    private ActivityMainBinding activityItemBinding;

    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
    }

    private void initData() {
        Log.d(TAG, "initData: ");
        itemAdapter = new ItemAdapter(this);
        activityItemBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityItemBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        activityItemBinding.recyclerView.setAdapter(itemAdapter);
        activityItemBinding.swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        activityItemBinding.swipeRefreshLayout.setOnRefreshListener(this);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityItemBinding.setViewModel(viewModel);
        viewModel.setLoadingCompletedListener(this);

        viewModel.getItemsList().observe(this, itemList -> {
            Log.d(TAG, "onChanged: " + itemList.size());
            itemAdapter.setData(itemList);
            itemAdapter.notifyDataSetChanged();

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel.errorInfoLayoutVisibility.get() == View.VISIBLE)
            viewModel.refreshData();

    }

    @Override
    public void onRefresh() {
        itemAdapter.clearItems();
        viewModel.refreshData();
    }


    @Override
    public void onLoadingCompleted() {
        if (activityItemBinding.swipeRefreshLayout.isRefreshing()) {
            activityItemBinding.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.setLoadingCompletedListener(null);
    }

}