package com.roger.cursomc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    public Date retornaDataFormatada(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date dataFormatada = sdf.parse(data);

        return dataFormatada;
    }
}
