package com.czm.gatewaystarter.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelFlowBlockHandler {

    public static String blockHandler(BlockException bex) {
        return String.format("CustomMessage: Oops! This api server has been blocked by Sentinel 1.8.3! Please try Again!!\nCreate by AmosCui!");
    }

}
