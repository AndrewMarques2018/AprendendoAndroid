package com.andrewmarques.android.appnavigationdrawer2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.andrewmarques.android.appnavigationdrawer2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal,
                R.id.nav_servicos,
                R.id.nav_clientes,
                R.id.nav_contato,
                R.id.nav_sobre
                )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail (){
        //String celular = "tel:5589999999";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));

        //String imagem = "https://s3.observador.pt/wp-content/uploads/2018/04/30162722/peniche1.jpg";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));

        //String mapa = "https://www.google.com.br/maps?q=beach+park&sxsrf=ALiCzsYNCcD4gEF-eRr1tMEZjPuNGP94Ag:1662993072278&iflsig=AJiK0e8AAAAAYx9QwMeuhMqs9t6Lktt1Q7HhoB2-_ZeK&gs_lcp=Cgdnd3Mtd2l6EAEYADIECCMQJzIICAAQgAQQsQMyCwguEIAEEMcBEK8BMgsIABCABBCxAxCDATIFCAAQgAQyCwguEIAEEMcBEK8BMggIABCABBCxAzILCC4QgAQQsQMQgwEyBQgAEIAEMgUIABCABDoRCC4QgAQQsQMQgwEQxwEQ0QM6CAguELEDEIMBOggIABCxAxCDAToOCC4QgAQQsQMQgwEQ1AI6CAguEIAEELEDOgsILhCABBCxAxDUAlAAWLoJYPgWaABwAHgAgAGrAYgBvgSSAQMwLjSYAQCgAQE&um=1&ie=UTF-8&sa=X&ved=2ahUKEwi42Pv8u4_6AhXlpZUCHU7cDFgQ_AUoAXoECAIQAw";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapa));

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra( Intent.EXTRA_EMAIL, new String[] {"atendimento@atmconsultoria.com.br"});
        intent.putExtra( Intent.EXTRA_SUBJECT, "contato pelo app");
        intent.putExtra( Intent.EXTRA_TEXT, "Menssagem automatica");
        intent.setType("message/rfc822"); // mais tipos em mime types
        //intent.setType("text/plain");
        //intent.setType("image/png");
        //intent.setType("application/pdf");
        startActivity(Intent.createChooser(intent, "compartilhar"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}