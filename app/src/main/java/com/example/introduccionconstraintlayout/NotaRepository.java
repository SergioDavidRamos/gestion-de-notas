package com.example.introduccionconstraintlayout;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.introduccionconstraintlayout.db.NotaRoomDatabase;
import com.example.introduccionconstraintlayout.db.dao.NotaDao;
import com.example.introduccionconstraintlayout.db.entity.NotaEntity;

import java.util.List;

public class NotaRepository {
    private NotaDao notaDao;
    private LiveData<List<NotaEntity>> allNotas;
    private LiveData<List<NotaEntity>> allNotasFavoritas;

    public NotaRepository(Application application){
        NotaRoomDatabase db = NotaRoomDatabase.getDatabase(application);
        notaDao = db.notaDao();
        allNotas = notaDao.getAll();
        allNotasFavoritas = notaDao.getAllFavorite();
    }

    public LiveData <List<NotaEntity>>getAll(){ return allNotas;}
    public LiveData <List<NotaEntity>>getAllFas(){ return allNotasFavoritas;}

    public void insert(NotaEntity nota){
        new insertAsyncTask(notaDao).execute(nota);
    }

    private static class insertAsyncTask extends AsyncTask<NotaEntity, Void, Void>{
        private NotaDao notaDaoAsynctask;

        insertAsyncTask(NotaDao dao){
            notaDaoAsynctask = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsynctask.insert(notaEntities[0]);
            return null;
        }
    }

    public void update (NotaEntity nota){new updateAsyncTask(notaDao).execute(nota); }


    private static class updateAsyncTask extends AsyncTask<NotaEntity, Void, Void>{
        private NotaDao notaDaoAsynctask;

        updateAsyncTask(NotaDao dao){
            notaDaoAsynctask = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsynctask.update(notaEntities[0]);
            return null;
        }
    }
}
