package medicine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.RecipeSearch;
import medicine.db.item.Recipe;
import medicine.repository.HomeRepository;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public List<Recipe> recipeSearch(RecipeSearch recipeSearch) {
        return homeRepository.findByData(recipeSearch);
    }
}
