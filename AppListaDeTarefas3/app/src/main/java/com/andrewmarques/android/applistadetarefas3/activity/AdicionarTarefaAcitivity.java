package com.andrewmarques.android.applistadetarefas3.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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


                if(tarefaAtual != null){ // edicao

                    String nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){

                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa( nomeTarefa );
                        tarefa.setId(tarefaAtual.getId());

                        // atualizar banco de dados
                        if( tarefaDAO.atualizar(tarefa) ){
                            Toast.makeText(getApplicationContext(), "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }

                }else { // salvar
                    String nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if( tarefaDAO.salvar(tarefa) ){
                            Toast.makeText(getApplicationContext(), "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                }

                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}