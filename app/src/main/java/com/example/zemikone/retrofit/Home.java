package com.example.zemikone.retrofit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zemikone.retrofit.DB.App;
import com.example.zemikone.retrofit.DB.Db;
import com.example.zemikone.retrofit.Interface.DataResultInterface;
import com.example.zemikone.retrofit.Model.ApiResponse;
import com.example.zemikone.retrofit.Model.Recipes;
import com.example.zemikone.retrofit.Repository.Repository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity implements DataResultInterface {

    Db db;
    App app;
    Repository repository;
    String names;
    DataResultInterface dataResultInterface;

    @BindView(R.id.textRespone)
    EditText responseText;
    @BindView(R.id.textIngredients)
    EditText ingredientText;
    @BindView(R.id.buttonDownlaod)
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        dataResultInterface = this;

        app = new App();
        db=app.get().getDb();
        repository=new Repository();
        repository.setContext(this);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                names = ingredientText.getText().toString();
                repository.getRecipesList(dataResultInterface,names);
            }
        });
    }

    @Override
    public void dataReceived(ApiResponse apiResponse) {
        if(apiResponse!=null) {
            if (apiResponse.getRecipes() != null) {

                repository.deleteRecipes();
                repository.insertMultipleRecipes(apiResponse.recipes);
                String name="";
               List<Recipes> recipes = repository.getRecipes();
               if(recipes!=null){
                   if(recipes.size()>0){
                       for(int i=0; i<recipes.size();i++)
                       {
                           if(recipes.get(i)!=null) {
                               if(recipes.get(i).getTitle()!=null) {

                                   name = name.concat(recipes.get(i).getTitle());
                               }
                           }
                       }
                   }
               }
                responseText.setText(String.valueOf(name));
            }
        }
    }

    @Override
    public void dataFailed() {
        Toast.makeText(getApplicationContext(),"Download Failed",Toast.LENGTH_LONG);
    }
}
