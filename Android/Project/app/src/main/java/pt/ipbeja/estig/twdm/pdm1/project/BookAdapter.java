package pt.ipbeja.estig.twdm.pdm1.project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private static final String TAG = "BookAdapter";

    private List<Book> bookList;
    private Context context;

    public BookAdapter(Context context, List<Book> bookList){
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = this.bookList.get(position);
        TextView textViewName = holder.getTextViewName();
        textViewName.setText(book.getName());
        TextView textViewDesc = holder.getTextViewDesc();
        textViewDesc.setText(book.getDesc());
        ImageView imageView = holder.getImageViewCover();
        Glide.with(this.context).load(book.getCover()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }


    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewCover;
        private TextView textViewName;
        private TextView textViewDesc;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewCover = itemView.findViewById(R.id.imageView);
            this.textViewName = itemView.findViewById(R.id.bookName);
            this.textViewDesc = itemView.findViewById(R.id.bookDesc);
        }

        public ImageView getImageViewCover() {
            return imageViewCover;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDesc() {
            return textViewDesc;
        }
    }
}
