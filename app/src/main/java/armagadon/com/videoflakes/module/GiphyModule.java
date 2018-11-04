package armagadon.com.videoflakes.module;

import javax.inject.Singleton;

import armagadon.com.videoflakes.GiphyRepository;
import armagadon.com.videoflakes.model.GiphyRepoImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class GiphyModule {

    @Provides
    @Singleton
    public GiphyRepository providesGiphyRepository(GiphyRepoImpl giphyRepository){
        return giphyRepository;
    }
}
