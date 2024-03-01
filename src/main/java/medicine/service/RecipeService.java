package medicine.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.Recipe;
import medicine.repository.impl.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RecipeService {

    private final RecipeJPARepository recipeJPARepository;

    public List<Recipe> findRecipes() {
        return recipeJPARepository.findAll();
    }
    public void deleteData(Long recipeId) {
        recipeJPARepository.deleteById(recipeId);
    }

}
