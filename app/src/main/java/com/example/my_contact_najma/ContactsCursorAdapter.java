package com.example.my_contact_najma;

import static com.example.my_contact_najma.DBOpenHelper.CONTACT_NAME;
import static com.example.my_contact_najma.DBOpenHelper.CONTACT_PHONE;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(
                R.layout.contact_list_item,viewGroup,false );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int nameIndex = cursor.getColumnIndex(CONTACT_NAME);
        int phoneIndex = cursor.getColumnIndex(CONTACT_PHONE);

        // Handle invalid column index
        if (nameIndex == -1 || phoneIndex == -1) {
            // Log an error or handle this case appropriately
            throw new IllegalStateException("Column not found in the cursor");
        }

        String contactName = cursor.getString(nameIndex);
        String contactPhone = cursor.getString(phoneIndex);

        TextView nameTextView =  view.findViewById(R.id.nameTextView);
        TextView phoneTextView = view.findViewById(R.id.phoneTextView);

        nameTextView.setText(contactName);
        phoneTextView.setText(contactPhone);
    }
}