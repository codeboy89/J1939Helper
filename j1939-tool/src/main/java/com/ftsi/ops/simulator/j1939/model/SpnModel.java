package com.ftsi.ops.simulator.j1939.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ftsi.ops.simulator.j1939.types.J1939Unit;

public class SpnModel {
	private List<ISpnChangeListener> listeners = new ArrayList<ISpnChangeListener>();
	private int pgn = 0;
	private int bitCount = 1;
	private int dataLength = 1;
	private String fromByteMultiplier = "1";
	private String fromValueMultiplier = "1";
	private boolean metricType = true;
	private int locationStartBit = 1;
	private int locationStartByte = 1;
	private Double lowerRange = 0.0;
	private Double offset = 0.0;
	private boolean overrideState = false;
	private Double overrideValue = 0.0;
	private String resolution = "1";
	private int spnIndex = 1;
	private String spnName = "Unknown";
	private int spnNumber = 0;
	private J1939Unit unit = J1939Unit.J1939_SPN;
	private Double upperRange = 1.0;
	private Double value = 0.0;

	private UUID uuid = UUID.randomUUID();

	public SpnModel(int pgn) {
		this.pgn = pgn;
	}

	public SpnModel(int pgn, int spnNumber) {
		this.pgn = pgn;
		this.spnNumber = spnNumber;
	}

	public SpnModel(int pgn, int bitCount, int dataLength, String fromByteMultiplier, String fromValueMultiplier, boolean metricType, int locationStartBit,
			int locationStartByte, Double lowerRange, Double offset, boolean overrideState, Double overrideValue, String resolution, int spnIndex,
			String spnName, int spnNumber, J1939Unit unit, Double upperRange, Double value) {

		this.pgn = pgn;
		this.bitCount = bitCount;
		this.dataLength = dataLength;
		this.fromByteMultiplier = fromByteMultiplier;
		this.fromValueMultiplier = fromValueMultiplier;
		this.metricType = metricType;
		this.locationStartBit = locationStartBit;
		this.locationStartByte = locationStartByte;
		this.lowerRange = lowerRange;
		this.offset = offset;
		this.overrideState = overrideState;
		this.overrideValue = overrideValue;
		this.resolution = resolution;
		this.spnIndex = spnIndex;
		this.spnName = spnName;
		this.spnNumber = spnNumber;
		this.unit = unit;
		this.upperRange = upperRange;
		this.value = value;
	}

	public int getPgn() {
		return pgn;
	}

	public int getBitCount() {
		return bitCount;
	}

	public void setBitCount(int bitCount) {
		this.bitCount = bitCount;
		notifiyChange();

	}

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
		notifiyChange();

	}

	public String getFromByteMultiplier() {
		return fromByteMultiplier;
	}

	public void setFromByteMultiplier(String fromByteMultiplier) {
		this.fromByteMultiplier = fromByteMultiplier;
		notifiyChange();

	}

	public String getFromValueMultiplier() {
		return fromValueMultiplier;
	}

	public void setFromValueMultiplier(String fromValueMultiplier) {
		this.fromValueMultiplier = fromValueMultiplier;
		notifiyChange();

	}

	public boolean isMetricType() {
		return metricType;
	}

	public void setMetricType(boolean metricType) {
		this.metricType = metricType;
		notifiyChange();

	}

	public int getLocationStartBit() {
		return locationStartBit;
	}

	public void setLocationStartBit(int locationStartBit) {
		this.locationStartBit = locationStartBit;
		notifiyChange();

	}

	public int getLocationStartByte() {
		return locationStartByte;
	}

	public void setLocationStartByte(int locationStartByte) {
		this.locationStartByte = locationStartByte;
		notifiyChange();

	}

	public Double getLowerRange() {
		return lowerRange;
	}

	public void setLowerRange(Double lowerRange) {
		this.lowerRange = lowerRange;
		notifiyChange();

	}

	public Double getOffset() {
		return offset;
	}

	public void setOffset(Double offset) {
		this.offset = offset;
		notifiyChange();

	}

	public boolean isOverrideState() {
		return overrideState;
	}

	public void setOverrideState(boolean overrideState) {
		this.overrideState = overrideState;
		notifiyChange();

	}

	public Double getOverrideValue() {
		return overrideValue;
	}

	public void setOverrideValue(Double overrideValue) {
		this.overrideValue = overrideValue;
		notifiyChange();

	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
		notifiyChange();

	}

	public int getSpnIndex() {
		return spnIndex;
	}

	public void setSpnIndex(int spnIndex) {
		this.spnIndex = spnIndex;
		notifiyChange();

	}

	public String getSpnName() {
		return spnName;
	}

	public void setSpnName(String spnName) {
		this.spnName = spnName;
		notifiyChange();

	}

	public int getSpnNumber() {
		return spnNumber;
	}

	public J1939Unit getUnit() {
		return unit;
	}

	public void setUnit(J1939Unit unit) {
		this.unit = unit;
		notifiyChange();

	}

	public Double getUpperRange() {
		return upperRange;
	}

	public void setUpperRange(Double upperRange) {
		this.upperRange = upperRange;
		notifiyChange();

	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
		notifiyChange();
	}

	public UUID getUuid() {
		return uuid;
	}

	public void registerListener(ISpnChangeListener listener) {
		if (listeners.isEmpty()) {
			listeners.add(listener);
		} else {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(ISpnChangeListener listener) {
		if (!listeners.isEmpty()) {
			listeners.remove(listener);
		}
	}

	private void notifiyChange() {
		if (!listeners.isEmpty())
			for (ISpnChangeListener listener : listeners) {
				listener.spnChanged(this);
			}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpnModel [pgn=");
		builder.append(pgn);
		builder.append(", bitCount=");
		builder.append(bitCount);
		builder.append(", dataLength=");
		builder.append(dataLength);
		builder.append(", fromByteMultiplier=");
		builder.append(fromByteMultiplier);
		builder.append(", fromValueMultiplier=");
		builder.append(fromValueMultiplier);
		builder.append(", metricType=");
		builder.append(metricType);
		builder.append(", locationStartBit=");
		builder.append(locationStartBit);
		builder.append(", locationStartByte=");
		builder.append(locationStartByte);
		builder.append(", lowerRange=");
		builder.append(lowerRange);
		builder.append(", offset=");
		builder.append(offset);
		builder.append(", overrideState=");
		builder.append(overrideState);
		builder.append(", overrideValue=");
		builder.append(overrideValue);
		builder.append(", resolution=");
		builder.append(resolution);
		builder.append(", spnIndex=");
		builder.append(spnIndex);
		builder.append(", spnName=");
		builder.append(spnName);
		builder.append(", spnNumber=");
		builder.append(spnNumber);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", upperRange=");
		builder.append(upperRange);
		builder.append(", value=");
		builder.append(value);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append("]");
		return builder.toString();
	}

}
