package binary;

/**
 * Transformation between Decimal, Binary, Hexadecimal
 * 
 * @author Gustavo
 *
 */
public class BinaryHexadecimalTransform {

	public static void main(String[] args) {
		BinaryHexadecimalTransform app = new BinaryHexadecimalTransform();

		System.out.println(app.binaryToDecimal("1101")); // 13
		System.out.println(app.decimalToBinary(13)); // 1001
		System.out.println(app.decimalToHex(7562)); // 1D8A hex
		System.out.println(app.hexToDecimal("E7A9")); // 59305 decimal

		System.out.println(app.compareBinaryToHex("1111", "F"));

	}

	private int binaryToDecimal(String binary) {

		int value = 0;
		int exponent = 0;

		for (int i = binary.length() - 1; i >= 0; i--) {
			int digit = digitToValue(binary.charAt(i));
			value += digit * Math.pow(2, exponent++);
		}

		return value;
	}

	private String decimalToBinary(int decimal) {
		int mod = 0;
		String value = "";
		while (decimal > 0) {
			mod = decimal % 2;
			decimal = decimal / 2;
			value = mod + value;
		}
		return value;
	}

	private String decimalToHex(int decimal) {

		int reminder = 0;
		int index = 0;
		String new_value = "";
		String hex_value = "";
		Character[] hexLetters = new Character[] { 'A', 'B', 'C', 'D', 'E', 'F' };

		while (decimal > 0) {
			reminder = decimal % 16;
			decimal = decimal / 16;

			new_value = String.valueOf(reminder);

			if (reminder >= 10) {
				index = reminder % 10;
				new_value = hexLetters[index].toString();
			}

			hex_value = new_value + hex_value;
		}

		return hex_value;
	}

	private int hexToDecimal(String hex) {

		int digit = 0;
		int exponent = 0;
		int value = 0;

		for (int i = hex.length() - 1; i >= 0; i--) {
			digit = digitToValue(hex.charAt(i));
			value += digit * Math.pow(16, exponent++);
		}

		return value;

	}

	private int digitToValue(char c) {
		int val = 0;
		switch (c) {
		case 'A':
			val = 10;
			break;
		case 'B':
			val = 11;
			break;
		case 'C':
			val = 12;
			break;
		case 'D':
			val = 13;
			break;
		case 'E':
			val = 14;
			break;
		case 'F':
			val = 15;
			break;
		default:
			val = Integer.parseInt(c + "");
			break;

		}
		return val;
	}

	private boolean compareBinaryToHex(String binary, String hexadecimal) {

		int bin = getDecimalFrom(binary, 2);
		int hex = getDecimalFrom(hexadecimal, 16);
		if (bin < 0 || hex < 0)
			return false;
		return bin == hex;
	}

	private int getDecimalFrom(String number, int base) {

		if (base != 2 && base != 16)
			return -1;

		int digit = 0;
		int exponent = 0;
		int value = 0;

		for (int i = number.length() - 1; i >= 0; i--) {
			digit = digitToValue(number.charAt(i));
			value += digit * Math.pow(base, exponent++);
		}

		return value;
	}
}