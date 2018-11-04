package armagadon.com.videoflakes.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import armagadon.com.videoflakes.Model.GifVideo;
import armagadon.com.videoflakes.Model.RetrofitHelper;
import armagadon.com.videoflakes.View.LoadingCompletedListener;

import java.util.List;


import armagadon.com.videoflakes.Model.GifVideo;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;


public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "MainViewModel";
    public ObservableField<Integer> contentViewVisibility;
    public ObservableField<Integer> progressBarVisibility;
    public ObservableField<Integer> errorInfoLayoutVisibility;
    public ObservableField<String> exception;
    private Subscriber<List<GifVideo>> subscriber;
    private MutableLiveData<List<GifVideo>> mItemList = new MutableLiveData<>();
    private CompositeSubscription compositeSubscription;
    private LoadingCompletedListener loadingCompletedListener;
    public MainViewModel(@NonNull Application application) {
        super(application);
        initData();
        getItems();

    }

    public LiveData<List<GifVideo>> getItemsList() {
        if (mItemList == null) {
            mItemList = new MutableLiveData<>();
            getItems();
        }
        return mItemList;
    }


    private void getItems() {
        subscriber = new Subscriber<List<GifVideo>>() {
            @Override
            public void onCompleted() {
                hideAll();
                contentViewVisibility.set(View.VISIBLE);
                if (loadingCompletedListener!=null)
                    loadingCompletedListener.onLoadingCompleted();
            }

            @Override
            public void onError(Throwable e) {
                hideAll();
                errorInfoLayoutVisibility.set(View.VISIBLE);
                exception.set(e.getMessage());
                loadingCompletedListener.onLoadingCompleted();
            }

            @Override
            public void onNext(List<GifVideo> item) {
                mItemList.setValue(item);
                Log.d(TAG, "onNext: " + item.size());
                Log.d(TAG, "onNext: " + Thread.currentThread().getName());
            }
        };
        RetrofitHelper.getInstance().getItems(subscriber);

        compositeSubscription.add(subscriber);


    }

    public void refreshData() {
        getItems();
    }

    private void initData() {
        contentViewVisibility = new ObservableField<>();
        progressBarVisibility = new ObservableField<>();
        errorInfoLayoutVisibility = new ObservableField<>();
        compositeSubscription=new CompositeSubscription();
        exception = new ObservableField<>();
        contentViewVisibility.set(View.GONE);
        errorInfoLayoutVisibility.set(View.GONE);
        progressBarVisibility.set(View.VISIBLE);
    }

    public void hideAll() {
        contentViewVisibility.set(View.GONE);
        errorInfoLayoutVisibility.set(View.GONE);
        progressBarVisibility.set(View.GONE);


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        if (compositeSubscription!=null)
            compositeSubscription.clear();
    }


    public void setLoadingCompletedListener(LoadingCompletedListener loadingCompletedListener) {
        this.loadingCompletedListener = loadingCompletedListener;
    }
}
