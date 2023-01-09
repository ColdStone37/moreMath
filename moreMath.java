import java.util.Vector;
import java.util.ArrayList;
import java.math.BigInteger;

public class moreMath{
	public static void main(String[] args){
		Funktion funktion = Funktion.valueOf(args[0]);
		funktion.run(args);
	}

	public static enum Funktion{
		help,
		ggT_e,
		ggT,
		ggT_p,
		ggT_i,
		kgV,
		crs,
		pf,
		pf_c,
		pf_p,
		bk,
		fa;


		public void run(String[] args){
			switch(this){
			case help:
				help();
				break;
			case ggT_e:
				long[] values = extractLongs(args);
				System.out.println(ggT_e(values[0], values[1]));
				break;
			case ggT:
				int[] valuesInt = extractInts(args);
				System.out.println(ggT(valuesInt));
				break;
			case ggT_p:
				values = extractLongs(args);
				ggT_p(values[0], values[1]);
				break;
			case ggT_i:
				values = extractLongs(args);
				System.out.println(ggT_i(values[0], values[1]));
				break;
			case kgV:
				values = extractLongs(args);
				System.out.println(kgV(values));
				break;
			case crs:
				values = extractLongs(args);
				System.out.println(crs(values));
				break;
			case pf:
				values = extractLongs(args);
				printLongArray(pf(values[0]));
				break;
			case pf_c:
				valuesInt = extractInts(args);
				printIntArray(pf_c(valuesInt[0]));
				break;
			case pf_p:
				values = extractLongs(args);
				pf_p(values[0]);
				break;
			case bk:
				valuesInt = extractInts(args);
				System.out.println(bk(valuesInt[0], valuesInt[1]));
				break;
			case fa:
				valuesInt = extractInts(args);
				System.out.println(fa(valuesInt[0]));
				break;
			}
		}
	}

	private static long[] extractLongs(String[] args){
		long[] returnValue = new long[args.length - 1];
		for(int i = 0; i<args.length-1; i++){
			returnValue[i] = Long.parseLong(args[i+1]);
		}
		return returnValue;
	}
	private static void printLongArray(long[] array){
		for(long val:array){
			System.out.print(val+" ");
		}
		System.out.println();
	}

	private static int[] extractInts(String[] args){
		int[] returnValue = new int[args.length - 1];
		for(int i = 0; i<args.length-1; i++){
			returnValue[i] = Integer.parseInt(args[i+1]);
		}
		return returnValue;
	}
	private static void printIntArray(int[] array){
		for(int val:array){
			System.out.print(val+" ");
		}
		System.out.println();
	}

	private static short[] extractShorts(String[] args){
		short[] returnValue = new short[args.length - 1];
		for(int i = 0; i<args.length-1; i++){
			returnValue[i] = Short.parseShort(args[i+1]);
		}
		return returnValue;
	}
	private static void printShortArray(short[] array){
		for(short val:array){
			System.out.print(val+" ");
		}
		System.out.println();
	}

	//gibt Hilfe auf der Konsole aus
	public static void help(){
		//help
		System.out.println("help");
		System.out.println(" -Zeigt diese Hilfeseite an");
		//ggT_e
		System.out.println("ggT_e a b");
		System.out.println(" -Verwendet den euklidschen Algorithmus um den groessten gemeinsamen Teiler von a und b zu finden");
		//ggT
		System.out.println("ggT a b c ...");
		System.out.println(" -Verwendet Primfaktorzerlegung um den groessten gemeinsamen Teiler von beliebig vielen Werten zu finden");
		//ggT_p
		System.out.println("ggT_p a b");
		System.out.println(" -gibt den groessten gemeinsamen Teiler von a und b aus und den Rechenweg in LaTeX aus");
		//ggT_i
		System.out.println("ggT_i a b");
		System.out.println(" -findet Werte x1, x2, sodass a*x1 + b*x2 = ggT(a,b)");
		//kgV
		System.out.println("kgV a b c d ...");
		System.out.println(" -Findet das kleinste gemeinsame Vielfache durch ausprobieren");
		//crs
		System.out.println("crs a1 m1 a2 m2 a3 m3 ...");
		System.out.println(" -Findet einen x-Wert, sodass gilt: x = a1 mod m1, x = a2 mod m2, ...");
		//pf
		System.out.println("pf a");
		System.out.println(" -Gibt die Primfaktoren einer Zahl a an");
		//pf_c
		System.out.println("pf_c a");
		System.out.println(" -Gibt eine Liste mit den Anzahlen der einzelnen Primfaktoren einer Zahl zurueck. Das 0te Element ist die Gesamtzahl der Faktoren");
		//pf_p
		System.out.println("pf_p a");
		System.out.println(" -Gibt die Primfaktoren einer Zahl a formatiert an");
		//bk
		System.out.println("bk n k");
		System.out.println(" -Berechnet den Binomialkoeffizient zweier Werte n und k");
		//fa
		System.out.println("fa n ");
		System.out.println(" -Berechnet die Fakultaet n! = 1 * 2 * ... * n");
	}

	//moderner euklidscher Algorithmus
	public static long ggT_e(long small, long big){
		if(small == big)
			return small;
		//vertausche die Werte falls small groesser als big ist
		if(small > big){
			long t = small;
			small = big;
			big = small;
		}
		//moderner euklidscher Algorithmus
		while(small != 0){
			long t = small;
			small = big % small;
			big = t;
		}
		return big;
	}
	//groesster gemeinsamer Teiler von beliebig vielen Werten
	public static int ggT(int... values){
		int biggest = values[0];
		for(int i = 1; i < values.length; i++)
			if(values[i] > biggest)
				biggest = values[i];
		
		int[] ggT_pf_c = pf_c(biggest);
		for(int val:values){
			int[] pf_c = pf_c(val);
			for(int j = 0; j < ggT_pf_c.length; j++){
				if(j >= pf_c.length){
					ggT_pf_c[j] = 0;
				} else {
					ggT_pf_c[j] = Integer.min(ggT_pf_c[j], pf_c[j]);
				}
			}
		}

		int ggT = 1;
		for(int i = 2; i < ggT_pf_c.length; i++)
			for(int j = 0; j < ggT_pf_c[i]; j++)
				ggT *= i;

		return ggT;
	}
	//moderner euklidscher Algorithmus mit Ausgabe
	public static long ggT_p(long small, long big){
		System.out.println(ggT_e(small, big));
		System.out.println("");
		System.out.println("LaTeX-String:");
		if(small == big){
			System.out.println("\\text{ggT}("+small+","+big+")="+small);
			return small;
		}

		System.out.println("\\text{ggT}("+small+","+big+"):\\\\");
		if(small > big){
			long t = small;
			small = big;
			big = small;
		}
		boolean finished = false;
		while(!finished){
			long q = big / small;
			long r = big % small;
			if(r == 0)
				break;

			if(small % r == 0){
				System.out.println("\\quad"+big+"-"+q+"\\cdot"+small+"=\\underline{"+r+"}\\\\");
				finished = true;
			} else {
				System.out.println("\\quad"+big+"-"+q+"\\cdot"+small+"="+r+"\\\\");
			}
			big = small;
			small = r;
		}
		System.out.println("\\quad"+big+"-"+(big/small)+"\\cdot\\underline{"+small+"}="+0);
		return small;
	}
	//inverser euklidscher Algorithmus
	public static Vector<Long> ggT_i(long val1, long val2){
		if(val1 == val2){
			Vector<Long> vec2 = new Vector<Long>(2);
			vec2.add(0, 0L);
			vec2.add(1, 1L);
			return vec2;
		}

		long ggT = ggT_e(val1, val2);
		long i = 0;
		for(i = 0; Math.abs(ggT-val1*i) % val2 != 0; i++){}

		Vector<Long> vec2 = new Vector<Long>(2);
		vec2.add(0, i);
		vec2.add(1, (ggT-val1*i) / val2);
		return vec2;
		
	}

	//kleinstes gemeinsames Vielfaches von zwei Werten
	public static long kgV(long val1, long val2){
		if(val1 == val2)
			return val1;
		
		int i = 1;
		while(val1 * i % val2 != 0)
			i++;

		return val1 * i;
	}
	//kleinstes gemeinsames Vielfaches von mehreren Werten
	public static long kgV(long... values){
		long biggest = values[0];
		for(int i = 1; i < values.length; i++)
			if(values[i] > biggest)
				biggest = values[i];
		
		boolean finished = true;
		long value = 0;
		do {
			value+=biggest;
			finished = true;
			for(int i = 0; i < values.length; i++)
				if(value % values[i] != 0){
					finished = false;
					break;
				}
		} while(!finished);
		return value;
	}

	//chinesischer Restsatz
	public static long crs(long a1, long m1, long a2, long m2){
		if(ggT_e(m1, m2) == 1)
			throw new ArithmeticException();

		long x1 = 1;
		while((m2 * x1) % m1 != 1)
			x1++;

		long x2 = 1;
		while((m1 * x2) % m2 != 1)
			x2++;

		return a1*m2*x1 + a2*m1*x2;
	}
	//chinesischer Restsatz aber mit beliebig vielen a und m
	public static long crs(long... values) throws ArithmeticException{
		if(values.length % 2 != 0)
			throw new ArithmeticException();

		for(int i = 1; i < values.length; i+=2){
			for(int j = i + 2; j < values.length; j+=2){
				if(ggT_e(values[i], values[j]) != 1)
					throw new ArithmeticException();
			}
		}

		//Produkt aller Werte berechnen
		long product_m = 1;
		for(int i = 1; i < values.length; i += 2){
			product_m *= values[i];
		}

		//x-Werte finden, sodass alle einzelnen Module 1 sind
		long[] x_values = new long[values.length / 2];
		for(int i = 0; i < x_values.length; i++){
			x_values[i] = 1;
			long product = product_m / values[i*2+1];
			while((product * x_values[i]) % values[i*2+1] != 1)
				x_values[i]++;
		}

		//Ergebnis berechnen
		long x = 0;
		for(int i = 0; i < x_values.length; i++){
			x += values[i*2] * x_values[i] * (product_m / values[i*2+1]);
		}
		return x;
	}

	//Primfaktorzerlegung, alle Faktoren landen in eimem Array
	public static long[] pf(long value){
		if(value <= 0)
			throw new ArithmeticException();

		ArrayList<Long> factors_al = new ArrayList<Long>();
		long factor = 2;
		while(value != 1){
			if(value % factor == 0){
				value /= factor;
				factors_al.add(factor);
			} else {
				factor++;
			}
		}
		long[] factors = new long[factors_al.size()];
		for(int i=0; i<factors.length; i++){
			factors[i] = factors_al.get(i);
		}
		return factors;
	}
	//Primfaktorzerlegung, Anzahl eines Faktors wird an der entsprechenden Stelle in einem Array gezaehlt. Die 0te Stelle zaehlt die Anzahl der gesamten Faktoren
	public static int[] pf_c(int value){
		if(value <= 0)
			throw new ArithmeticException();

		int[] factors = new int[value+1];
		int factor = 2;
		while(value != 1){
			if(value % factor == 0){
				value /= factor;
				factors[0]++;
				factors[factor]++;
			} else {
				factor++;
			}
		}
		return factors;
	}
	//Primfaktorzerlegung Ausgabe
	public static long[] pf_p(long value){
		if(value <= 0)
			throw new ArithmeticException();

		ArrayList<Long> factors_al = new ArrayList<Long>();
		long factor = 2;
		int count = 0;
		boolean first = true;
		System.out.print(value+" = ");
		while(value != 1){
			if(value % factor == 0){
				value /= factor;
				factors_al.add(factor);
				count++;
			} else {
				if(count != 0){
					if(!first)
						System.out.print(" * ");
					System.out.print(factor+"^"+count);
					first = false;
				}
				factor++;
				count = 0;
				
			}
		}
		if(!first)
			System.out.print(" + ");
		System.out.println(factor+"^"+count);

		long[] factors = new long[factors_al.size()];
		for(int i=0; i<factors.length; i++){
			factors[i] = factors_al.get(i);
		}
		return factors;
	}

	//Binomialkoeffizient
	public static long bk(short n, short k){
		if(k > n || (k < 0 || n < 0))
			throw new ArithmeticException();

		long bk = 1;
		long j = 2;
		for(long i = k + 1; i <= n; i++){
			bk *= i;
			while(bk % j == 0 && j <= n-k){
				bk /= j;
				j++;
			}
		}

		while(j <= n-k){
			bk /= j;
			j++;
		}
		return bk;
	}
	//Binomialkoeffizient BigInteger
	public static BigInteger bk(int n, int k){
		if(k > n || (k < 0 || n < 0))
			throw new ArithmeticException();

		BigInteger bk = new BigInteger("1");
		BigInteger N = new BigInteger(""+n);
		BigInteger J = new BigInteger("2");
		BigInteger N_minus_K = new BigInteger(""+(n-k));

		for(BigInteger I = new BigInteger("" + (k + 1)); I.compareTo(N) <= 0; I = I.add(BigInteger.ONE)){
			bk = bk.multiply(I);
			while(J.compareTo(N_minus_K) <= 0 && bk.mod(J).compareTo(BigInteger.ZERO) == 0)
				bk = bk.divide(J);
		}

		return bk;
	}

	//Fakultaet
	public static long fa(short n){
		long total = 1;
		for(long i = 2; i <= n; i++)
			total *= i;
		return total;
	}

	//Fakultaet BigInteger
	public static BigInteger fa(int n){
		BigInteger Total = new BigInteger("1");
		BigInteger N = new BigInteger("" + n);
		for(BigInteger I = new BigInteger("2"); I.compareTo(N) <= 0; I = I.add(BigInteger.ONE))
			Total = Total.multiply(I);
		return Total;
	}
}