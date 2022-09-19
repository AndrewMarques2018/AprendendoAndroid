package com.andrewmarques.android.applistadetarefas3.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.andrewmarques.android.applistadetarefas3.R;
import com.andrewmarques.android.applistadetarefas3.helper.TarefaDAO;
import com.andrewmarques.android.applistadetarefas3.model.Tarefa;

public class AdicionarTarefaAcitivity extends AppCompatActivity {

    private TextView editTarefa;
    private Tarefa tarefaAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.txtTarefa);

        //recuperar tarefa, caso seja edicao
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        // configurar caixa de texto
        if (tarefaAtual != null){
            editTarefa.setText( tarefaAtual.getNomeTarefa() );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_salvar:
                // Executar uma acao para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                String nomeTarefa = editTarefa.getText().toString();
                if(!nomeTarefa.isEmpty()){
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    tarefaDAO.salvar(tarefa);
                    finish();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}