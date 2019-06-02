package oj.calculator;

public enum Signs {
	ADD('+',1),SUB('-',1),DIV('/',2),MUL('*',2),BLK_B('(',3),BLK_A(')',4);
	
	
	Signs(char  sign,int value){
		this.sign = sign;
		this.value = value;
	}

	char sign;
	int value;
	

	public static Signs find(char sign) {
		for(Signs element:Signs.values()) {
			if(sign == element.getSign()) {
				return element;
			}
		}
		return null;
	}
	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
