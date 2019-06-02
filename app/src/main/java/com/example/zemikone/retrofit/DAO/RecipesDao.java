package com.example.zemikone.retrofit.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.zemikone.retrofit.Model.Recipes;

import java.util.List;

@Dao
public interface RecipesDao {

    @Insert
    void insertSingleRecipes(Recipes recipes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleRecipes(List<Recipes> recipesList);

    @Query("SELECT * FROM Recipes WHERE recipe_id = :id")
    Recipes getRecipeById (int id);

    @Query("SELECT * FROM Recipes")
    List<Recipes> getRecipes ();

    @Update
    void updateRecipes(Recipes recipes);

    @Delete
    void deleteRecipes(Recipes recipes);

    @Query("DELETE FROM Recipes")
    void deleteAllRecipes();

}
