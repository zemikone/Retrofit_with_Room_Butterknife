package com.example.zemikone.retrofit.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.zemikone.retrofit.DAO.RecipesDao;
import com.example.zemikone.retrofit.Model.Recipes;

//Put Entities here
@Database(entities = {Recipes.class,},

        version = 1, exportSchema = false)
public abstract class Db extends RoomDatabase {

    public abstract RecipesDao recipesDao() ;
}
