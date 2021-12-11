package pe.idat.pantallasandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.idat.pantallasandroid.network.ContactEntry;
import pe.idat.pantallasandroid.network.ImageRequester;

public class ContactCardRecyclerViewAdapter extends RecyclerView.Adapter<ContactCardViewHolder> {

    private final List<ContactEntry> contactEntryList;

    public ContactCardRecyclerViewAdapter(List<ContactEntry> contactEntryList) {
        this.contactEntryList = contactEntryList;
    }

    @NonNull
    @Override
    public ContactCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new ContactCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactCardViewHolder holder, int position) {
        if (contactEntryList != null && position < contactEntryList.size()) {
            ContactEntry contactEntry = contactEntryList.get(position);
            ImageRequester.getInstance().setImageFromUrl(holder.conctactImage, contactEntry.image);
            holder.nombreTextView.setText(contactEntry.name);
            holder.correoTextView.setText(contactEntry.email);
            holder.telefonoTextView.setText(contactEntry.phone);
        }
    }

    @Override
    public int getItemCount() {
        return contactEntryList.size();
    }
}
