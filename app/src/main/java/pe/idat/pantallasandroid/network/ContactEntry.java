package pe.idat.pantallasandroid.network;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import pe.idat.pantallasandroid.R;

public class ContactEntry {

    private static final String TAG = ContactEntry.class.getSimpleName();

    public String name;
    public String email;
    public String phone;
    public String status;
    public String image;
    public String icon;

    public ContactEntry(String name, String email, String phone, String status, String image, String icon) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.image = image;
        this.icon = icon;
    }

    public static List<ContactEntry> initContactEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.contacts);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo error al cerrar el input stream", exception);
            }
        }

        String jsonContactsString = writer.toString();
        Gson gson = new Gson();
        Type contactListType = new TypeToken<ArrayList<ContactEntry>>() {
        }.getType();

        return gson.fromJson(jsonContactsString, contactListType);
    }
}
