package com.ftsi.ops.simulator.j1939.types;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum J1939TxRate {
	TXRATE_10(10, "10"),
	TXRATE_25(25, "25"),
	TXRATE_50(50, "50"),
	TXRATE_100(100, "100"),
	TXRATE_250(250, "250"),
	TXRATE_500(500, "500"),
	TXRATE_750(750, "750"),
	TXRATE_1000(1000, "1000"),
	TXRATE_2500(2500, "2500"),
	TXRATE_5000(5000, "5000"),
	TXRATE_10000(10000, "10000"),
	TXRATE_30000(30000, "30000"),
	TXRATE_ON_FAULT(-1, "FAULT"),
	TXRATE_ON_REQUEST(0, "REQUEST");

	private static Map<Integer, J1939TxRate> txRateMap = new ConcurrentHashMap<Integer, J1939TxRate>();
	private static Map<String, J1939TxRate> keyMap = new ConcurrentHashMap<String, J1939TxRate>();
	static {
		for (J1939TxRate j1939TxRate : J1939TxRate.values()) {
			J1939TxRate.txRateMap.put(j1939TxRate.txRate, j1939TxRate);
			J1939TxRate.keyMap.put(j1939TxRate.key, j1939TxRate);
		}
	}

	public static J1939TxRate getByKey(String key) {
		return J1939TxRate.keyMap.get(key);
	}

	public static J1939TxRate getByRate(int rate) {
		return J1939TxRate.txRateMap.get(rate);
	}

	private final int txRate;

	private final String key;

	private J1939TxRate(int txRate, String key) {
		this.txRate = txRate;
		this.key = key;
	}

	public int getTxRate() {
		return txRate;
	}

}
