package armagadon.com.videoflakes.model;

import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  GiphyService {

    GifVideo gifVideo = new GifVideo();

  /*  public static void GifSearch(GPHApiClient client){
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
                            String id = gif.getId();
                            String thumbnailUrl = gif.getImages().getFixedHeight().getGifUrl();
                            gifVideo.setId(id);
                            gifVideo.setMp4Url(Mp4Url);
                            gifVideo.setThumbnailUrl(thumbnailUrl);
                            Observable.just(gifVideo);
                            Log.v("giphy", gif.getId());
                            Log.v("giphy", Mp4Url);
                        }
                    } else {
                        Log.e("giphy error", "No results found");
                    }
                }
            }
        });
    }*/




    @GET()
     Observable<GiphyResponse> searchGiphy(@Query("q") String SearchCode,
                                        @Query("limit") int limit,
                                        @Query("offset") int offset);
}
