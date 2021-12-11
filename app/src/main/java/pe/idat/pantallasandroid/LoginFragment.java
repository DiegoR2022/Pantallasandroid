package pe.idat.pantallasandroid;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        TextInputLayout nombreInputLayout = view.findViewById(R.id.nombre_input_layout);
        TextInputEditText nombreEditText = view.findViewById(R.id.nombre_edit_text);
        TextInputLayout contraInputLayout = view.findViewById(R.id.contra_input_layout);
        TextInputEditText contraEditText = view.findViewById(R.id.contra_edit_text);
        MaterialButton botonIngresar = view.findViewById(R.id.boton_ingresar);

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNombreValid(nombreEditText.getText())) {
                    nombreInputLayout.setError("El nombre de usuario debe tener más de 3 caracteres");
                }

                if (!isContraValid(contraEditText.getText())) {
                    contraInputLayout.setError("La contraseña debe tener más de 6 caracteres");
                }

                if (isNombreValid(nombreEditText.getText()) && isContraValid(contraEditText.getText())) {
                    nombreInputLayout.setError(null);
                    contraInputLayout.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new HomeFragment(), false);
                }
            }
        });

        nombreEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (isNombreValid(nombreEditText.getText())) {
                    nombreInputLayout.setError(null);
                }
                return false;
            }
        });

        contraEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (isContraValid(contraEditText.getText())) {
                    contraInputLayout.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    private boolean isNombreValid(Editable nombre) {
        return nombre != null && nombre.length() >= 3;
    }

    private boolean isContraValid(Editable contra) {
        return contra != null && contra.length() >= 6;
    }
}
