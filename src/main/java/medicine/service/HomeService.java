package medicine.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.RecipeSearchDTO;
import medicine.db.item.Recipe;
import medicine.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public List<Recipe> recipeSearch(RecipeSearchDTO recipeSearch) {
        return homeRepository.findByData(recipeSearch);
    }
}
