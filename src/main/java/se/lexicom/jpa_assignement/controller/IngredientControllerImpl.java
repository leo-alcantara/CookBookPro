package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.dto.IngredientFormDto;
import se.lexicom.jpa_assignement.entity.Ingredient;
import se.lexicom.jpa_assignement.service.IngredientServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/ingredients")
@CrossOrigin("*")
public class IngredientControllerImpl implements IngredientController {

    //Initiate Var
    private final IngredientServiceImpl ingredientServiceImpl;

    //Controller
    @Autowired
    public IngredientControllerImpl(IngredientServiceImpl ingredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl;
    }


    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody @Valid IngredientFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientServiceImpl.createIngredient(formDto));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<IngredientDto> findById(@PathVariable("id") Integer ingredientId) {
        return ResponseEntity.ok(ingredientServiceImpl.findById(ingredientId));
    }


    @GetMapping
    public ResponseEntity<List<IngredientDto>> findAll() {
        return ResponseEntity.ok(ingredientServiceImpl.findAll());
    }


    @PutMapping
    public ResponseEntity<IngredientDto> update(@RequestBody @Valid IngredientFormDto formDto) {
        return ResponseEntity.ok().body(ingredientServiceImpl.update(formDto));
    }


    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Ingredient ingredient) {
        ingredientServiceImpl.delete(ingredient);
        return ResponseEntity.ok().build();
    }

    //NOT SURE IF THIS IS RIGHT

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clear() {
        ingredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{ingredient-name}")
    public ResponseEntity<List<IngredientDto>> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        return ResponseEntity.ok(ingredientServiceImpl.findIngredientByNameContainsIgnoreCase(ingredientName));
    }


}
