package armagadon.com.videoflakes.Module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import armagadon.com.videoflakes.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper()
    {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return    new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(ApiHelper.class);


    }
}
