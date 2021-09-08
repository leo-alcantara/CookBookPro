package se.lexicom.jpa_assignement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }




    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getIngredient(), that.getIngredient()) && getMeasurement() == that.getMeasurement();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredient(), getAmount(), getMeasurement());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
