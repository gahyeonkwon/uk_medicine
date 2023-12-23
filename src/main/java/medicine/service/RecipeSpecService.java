package medicine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.RecipeSpec;
import medicine.repository.RecipeRepository;
import medicine.repository.RecipeSpecRepository;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RecipeSpecService {

    private final RecipeSpecRepository recipeSpecRepository;
    private final double defaultPouch = 50;

    public List<RecipeSpec> findRecipeSpec() {

        return recipeSpecRepository.findAll();
    }


    public double getWaterMount(long specId, long orderMount) {

        List<RecipeSpec> recipeSpecs = findRecipeSpec();
        double totalWaterMount = 0.0;
        double totalMaterialMount = 0.0;

        // 20첩 = 1제
        // 1제를 만들기 위해서는 약재에 20 을 곱해야함.
        // 파우치봉의 개수는 1제에 50개로 고정
        // 물의양 =  {파우치(봉)의 개수 * 120(혹은110)} + (약재의 총 량 * 1.2) + 1000

        // ordermount 는 제의 개수를 의미하며 샘플로 작성할 경우 1첩을 기준으로한다

        for (RecipeSpec rs : recipeSpecs) {

            double materialMount = 0.0;

            if(isGinger(rs.getMaterial().getId())) {
                log.info("isGinger");
                materialMount = (rs.getMaterialMount() * 20)/3 * orderMount ;
            } else {
                materialMount = rs.getMaterialMount() * 20 * orderMount ;
            }
            totalMaterialMount += materialMount;
        }

        double totalPouch = defaultPouch * orderMount;
        totalWaterMount = totalPouch * 120 + totalMaterialMount * 1.2 + 1000;

        log.info(" totalWaterMount ==> " + totalWaterMount);

        return totalWaterMount;
    }

    public boolean isGinger(long materialId) {

        return materialId == 5L ? true : false;
    }

}