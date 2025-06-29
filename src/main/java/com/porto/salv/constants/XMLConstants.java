package com.porto.salv.constants;

import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class XMLConstants {

    public static final DateTimeFormatter LOCALDATE_DD_MM_YYYY_HH_MM_SS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

}