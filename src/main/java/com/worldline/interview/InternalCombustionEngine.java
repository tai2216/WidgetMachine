package com.worldline.interview;

import java.math.BigDecimal;

public class InternalCombustionEngine extends AbstractEngine{
	
    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
    }

	@Override
	protected boolean isCorrectFuel() {
		return requiredFuelType.equals(FuelType.DIESEL)||requiredFuelType.equals(FuelType.PETROL);
	}

	@Override
	protected void configBatchSetting() {
		this.batchSize = 8;
        if (this.getFuelType() == FuelType.PETROL) {
        	this.costPerBatch = new BigDecimal(9);
        } else if (this.getFuelType() == FuelType.DIESEL) {
        	this.costPerBatch = new BigDecimal(12);
        }else {
        	throw new IllegalArgumentException("Only PETROL or DIESEL is allowed");
        }
		
	}
    
}
