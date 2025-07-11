package com.worldline.interview;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WidgetMachine {
	
    private AbstractEngine engine;
    
    public WidgetMachine(AbstractEngine engine) {
    	if(engine==null) {
    		throw new RuntimeException("No Engine is provided");
    	}
    	this.engine = engine;
    }

    public BigDecimal produceWidgets(int quantity) {
        engine.start();
        BigDecimal cost = BigDecimal.ZERO;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal produce(int quantity) {
        while (engine.batch < quantity) {
        	engine.batch = engine.batch + engine.batchSize;
        	engine.batchCount++;
        }
        return engine.costPerBatch.multiply(new BigDecimal(engine.batchCount)).setScale(2, RoundingMode.HALF_UP);
    }


}
