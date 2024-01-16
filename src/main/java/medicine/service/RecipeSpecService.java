package medicine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.WaterMount;
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

    /**
     * 레시피 상세 조회
     * */
    public List<RecipeSpec> findRecipeSpec(Long recipeId) {
        return recipeSpecRepository.findById(recipeId);
    }


    /**
     *  약재 계산 함수
     *
     *   20첩 = 1제
     *   1제를 만들기 위해서는 약재에 20 을 곱해야함.
     *   파우치봉의 개수는 1제에 50개로 고정
     *   물의양 =  {파우치(봉)의 개수 * 120(혹은110)} + (약재의 총 량 * 1.2) + 1000
     *
     *   ordermount = 제의 개수 (샘플로 작성할 경우 1첩을 기준)
     *
     * */
    public double getWaterMount(WaterMount waterMount) {

        List<RecipeSpec> recipeSpecs = findRecipeSpec(waterMount.getRecipeId());
        int defaultPouch = waterMount.getSetPouch();
        long orderMount = waterMount.getOrderMount();

        double totalWaterMount = 0.0;
        double totalMaterialMount = 0.0;

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

    /**
     *  ginger 가 재료에 포함되어 있을 경우 계산식이 변경
     * */
    public boolean isGinger(long materialId) {

        return materialId == 5L ? true : false;
    }

}