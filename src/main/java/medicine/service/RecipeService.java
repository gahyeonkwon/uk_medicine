package medicine.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.Recipe;
import medicine.repository.RecipeRepository;
import medicine.repository.RecipeSpecRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeSpecRepository recipeSpecRepository;

    public List<Recipe> findRecipes() {
        return recipeRepository.findAll();
    }






}
