package com.example.trabajo01_multimedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajo01_multimedia.modelos.Chinpokomon;

import java.util.List;

public class listaChinpoAdapter extends RecyclerView.Adapter<ViewHolderChinpokomon> {

    Context context;
    List<Chinpokomon> listaChinpokomon;

    public listaChinpoAdapter(Context context, List<Chinpokomon> listaChinpokomon) {
        this.context = context;
        this.listaChinpokomon = listaChinpokomon;
    }




    @NonNull
    @Override
    public ViewHolderChinpokomon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderChinpokomon(LayoutInflater.from(context).inflate(R.layout.item_chinpokomon,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChinpokomon holder, int position) {
        holder.codigoView.setText(listaChinpokomon.get(position).getCodigo());
        holder.nombreView.setText(listaChinpokomon.get(position).getNombre());
        holder.nivelView.setText(listaChinpokomon.get(position).getNivel());
        holder.tipoView.setText(listaChinpokomon.get(position).getTipo());
        holder.movimientoView.setText(listaChinpokomon.get(position).getMovimiento());
        holder.imageView.setImageResource(listaChinpokomon.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return listaChinpokomon.size();
    }
}
