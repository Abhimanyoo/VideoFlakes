package armagadon.com.videoflakes;

import java.util.List;

import io.reactivex.Observable;

public interface GiphyRepository {


    /**
     *
     * Get an {@link Observable} which will emit a list of GifVideo's urls.
     * @param query searched query
     * @param limit response items limit
     * @param offset page to load
     *
     */
    Observable<List<String>> searchGiphies(String query, int limit, int offset);
}
