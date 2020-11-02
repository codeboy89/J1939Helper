package com.ftsi.ops.simulator.j1939.types;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum J1939Unit {

	COUNT_REVS(UnitGroup.COUNT, "Revolutions", "REVS"),
	DATA_TYPE_BIT(UnitGroup.DATA_TYPE, "Bit", "BIT"),
	DATA_TYPE_BYTE(UnitGroup.DATA_TYPE, "Byte", "BYTE"),
	ELECTRICAL_AMPERAGE(UnitGroup.ELECTRICAL, "Amperage", "A"),
	ELECTRICAL_VOLTAGE(UnitGroup.ELECTRICAL, "Voltage", "V"),
	GENERIC(UnitGroup.GENERIC, "Generic", "NONE"),
	J1939_FMI(UnitGroup.J1939, "Failure Mode Indentifier", "FMI"),
	J1939_LOOKUP(UnitGroup.GENERIC, "Lookup", "LKUP"),
	J1939_PGN(UnitGroup.J1939, "Parameter Group Number", "PGN"),
	J1939_SOURCE_ADDRESS(UnitGroup.J1939, "Source Address", "SA"),
	J1939_SPN(UnitGroup.J1939, "Suspect Parameter Number", "SPN"),
	J1939_STATUS(UnitGroup.J1939, "Status", "STATUS"),
	PERCENT(UnitGroup.PERCENT, "Percent", "%"),
	PRESSURE_KPA(UnitGroup.PRESSURE, "kilopascal", "KPA"),
	PRESSURE_PSI(UnitGroup.PRESSURE, "Pounds Square Ince", "PSI"),
	RATE_GALLON_PER_HOUR(UnitGroup.RATE_VOLUME, "Gallon Per Hour", "GAL/HR"),
	RATE_GALLON_PER_MINUTE(UnitGroup.RATE_VOLUME, "Gallon Per Minute", "GAL/MIN"),
	RATE_GALLON_PER_SECOND(UnitGroup.RATE_VOLUME, "Gallon Per Second", "GAL/SEC"),
	RATE_LITER_PER_HOUR(UnitGroup.RATE_VOLUME, "Liter Per Hour", "LTR/HR"),
	RATE_LITER_PER_MINUTE(UnitGroup.RATE_VOLUME, "Liter Per Minute", "LTR/MIN"),
	RATE_LITER_PER_SECOND(UnitGroup.RATE_VOLUME, "Liter Per Second", "LTR/SEC"),
	RATE_REV_PER_MINUTE(UnitGroup.RATE_REVOLUTIONS, "Revolutions Per Minute", "RPM"),
	RATE_KILOMETERS_PER_LITER(UnitGroup.RATE_VOLUME, "Kilometers Per Liter", "KM/L"),
	TEMP_CELSIUS(UnitGroup.TEMPERATURE, "Celsius", "C"),
	TEMP_FAHRENHEIT(UnitGroup.TEMPERATURE, "Fahrenheit", "F"),
	TIME_HOUR(UnitGroup.TIME, "Hour", "HR"),
	TIME_MINUTE(UnitGroup.TIME, "Minute", "MIN"),
	TIME_SECOND(UnitGroup.TIME, "Second", "SEC"),
	VOLUME_GALLON(UnitGroup.VOLUME, "Gallon", "GAL"),
	VOLUME_LITER(UnitGroup.VOLUME, "Liter", "LTR");

	private static Map<String, J1939Unit> unitAbriviationMap = new ConcurrentHashMap<String, J1939Unit>();
	private static Map<String, J1939Unit> unitDisplayNameMap = new ConcurrentHashMap<String, J1939Unit>();
	static {
		for (J1939Unit unit : J1939Unit.values()) {
			J1939Unit.unitAbriviationMap.put(unit.unitAbriviation, unit);
			J1939Unit.unitDisplayNameMap.put(unit.unitDisplayName, unit);
		}
	}

	public static J1939Unit getByAbriviation(String unitAbriviation) {
		return J1939Unit.unitAbriviationMap.get(unitAbriviation);
	}

	public static J1939Unit getByDisplayName(String unitDisplayName) {
		return J1939Unit.unitDisplayNameMap.get(unitDisplayName);
	}

	private final String unitAbriviation;

	private final String unitDisplayName;

	private final UnitGroup unitGroup;

	private J1939Unit(UnitGroup unitGroup, String unitDisplayName, String unitAbriviation) {
		this.unitGroup = unitGroup;
		this.unitDisplayName = unitDisplayName;
		this.unitAbriviation = unitAbriviation;
	}

	public String getUnitAbriviation() {
		return unitAbriviation;
	}

	public String getUnitDisplayName() {
		return unitDisplayName;
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}
}
