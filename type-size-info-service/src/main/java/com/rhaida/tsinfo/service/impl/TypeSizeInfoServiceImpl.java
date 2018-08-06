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
    public Map<String, Long> getTypeSizeInfo(List<UserFile> list) {
        Map<String, Long> typeSizeInfo = new HashMap<>();
        typeSizeInfo.put("unknown", 0L);
        for (String extension: Utils.extensions) {
            Long size = 0L;
            typeSizeInfo.put(extension, size);
            for (UserFile userFile : list) {
                if (userFile.getExtension().equalsIgnoreCase(extension)) {
                    typeSizeInfo.put(extension, typeSizeInfo.get(extension) + userFile.getSize());
                }
                typeSizeInfo.put("unknown", typeSizeInfo.get(extension) + userFile.getSize());
            }
            typeSizeInfo.put(extension, typeSizeInfo.get(extension)/1_000_000);
        }
        return typeSizeInfo;
    }
}
