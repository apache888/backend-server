package com.rhaida.tsinfo.service;

import com.rhaida.tsinfo.dto.UserFile;

import java.util.List;
import java.util.Map;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
public interface TypeSizeInfoService {

    Map<String, String> getTypeSizeInfo(List<UserFile> list);

}
