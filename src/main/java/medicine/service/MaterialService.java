package medicine.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.AddMaterialDTO;
import medicine.db.item.Material;
import medicine.repository.impl.MaterialJPARepository;
import medicine.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialJPARepository materialJPARepository;

    public List<Material> findMaterials() {
        return materialRepository.findAll();
    }


    public Material findMaterial(Long materialId) {
        return materialJPARepository.findById(materialId).get();
    }
    public Long insertData(AddMaterialDTO addMaterial) {
        return materialRepository.insert(addMaterial.toEntity());
    }

    public void deleteData(Long materialId) {
            materialJPARepository.deleteById(materialId);
    }

    public void updateData(AddMaterialDTO addMaterial) {
         Material material = new Material(addMaterial.getMaterialId(), addMaterial.getMaterialName());
         materialJPARepository.save(material);
    }

    public List<Material> setMaterialName(List<String> materials) {
        List<Material> allById = materialJPARepository.findAllById(materials.stream().map(Long::parseLong).collect(Collectors.toList()));
        return allById;
    }
}
