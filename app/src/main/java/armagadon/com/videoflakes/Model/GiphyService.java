package armagadon.com.videoflakes.Model;

import android.util.Log;

import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.LangType;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ListMediaResponse;

import java.util.List;
import rx.Observable;

import armagadon.com.videoflakes.Model.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  GiphyService {

/*
    public static void GifSearch(GPHApiClient client){
        /// Gif Search
        Log.v("giphy", "Entered");
        client.search("cats", MediaType.gif, 25, 0, RatingType.g, LangType.english, new CompletionHandler<ListMediaResponse>() {
            @Override
            public void onComplete(ListMediaResponse result, Throwable e) {
                if (result == null) {
                    // Do what you want to do with the error
                    Log.v("giphy", "ERROR value NULL");
                } else {
                    if (result.getData() != null) {
                        for (Media gif : result.getData()) {
                            String Mp4Url = gif.getImages().getOriginal().getMp4Url();
                            Log.v("giphy", gif.getId());
                            Log.v("giphy", Mp4Url);
                        }
                    } else {
                        Log.e("giphy error", "No results found");
                    }
                }
            }
        });
    }

*/


    @GET("data")
     Observable<Response<List<GifVideo>>> getItems(@Query("q") String SearchCode,
                                                           @Query("limit") int limit,
                                                           @Query("offset") int offset,
                                                           @Query("rating") char rating,
                                                           @Query("lang") String lang);
}
