package armagadon.com.videoflakes.component;

import javax.inject.Singleton;

import armagadon.com.videoflakes.module.GiphyModule;
import armagadon.com.videoflakes.viewModel.MainViewModel;
import dagger.Component;

@Singleton
@Component(modules = {GiphyModule.class})
public interface ApplicationComponent {
    void inject (MainViewModel viewModel);

}
