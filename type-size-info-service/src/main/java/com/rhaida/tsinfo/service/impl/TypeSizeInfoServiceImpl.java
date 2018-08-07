package com.rhaida.tsinfo.service.impl;

import com.rhaida.tsinfo.dto.UserFile;
import com.rhaida.tsinfo.service.TypeSizeInfoService;
import com.rhaida.tsinfo.service.Utils;
import org.springframework.stereotype.Service;

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
    public Map<String, String> getTypeSizeInfo(List<UserFile> list) {
        Map<String, Long> typeSizes = new HashMap<>();
        Map<String, String> typeSizeInfo = new HashMap<>();
        typeSizes.put("unknown", 0L);
        for (UserFile userFile : list) {
            String extension = userFile.getExtension();
            if (Utils.extensions.contains(extension)) {
                if (typeSizes.get(extension) == null) {
                    typeSizes.put(extension, userFile.getSize());
                }else {
                    typeSizes.put(extension, typeSizes.get(extension) + userFile.getSize());
                }
            }else {
                typeSizes.put("unknown", typeSizes.get("unknown") + userFile.getSize());
            }
        }
        for (Map.Entry<String, Long> entry : typeSizes.entrySet()) {

            Long size = entry.getValue();
            if (size < 1000) {
                typeSizeInfo.put(entry.getKey(), size + "Byte");
            } else
            if (size < 1000000) {
                typeSizeInfo.put(entry.getKey(), size / 1000f + "KB");
            } else{
                typeSizeInfo.put(entry.getKey(), size / 1000000f + "MB");
            }
        }
        return typeSizeInfo;
    }
}
