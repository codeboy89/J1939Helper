package com.ftsi.ops.simulator.j1939.model;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class J1939Model {
	private ConcurrentHashMap<UUID, PgnModel> pgnList = new ConcurrentHashMap<UUID, PgnModel>();

	public void addPgn(PgnModel pgnModel) {
		for (PgnModel pgn : pgnList.values()) {
			if (pgn.getUuid() == pgnModel.getUuid()) {
				pgnList.replace(pgnModel.getUuid(), pgnModel);
				System.out.println("Pgn: " + pgnModel.getPgnNumber() + " Replaced");
				System.out.println(pgnList);
				return;
			}
		}
		pgnList.put(pgnModel.getUuid(), pgnModel);
		System.out.println("Pgn: " + pgnModel.getPgnNumber() + " Added");
		System.out.println(pgnList);

	}

	public void removePgn(int pgnNumber) {
		for (PgnModel pgn : pgnList.values()) {
			if (pgn.getPgnNumber() == pgnNumber) {
				pgnList.remove(pgn.getUuid());
				System.out.println("Pgn: " + pgn.getPgnNumber() + " Removed");
				System.out.println(pgnList);
				return;
			}
		}
		System.out.println("Pgn: " + pgnNumber + " does not exsist");
		System.out.println(pgnList);
	}

	public void addSpn(SpnModel spnModel) {
		for (PgnModel pgnModel : pgnList.values()) {
			if (pgnModel.getPgnNumber() == spnModel.getPgn()) {
				pgnModel.addSpn(spnModel);
				return;
			}
		}
		System.out.println("Unknown Pgn");
	}

	public void removeSpn(int spnNumber) {
		for (PgnModel pgnModel : pgnList.values()) {
			if (pgnModel.getSpnList().containsKey(spnNumber)) {
				pgnModel.removeSpn(spnNumber);
				return;
			}
		}
		System.out.println("Unknown Pgn");
	}

	public Collection<PgnModel> getPgnList() {
		return pgnList.values();
	}

	public boolean isPgnListEmpty() {
		return pgnList.isEmpty();
	}

	public boolean hasSpn(int spnNumber) {
		for (PgnModel pgnModel : pgnList.values()) {
			for (SpnModel spn : pgnModel.getSpnList().values()) {
				if (spn.getSpnNumber() == spnNumber) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPgn(int pgnNumber) {
		for (PgnModel pgnModel : pgnList.values()) {
			if (pgnModel.getPgnNumber() == pgnNumber) {
				return true;
			}
		}
		return false;

	}

	public SpnModel getSpn(int spnNumber) {
		for (PgnModel pgn : pgnList.values()) {
			for (SpnModel spn : pgn.getSpnList().values()) {
				if (spn.getSpnNumber() == spnNumber) {
					return spn;
				}
			}
		}
		return null;
	}

	public PgnModel getPgn(int pgnNumber) {
		for (PgnModel pgn : pgnList.values()) {
			if (pgn.getPgnNumber() == pgnNumber) {
				return pgn;
			}
		}
		return null;
	}

}
