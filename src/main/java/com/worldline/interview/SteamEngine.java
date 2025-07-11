package com.worldline.interview;

import java.math.BigDecimal;

public class SteamEngine extends AbstractEngine{

	public SteamEngine(FuelType requiredFuelType) {
		super(requiredFuelType);
	}

	@Override
	protected void configBatchSetting() {
		this.batchSize = 2;
        if (this.getFuelType() == FuelType.WOOD) {
        	this.costPerBatch = new BigDecimal(4.35);
        } else if (this.getFuelType() == FuelType.COAL) {
        	this.costPerBatch = new BigDecimal(5.65);
        }else {
        	throw new IllegalArgumentException("Only WOOD or COAL is allowed");
        }
		
	}

	@Override
	protected boolean isCorrectFuel() {
		return this.getFuelType()==FuelType.WOOD || this.getFuelType()==FuelType.COAL;
	}

}
