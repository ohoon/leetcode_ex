/*
592.
Fraction Addition and Subtraction
https://leetcode.com/problems/fraction-addition-and-subtraction/
*/

class Solution {
    private class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {       // 생성자
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator() {         // getter, setter
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }

        public String toString() {      // Fraction 클래스를 문자열로 표현하는 메서드
            return this.numerator + "/" + this.denominator;
        }

        public Fraction add(Fraction f) {       // 분수끼리 덧셈
            return compact(new Fraction(this.numerator * f.getDenominator() + f.getNumerator() * this.denominator, this.denominator * f.getDenominator()));
        }

        public Fraction sub(Fraction f) {       // 분수끼리 뺄셈
            return compact(new Fraction(this.numerator * f.getDenominator() - f.getNumerator() * this.denominator, this.denominator * f.getDenominator()));
        }
    }

    public static int getGcd(int a, int b) {        // 두 수의 최대 공약수 구하는 메서드 (유클리드 호제법)
		if(a % b == 0) {
			return b;
		}

		return getGcd(b, a % b);
	}

    public static Fraction compact(Fraction f) {        // 기약 분수로 만드는 메서드
        int gcd = Math.abs(getGcd(f.getNumerator(), f.getDenominator()));
        f.setNumerator(f.getNumerator() / gcd);
        f.setDenominator(f.getDenominator() / gcd);
        return f;
    }

    public String fractionAddition(String expression) {
        List<Fraction> f = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        String[] fStr = expression.replaceAll("\\+", ",").replaceAll("\\-", ",").split(",");        // 분수만 추출하기 위함
        for (String str : fStr) {
            if (str.isEmpty()) {
                f.add(new Fraction(0, 1));
            } else {
                String[] split = str.split("/");
                f.add(new Fraction(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
            }
        }

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-') {       // 연산 기호만 추출
                op.add(ch);
            }
        }

        Fraction result = f.get(0);
        for (int i = 0; i < op.size(); i++) {
            result = op.get(i) == '+' ? result.add(f.get(i+1)) : result.sub(f.get(i+1));
        }

        return result.toString();
    }
}
