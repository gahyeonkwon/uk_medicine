package medicine.service;

import lombok.RequiredArgsConstructor;
import medicine.db.form.AddMaterialDTO;
import medicine.repository.impl.MaterialJPARepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class InputDataValidator implements Validator {

    private final MaterialJPARepository materialJPARepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(AddMaterialDTO.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        AddMaterialDTO addMaterial = (AddMaterialDTO)object;
        if(materialJPARepository.existsByName(addMaterial.getMaterialName())){
            errors.rejectValue("materialName", "invalid.materialName",
                    new Object[]{addMaterial.getMaterialName()}, "이미 등록된 재료 입니다.");
        }

    }

}
