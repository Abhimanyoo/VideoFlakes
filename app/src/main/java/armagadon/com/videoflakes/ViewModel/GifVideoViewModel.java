package armagadon.com.videoflakes.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import armagadon.com.videoflakes.Model.GifVideo;
import armagadon.com.videoflakes.View.PlayVideo;

public class GifVideoViewModel extends BaseObservable {
    private GifVideo item;
    private Context context;
    public GifVideoViewModel(GifVideo item, Context context) {
        this.item = item;
        this.context=context;
    }

    private static final String TAG = "ItemViewModel";

    public String getId() {
        return item.getId();
    }

    public String VideoThumbnailUrl() {
        return item.getThumbnailUrl();
    }


    public String getVideoUrl() {
        return item.getMp4Url();
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);

    }

    public void onClick(String VideoUrl) {
        context.startActivity(PlayVideo.launchDetail(context, VideoUrl ));
        Log.d(TAG, "onClick: " + VideoUrl);


    }
    {
}
