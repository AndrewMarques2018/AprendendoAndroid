package com.andrewmarques.android.applistadetarefas3.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.andrewmarques.android.applistadetarefas3.model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DBHelper db = new DBHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            escreve.insert(DBHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO", "Tarefa salva com sucesso" );
        }catch (Exception e){
            Log.i("INFO", "Erro ao salvar tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put( "nome" , tarefa.getNomeTarefa());

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.update(DBHelper.TABELA_TAREFAS, cv, "id=?", args);
            Log.i("INFO", "Tarefa atualizada com sucesso" );
        }catch (Exception e){
            Log.i("INFO", "Erro ao atualizar tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DBHelper.TABELA_TAREFAS + " ;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Tarefa t = new Tarefa();

            @SuppressLint("Range") Long id = c.getLong( c.getColumnIndex( "id") );
            @SuppressLint("Range") String nomeTarefa = c.getString( c.getColumnIndex("nome") );

            t.setId(id);
            t.setNomeTarefa(nomeTarefa);

            tarefas.add(t);
        }

        return tarefas;
    }
}
