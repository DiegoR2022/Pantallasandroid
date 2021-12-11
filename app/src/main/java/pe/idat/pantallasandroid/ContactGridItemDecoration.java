package pe.idat.pantallasandroid;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactGridItemDecoration extends RecyclerView.ItemDecoration {

    private int padding;
    private int smallPadding;

    public ContactGridItemDecoration(int padding, int smallPadding) {
        this.padding = padding;
        this.smallPadding = smallPadding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = padding;
        outRect.right = smallPadding;
        outRect.bottom = padding;
        outRect.left = smallPadding;
    }
}
