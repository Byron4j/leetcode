package org.byron4j.jvm;

import java.time.LocalDate;

public class _01_ExceptionBytecode {

    private int exec1(){
        int i;
        try {
            i =  exec2();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return -1;
        }
    }

    private int exec2() throws Exception{
        return 2;
    }
}
