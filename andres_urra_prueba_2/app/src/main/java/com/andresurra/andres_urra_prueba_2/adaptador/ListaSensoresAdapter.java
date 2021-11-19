package com.andresurra.andres_urra_prueba_2.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andresurra.andres_urra_prueba_2.R;
import com.andresurra.andres_urra_prueba_2.entidades.sensores;
import com.andresurra.andres_urra_prueba_2.verActivity;

import java.util.ArrayList;

public class ListaSensoresAdapter extends RecyclerView.Adapter<ListaSensoresAdapter.SensorViewHolder> {

    ArrayList<sensores> listasensores;

    public ListaSensoresAdapter(ArrayList<sensores> listasensores){
        this.listasensores = listasensores;
    }


    @NonNull
    @Override
    public ListaSensoresAdapter.SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_sensor, null, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaSensoresAdapter.SensorViewHolder holder, int position) {

        holder.viewNombre.setText(listasensores.get(position).getNombre());
        holder.viewValor.setText(listasensores.get(position).getValor());
        holder.viewFecha.setText(listasensores.get(position).getFecha());
        holder.viewObservacion.setText(listasensores.get(position).getObservacion());


    }

    @Override
    public int getItemCount() {

        return listasensores.size();


    }

    public class SensorViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewValor, viewFecha, viewObservacion;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewValor = itemView.findViewById(R.id.viewValor);
            viewFecha = itemView.findViewById(R.id.viewFecha);
            viewObservacion = itemView.findViewById(R.id.viewObservacion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, verActivity.class);
                    intent.putExtra("ID",listasensores.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });

        }
    }

}
