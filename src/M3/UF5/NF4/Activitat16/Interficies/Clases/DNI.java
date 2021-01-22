package M3.UF5.NF4.Activitat16.Interficies.Clases;

import M3.UF5.NF4.Activitat16.Interficies.Interficies.Valida;

class DNI implements Valida, Comparable {
	private int num;
	private char lletra;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public char getLletra() {
		return lletra;
	}

	public void setLletra(char lletra) {
		this.lletra = lletra;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}