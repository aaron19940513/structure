package oj.calculator;

import java.util.LinkedList;


public class Calculator {
	double calc(String params) {
		LinkedList<Object> paramList = new LinkedList<>();
		StringBuffer decimal = new StringBuffer();
		for (char param : params.toCharArray()) {
			if (String.valueOf(param).matches("[0-9]")) {
				decimal.append(param);
				paramList.add(decimal.toString());
			} else if (param == '.') {
				paramList.removeLast();
				decimal.append(param);
			} else if (null != Signs.find(param)) {
				paramList.add(Signs.find(param));
				decimal.setLength(0);
			} else {
				return 0.0;
			}

		}
		show(paramList);

		return doCalc(paramList);
	}

	private void show(LinkedList<Object> paramList) {
		for (Object object : paramList) {
			System.out.print(String.valueOf(object));
		}

	}

	private double doCalc(LinkedList<Object> paramList) {
		LinkedList<Object> resultList = new LinkedList<>();
		Signs calculateSign = null;
		Object element = null;
		while (paramList.size() > 0) {
			element = paramList.pop();
			if (element instanceof Signs) {
				Signs sign = (Signs) element;
				// 如果匹配到前括号,直接插入不做任何处理
				if (sign.getSign() == Signs.BLK_B.getSign()) {
					resultList.add(sign);
					// 如果匹配到后括号,出去队列里面的括号中的算式计算
				} else if (sign.getSign() == Signs.BLK_A.getSign()) {
					double result = doCalc(Double.valueOf(String.valueOf(resultList.removeLast())),
							(Signs) resultList.removeLast(), Double.valueOf(String.valueOf(resultList.removeLast())));
					resultList.removeLast();
					resultList.add(result);
				} else {
					if (null == calculateSign) {
						calculateSign = sign;
						resultList.add(sign);
					} else {
						if (sign.getValue() <= calculateSign.value) {
							double result = doCalc(Double.valueOf(String.valueOf(resultList.removeLast())),
									(Signs) resultList.removeLast(),
									Double.valueOf(String.valueOf(resultList.removeLast())));
							resultList.add(result);
							calculateSign = sign;
							resultList.add(sign);
						}
					}
				}
			} else if (element instanceof String) {
				String number = (String) element;
				resultList.add(number);
			}
		}

		return (double) resultList.get(0);
	}

	private double doCalc(Double oneElement, Signs calculateSign, Double twoElement) {
		if (calculateSign.getSign() == Signs.ADD.getSign()) {
			return oneElement + twoElement;
		} else if (calculateSign.getSign() == Signs.SUB.getSign()) {
			return oneElement - twoElement;
		} else if (calculateSign.getSign() == Signs.DIV.getSign()) {
			return oneElement / twoElement;
		} else {
			return oneElement * twoElement;
		}

	}

}
