package armagadon.com.videoflakes.model;

import java.util.List;

import javax.inject.Inject;

import armagadon.com.videoflakes.GiphyApplication;
import armagadon.com.videoflakes.GiphyRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GiphyRepoImpl implements GiphyRepository {

    private final GiphyMapper giphyMapper;

    @Inject
    GiphyRepoImpl(GiphyMapper giphyMapper){
        this.giphyMapper = giphyMapper;
    }

    @Override public Observable<List<String>> searchGiphies(String query, int limit, int offset) {

        return GiphyApplication
                .getApi()
                .searchGiphy(query, limit, offset)
                .map(giphyMapper)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
