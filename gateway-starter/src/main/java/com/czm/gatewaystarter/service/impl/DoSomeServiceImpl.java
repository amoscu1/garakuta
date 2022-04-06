package com.czm.gatewaystarter.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.czm.gatewaystarter.config.SentinelFallBackHandler;
import com.czm.gatewaystarter.config.SentinelFlowBlockHandler;
import com.czm.gatewaystarter.service.IDoSomeService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DoSomeServiceImpl implements IDoSomeService {

//    @SentinelResource(value = "begin", blockHandler = "blockHandler")
    @Override
    public String doSome() {
        int random = new Random().nextInt() * 254;
        return String.format("JobNo.%d has Done !!!", random);
    }

    @SentinelResource(value = "fallback", blockHandlerClass = SentinelFlowBlockHandler.class, blockHandler = "blockHandler",
            fallbackClass = SentinelFallBackHandler.class, fallback = "fallbackHandler")
    @Override
    public void doAnother() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    public String blockHandler(BlockException bex) {
        return String.format("CustomMessage: Oops! This api server has been blocked by Sentinel 1.8.3! Please try Again!!\nCreate by AmosCui!");
    }
}
