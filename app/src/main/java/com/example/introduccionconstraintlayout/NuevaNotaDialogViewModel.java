package com.example.introduccionconstraintlayout;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.introduccionconstraintlayout.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
   private LiveData<List<NotaEntity>> allNotas;
   private NotaRepository notaRepository;

   public NuevaNotaDialogViewModel(Application application){
       super(application);

       notaRepository = new NotaRepository(application);
       allNotas = notaRepository.getAll();
   }
   // El fragmento que necesita recibir la nueva lista de datos
    public LiveData <List<NotaEntity>> getAllNotas(){return allNotas;}

    // El fragmento que inserte una nueva nota, debera comunicarlo a este viewModel
    public void insertarNota(NotaEntity NuevanotaEntity){
       notaRepository.insert(NuevanotaEntity);
    }

    public void updateNota(NotaEntity notaActualizarEntity){
        notaRepository.update(notaActualizarEntity);
    }
}
