package com.eternal_call.projectForMediaSoft.DataBase;
import java.io.IOException;


public class ConnectionToDataBase {
    public ConnectionToDataBase() throws IOException {
    }

    private final String driverName = "com.mysql.jdbc.Driver"; // Определение имени драйвера
    ReaderCfg readerCfg = new ReaderCfg();
    private  String url2 = readerCfg.inPutUrl();
    private  String log2 = readerCfg.inPutLogin();
    private  String pas2 = readerCfg.inPutPassword();

    public String getdDriverName (){
        return driverName;
    }

    public String getdUrl (){
        return url2;
    }

    public String getdLogin (){
        return log2;
    }

    public String getPassword (){
        return pas2;
    }
}
