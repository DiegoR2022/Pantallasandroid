package pe.idat.pantallasandroid;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class ContactCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView conctactImage;
    public TextView nombreTextView;
    public TextView correoTextView;
    public TextView telefonoTextView;

    public ContactCardViewHolder(@NonNull View itemView) {
        super(itemView);
        conctactImage = itemView.findViewById(R.id.contact_image);
        nombreTextView = itemView.findViewById(R.id.nombre_text);
        correoTextView = itemView.findViewById(R.id.correo_text);
        telefonoTextView = itemView.findViewById(R.id.telefono_text);
    }
}
