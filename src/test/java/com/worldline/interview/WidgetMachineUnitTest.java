package com.worldline.interview;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WidgetMachineUnitTest {
	
	private static int REQUESTED_WIDGETS_COUNT = 100;
	private static BigDecimal EXPECTED_ANSWER1 = new BigDecimal(117.00).setScale(2, RoundingMode.HALF_UP);
	private static BigDecimal EXPECTED_ANSWER2 = new BigDecimal(156.00).setScale(2, RoundingMode.HALF_UP);
	
	private static BigDecimal EXPECTED_ANSWER3 = new BigDecimal(282.50).setScale(2, RoundingMode.HALF_UP);
	private static BigDecimal EXPECTED_ANSWER4 = new BigDecimal(217.50).setScale(2, RoundingMode.HALF_UP);
	
	/*
	 * 以客戶要求數量100為例測試計算成本正確
	 * */
	@org.junit.Test
	public void confirmCalculateCostCorrect() {
		assertEquals(getCost(new InternalCombustionEngine(FuelType.PETROL)), EXPECTED_ANSWER1);
		assertEquals(getCost(new InternalCombustionEngine(FuelType.DIESEL)), EXPECTED_ANSWER2);
		assertEquals(getCost(new SteamEngine(FuelType.COAL)), EXPECTED_ANSWER3);
		assertEquals(getCost(new SteamEngine(FuelType.WOOD)), EXPECTED_ANSWER4);
	}
	
	/*
	 * 測試內燃引擎無法裝填木頭做為原料
	 * */
	@org.junit.Test(expected = IllegalStateException.class)
	public void confirmInternalCombustionEngineCannotBeFilledWithWood() {
		getCost(new InternalCombustionEngine(FuelType.WOOD));
	}
	
	/*
	 * 測試內燃引擎無法裝填煤炭做為原料
	 * */
	@org.junit.Test(expected = IllegalStateException.class)
	public void confirmInternalCombustionEngineCannotBeFilledWithCoal() {
		getCost(new InternalCombustionEngine(FuelType.COAL));
	}
	
	/*
	 * 測試蒸氣引擎無法裝填柴油做為原料
	 * */
	@org.junit.Test(expected = IllegalStateException.class)
	public void confirmSteamEngineCannotBeFilledWithDiesel() {
		getCost(new SteamEngine(FuelType.DIESEL));
	}
	/*
	 * 測試蒸氣引擎無法裝填汽油做為原料
	 * */
	@org.junit.Test(expected = IllegalStateException.class)
	public void confirmSteamEngineCannotBeFilledWithPetrol() {
		getCost(new SteamEngine(FuelType.PETROL));
	}
	
	/*
	 * 測試引擎不可為null
	 * */
	@org.junit.Test(expected = RuntimeException.class)
	public void confirmEngineCannotBeNull() {
		getCost(null);
	}
	
	
	
	
	private BigDecimal getCost(AbstractEngine engine) {
		WidgetMachine machine = new WidgetMachine(engine);
		return machine.produceWidgets(REQUESTED_WIDGETS_COUNT);
	}

}
