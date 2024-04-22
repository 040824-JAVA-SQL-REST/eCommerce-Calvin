package com.Revature.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class AbstractFileHandler {
    private String dbPath;
    private String resourcePath;


    public AbstractFileHandler(String dbPath, String resourcePath) {
        this.dbPath = dbPath;
        this.resourcePath = resourcePath;
    }
    
    protected BufferedWriter getWriter() throws IOException {
        return new BufferedWriter(new FileWriter(resourcePath, true));
    }

    protected BufferedReader getReader() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("db/user.txt");
        InputStreamReader isr = new InputStreamReader(is); 
        return new BufferedReader(isr);
    }
}
