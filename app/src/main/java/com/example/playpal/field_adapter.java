package com.example.playpal;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class field_adapter extends RecyclerView.Adapter<field_adapter.ViewHolder> {

    private List<field> fields;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView name, location;

        public ViewHolder(View view){
            super(view);
            picture = view.findViewById(R.id.field_picture);
            name = view.findViewById(R.id.field_name);
            location = view.findViewById(R.id.field_location);
        }
    }

    public field_adapter(List<field> fields){
        this.fields = fields;
    }

    @NonNull
    @Override
    public field_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.field_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull field_adapter.ViewHolder holder, int position) {
        field field = fields.get(position);
        holder.picture.setImageBitmap(BitmapFactory.decodeByteArray(field.getFieldPicture(), 0, field.getFieldPicture().length));
        holder.name.setText(field.getFieldName());
        holder.location.setText(field.getFieldLocation());
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }
}