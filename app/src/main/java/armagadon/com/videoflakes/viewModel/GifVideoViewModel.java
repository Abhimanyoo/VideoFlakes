package armagadon.com.videoflakes.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import armagadon.com.videoflakes.R;
import armagadon.com.videoflakes.model.GifVideo;
import armagadon.com.videoflakes.View.PlayVideo;

public class GifVideoViewModel extends ViewModel {

    private String url;

    public GifVideoViewModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().centerCrop().placeholder(R.color.colorAccent))
                .into(imageView);
    }

}