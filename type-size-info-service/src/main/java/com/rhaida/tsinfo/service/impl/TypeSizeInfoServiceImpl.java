package com.rhaida.tsinfo.service.impl;

import com.rhaida.tsinfo.dto.TypeSizeInfoDto;
import com.rhaida.tsinfo.dto.UserFile;
import com.rhaida.tsinfo.service.TypeSizeInfoService;
import com.rhaida.tsinfo.service.Utils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@Service
public class TypeSizeInfoServiceImpl implements TypeSizeInfoService {

    @Override
    public List<TypeSizeInfoDto> getTypeSizeInfo(List<UserFile> list) {
        Map<String, Long> typeSizes = new HashMap<>();
        List<TypeSizeInfoDto> typeSizeInfo = new ArrayList<>();
        typeSizes.put("unknown", 0L);
        for (UserFile userFile : list) {
            String extension = userFile.getExtension();
            if (Utils.extensions.contains(extension)) {
                if (typeSizes.get(extension) == null) {
                    typeSizes.put(extension, userFile.getSize());
                } else {
                    typeSizes.put(extension, typeSizes.get(extension) + userFile.getSize());
                }
            } else {
                typeSizes.put("unknown", typeSizes.get("unknown") + userFile.getSize());
            }
        }
        for (Map.Entry<String, Long> entry : typeSizes.entrySet()) {

            TypeSizeInfoDto dto = new TypeSizeInfoDto();
            Long size = entry.getValue();
            if (size < 1000) {
                dto.setType(entry.getKey());
                dto.setSize(size + "Byte");
                typeSizeInfo.add(dto);
            } else if (size < 1000000) {
                dto.setType(entry.getKey());
                dto.setSize(String.format("%.2fKB", size / 1000f));
                typeSizeInfo.add(dto);
            } else {
                dto.setType(entry.getKey());
                dto.setSize(String.format("%.2fMB", size / 1000000f));
                typeSizeInfo.add(dto);
            }
        }
        typeSizeInfo.sort(Comparator.comparing(TypeSizeInfoDto::getType));
        return typeSizeInfo;
    }
}
