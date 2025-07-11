package com.worldline.interview;

import java.math.BigDecimal;

public abstract class AbstractEngine {
	
    protected boolean running;
    protected int fuelLevel;
    protected FuelType requiredFuelType;
    protected FuelType fuelType;
    
    protected int batch;
    protected int batchCount;
    protected BigDecimal costPerBatch;
    protected int batchSize;
    
    public AbstractEngine(FuelType requiredFuelType) {
    	this.requiredFuelType = requiredFuelType;
        this.running = false;
        this.fuelLevel = 0;
    }
    
    protected abstract void configBatchSetting();
    
    protected abstract boolean isCorrectFuel();

    public void start() {
    	if (isCorrectFuel()) {
    		this.configBatchSetting();
    		this.fill(this.getFuelType(), this.fuelLevel);
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return requiredFuelType;
    }
	
}
