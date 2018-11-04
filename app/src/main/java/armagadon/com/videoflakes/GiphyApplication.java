package armagadon.com.videoflakes;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import armagadon.com.videoflakes.component.ApplicationComponent;
import armagadon.com.videoflakes.model.GiphyService;
import armagadon.com.videoflakes.module.GiphyModule;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GiphyApplication  extends Application {

    private static GiphyService sGiphyAPI;
    private static ApplicationComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
        initDagger();
    }

    private void initDagger() {
        sAppComponent = DaggerApplicationComponent.builder()
                .giphyModule(new GiphyModule())
                .build();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        sGiphyAPI = retrofit.create(GiphyService.class);
    }

    public static GiphyService getApi() {
        return sGiphyAPI;
    }

    @NonNull
    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient
                .Builder()
                .build();
    }
}