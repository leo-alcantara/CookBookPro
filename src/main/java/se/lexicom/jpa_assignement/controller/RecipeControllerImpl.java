package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.dto.RecipeFormDto;
import se.lexicom.jpa_assignement.service.RecipeServiceImpl;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin("*")
public class RecipeControllerImpl implements RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    @Autowired
    public RecipeControllerImpl(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    private final List<String> SEARCHTYPES = Arrays.asList(
            "all", "recipe-name", "ingredient-name", "category-name", "recipe-categories"
    );

    @Override
    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody @Valid RecipeFormDto formDto) {
        RecipeDto result = recipeServiceImpl.createRecipe(formDto);
        System.out.println("result =11111111  " + result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer recipeId) {
        return ResponseEntity.ok(recipeServiceImpl.findById(recipeId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeDto>> find(
            @RequestParam(name = "search", defaultValue = "all") String search,
            @RequestParam(name = "values", defaultValue = "all") String[] values) {
                
        List<RecipeDto> recipeDtoList;

        if ("all".equals(search)) {
            recipeDtoList = recipeServiceImpl.findAll();
        } else if ("recipe-name".equals(search)) {
            String recipeName = values[0];
            recipeDtoList = recipeServiceImpl.findRecipeByNameContainsIgnoreCase(recipeName);
        } else if ("ingredient-name".equals(search)) {
            String ingredientName = values[0];
            recipeDtoList = recipeServiceImpl.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
        } else if ("category-name".equals(search)) {
            String categoryName = values[0];
            recipeDtoList = recipeServiceImpl.findRecipeByCategoryContainsIgnoreCase(categoryName);
            //Need to review this method implementation
        } else if ("recipe-categories".equals(search)) {
            List<String> recipeCategories = Arrays.asList(values[0], values[1], values[2]);
            recipeDtoList = recipeServiceImpl.findRecipeSeveralCategories(recipeCategories);
        } else {
            throw new IllegalArgumentException("Invalid search type");
        }
        return ResponseEntity.ok(recipeDtoList);
    }

    @Override
    @PutMapping
    public ResponseEntity<RecipeDto> update(@RequestBody @Valid RecipeFormDto formDto) {
        return ResponseEntity.ok().body(recipeServiceImpl.update(formDto));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer recipeId) {
        recipeServiceImpl.delete(recipeId);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(path = "/clear")
    public ResponseEntity<Void> clear() {
        recipeServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

}
