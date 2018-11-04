package armagadon.com.videoflakes.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;


public class GiphyMapper implements Function<GiphyResponse, List<String>>{

    @Inject public GiphyMapper() {}

    @Override
    public List<String> apply(GiphyResponse giphyResponse) throws Exception {
        List<GifVideo> giphyList = giphyResponse.getGiphyList();
        List<String> urlsList = new ArrayList<>();

        for (GifVideo giphy : giphyList) {
            if (giphy.getImages() != null &&
                    giphy.getImages().getOriginalGiphy() != null &&
                    giphy.getImages().getOriginalGiphy().getUrl() != null) {

                urlsList.add(giphy
                        .getImages()
                        .getOriginalGiphy()
                        .getUrl()
                );
            }
        }

        return urlsList;
    }
}
