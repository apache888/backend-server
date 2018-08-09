package com.rhaida.tsinfo.service;

import com.rhaida.tsinfo.dto.TypeSizeInfoDto;
import com.rhaida.tsinfo.dto.UserFile;

import java.util.List;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
public interface TypeSizeInfoService {

    List<TypeSizeInfoDto> getTypeSizeInfo(List<UserFile> list);

}
