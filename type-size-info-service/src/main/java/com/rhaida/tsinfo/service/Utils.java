package com.rhaida.tsinfo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
public class Utils {
    public static final Set<String> extensions = new HashSet<>(
            Arrays.asList("jpg", "jpeg", "gif", "img", "bmp", "txt", "doc", "docx", "rtf", "xml", "xls", "xlsx", "csv"));
}
