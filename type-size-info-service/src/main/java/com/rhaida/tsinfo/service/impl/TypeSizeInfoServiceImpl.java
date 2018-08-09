package com.rhaida.tsinfo.service.impl;

import com.rhaida.tsinfo.dto.TypeSizeInfoDto;
import com.rhaida.tsinfo.dto.UserFile;
import com.rhaida.tsinfo.service.TypeSizeInfoService;
import com.rhaida.tsinfo.service.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                dto.setSize(size / 1000f + "KB");
                typeSizeInfo.add(dto);
            } else {
                dto.setType(entry.getKey());
                dto.setSize(size / 1000000f + "MB");
            }
        }
        return typeSizeInfo;
    }
}
