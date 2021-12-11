package pe.idat.pantallasandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.idat.pantallasandroid.network.ContactEntry;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        List<ContactEntry> contactEntryList = ContactEntry.initContactEntryList(getResources());
        TextView homeTituloTextview = view.findViewById(R.id.home_titulo);
        homeTituloTextview.setText("Contactos " + contactEntryList.size());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ContactCardRecyclerViewAdapter(contactEntryList));
        int largePadding = getResources().getDimensionPixelSize(R.dimen.contact_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.contact_grid_spacing_small);
        recyclerView.addItemDecoration(new ContactGridItemDecoration(largePadding, smallPadding));

        return view;
    }
}
