package com.vdcompany.adminSmartbox.jni;

public class BrailleJNI {

    static{
        System.loadLibrary( "BrailleJavaInterCaller");
    }

    public native void hello();
}
