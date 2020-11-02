package com.ftsi.ops.simulator.j1939;

import com.ftsi.ops.simulator.j1939.model.J1939Model;

public class J1939Helper {

	private J1939Model j1939;

	public J1939Helper() {
		j1939 = new J1939Model();
		test();
	}

	private void test() {
	}

	public static void main(String[] args) {
		new J1939Helper();
	}

	public J1939Model getJ1939() {
		return this.j1939;
	}
}
