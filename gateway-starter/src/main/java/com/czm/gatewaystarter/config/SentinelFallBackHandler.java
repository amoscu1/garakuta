package com.czm.gatewaystarter.config;

public class SentinelFallBackHandler {

    public static String fallbackHandler() {
        return String.format("CustomMessage: Attention!! This API Server has been protect by Sentinel 1.8.3 from Dos Attack!! Please " +
                "Try Again Later!\nCreate by AmosCui");
    }

}
