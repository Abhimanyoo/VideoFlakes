package armagadon.com.videoflakes.View;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import armagadon.com.videoflakes.model.GifVideo;
import armagadon.com.videoflakes.R;
import armagadon.com.videoflakes.databinding.ItemBinding;
import armagadon.com.videoflakes.viewModel.GifVideoViewModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> urls;
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.urls = Collections.emptyList();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new ViewHolder(itemBinding);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.binding.setGiphyViewModel(new GifVideoViewModel(urls.get(i)));
        holder.binding.executePendingBindings();
    }

    @Override
    public void onViewRecycled(final ViewHolder holder) {
        super.onViewRecycled(holder);
        ImageView imageViewGif = holder.binding.imageViewGif;
        Glide.with(context).clear(imageViewGif);
        imageViewGif.setImageDrawable(null);

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public void setUrls(List<String> urls) {
        if (this.urls.isEmpty()) {
            this.urls = urls;
        } else {
            this.urls.addAll(urls);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        this.urls.clear();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}