package com.ftsi.ops.simulator.j1939.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.ftsi.ops.simulator.j1939.types.J1939ComponentSource;
import com.ftsi.ops.simulator.j1939.types.J1939TxRate;

public class PgnModel {
	private List<IPgnChangeListener> listeners = new ArrayList<IPgnChangeListener>();
	private byte dataBytes[] = { (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255 };
	private int dataLength = 8;
	private int extId = 0;
	private boolean metricType = true;
	private String pgnAcronym = "Unknown";
	private boolean pgnBusActive = true;
	private String pgnName = "Unknown";
	private int pgnNumber = 0;
	private int sourceAddress = 0;
	private J1939ComponentSource sourceComponent = J1939ComponentSource.USER;
	private int spnCount = 0;
	private ConcurrentHashMap<Integer, SpnModel> spnList = new ConcurrentHashMap<Integer, SpnModel>();
	private J1939TxRate txRate = J1939TxRate.TXRATE_1000;
	private UUID uuid = UUID.randomUUID();

	public PgnModel(byte[] dataBytes, int dataLength, int extId, boolean metricType, String pgnAcronym, boolean pgnBusActive, String pgnName, int pgnNumber,
			int sourceAddress, J1939ComponentSource sourceComponent, int spnCount, J1939TxRate txRate) {
		super();
		this.dataBytes = dataBytes;
		this.dataLength = dataLength;
		this.extId = extId;
		this.metricType = metricType;
		this.pgnAcronym = pgnAcronym;
		this.pgnBusActive = pgnBusActive;
		this.pgnName = pgnName;
		this.pgnNumber = pgnNumber;
		this.sourceAddress = sourceAddress;
		this.sourceComponent = sourceComponent;
		this.spnCount = spnList.size();
		this.txRate = txRate;
	}

	public PgnModel(int pgnNumber) {
		this.pgnNumber = pgnNumber;
	}

	public byte[] getDataBytes() {
		return dataBytes;
	}

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
		notifiyChange();

	}

	public int getExtId() {
		return extId;
	}

	public void setExtId(int extId) {
		this.extId = extId;
		notifiyChange();

	}

	public boolean isMetricType() {
		return metricType;
	}

	public void setMetricType(boolean metricType) {
		this.metricType = metricType;
		notifiyChange();

	}

	public String getPgnAcronym() {
		return pgnAcronym;
	}

	public void setPgnAcronym(String pgnAcronym) {
		this.pgnAcronym = pgnAcronym;
		notifiyChange();

	}

	public boolean isPgnBusActive() {
		return pgnBusActive;
	}

	public void setPgnBusActive(boolean pgnBusActive) {
		this.pgnBusActive = pgnBusActive;
		notifiyChange();

	}

	public String getPgnName() {
		return pgnName;
	}

	public void setPgnName(String pgnName) {
		this.pgnName = pgnName;
		notifiyChange();

	}

	public int getPgnNumber() {
		return pgnNumber;
	}

	public int getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(int sourceAddress) {
		this.sourceAddress = sourceAddress;
		notifiyChange();
	}

	public J1939ComponentSource getSourceComponent() {
		return sourceComponent;
	}

	public void setSourceComponent(J1939ComponentSource sourceComponent) {
		this.sourceComponent = sourceComponent;
		notifiyChange();

	}

	public int getSpnCount() {
		return spnList.size();
	}

	public Map<Integer, SpnModel> getSpnList() {
		return spnList;
	}

	public J1939TxRate getTxRate() {
		return txRate;
	}

	public void setTxRate(J1939TxRate txRate) {
		this.txRate = txRate;
		notifiyChange();
	}

	public UUID getUuid() {
		return uuid;
	}

	public void addSpn(SpnModel spnModel) {
		if (spnList.get(spnModel.getSpnNumber()) != null) {
			spnList.replace(spnModel.getSpnNumber(), spnModel);
			System.out.println("Replaced: " + spnModel.getSpnNumber());

		} else {
			spnList.put(spnModel.getSpnNumber(), spnModel);
			System.out.println("Added: " + spnModel.getSpnNumber());

		}
	}

	public void removeSpn(int spnNumber) {
		spnList.remove(spnNumber);
		System.out.println("Removed: " + spnNumber + " from Pgn: " + pgnNumber);
	}

	public void registerListener(IPgnChangeListener listener) {
		if (listeners.isEmpty()) {
			listeners.add(listener);
		} else {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IPgnChangeListener listener) {
		if (!listeners.isEmpty()) {
			listeners.remove(listener);
		}
	}

	private void notifiyChange() {
		if (!listeners.isEmpty())
			for (IPgnChangeListener listener : listeners) {
				listener.pgnChanged(this);
			}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PgnModel [dataBytes=");
		builder.append(Arrays.toString(dataBytes));
		builder.append(", dataLength=");
		builder.append(dataLength);
		builder.append(", extId=");
		builder.append(extId);
		builder.append(", metricType=");
		builder.append(metricType);
		builder.append(", pgnAcronym=");
		builder.append(pgnAcronym);
		builder.append(", pgnBusActive=");
		builder.append(pgnBusActive);
		builder.append(", pgnName=");
		builder.append(pgnName);
		builder.append(", pgnNumber=");
		builder.append(pgnNumber);
		builder.append(", sourceAddress=");
		builder.append(sourceAddress);
		builder.append(", sourceComponent=");
		builder.append(sourceComponent);
		builder.append(", spnCount=");
		builder.append(spnCount);
		builder.append(", spnList=");
		builder.append(spnList);
		builder.append(", txRate=");
		builder.append(txRate);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append("]");
		return builder.toString();
	}

}
