# moreMath

A java-class with more math operations
---
## Implementierte Operationen:
* **long ggT_e(long a, long b):**
    Verwendet den euklidschen Algorithmus um den größten gemeinsamen Teiler zweier Werte zu finden
* **int ggT(int a, int b, ...):**
  Verwendet Primfaktorzerlegung um den größten gemeinsamen Teiler mehrerer Werte zu finden
* **long ggT_p(long a, long b):**
  euklidscher Algorithmus mit Ausgabe des Rechenwegs im LaTeX-Format
* **Vector<Long> ggT_invert(long a, long b):**
  Inverser euklidscher Algorithmus
* **kgV long kgV(long val1, long val2, ...):**
  Findet das kleinste gemeinsame Vielfache von beliebig vielen Werten
* **long crs(long a1, long m1, long a2, long m2, ...):**
  Findet ein x, sodass gilt: $x \equiv a_1 \mod m_1$, $x \equiv a_2 \mod m_2$, ...
* **long[] pf(long value):**
  Gibt die Primfaktoren eines Wertes in einem long-Array an
* **int[] pf_c(int value):**
  Gibt die Primfaktoren in einem Array zurück, in welchem an jeder Stelle die Anzahl der Vorkommen des Faktors in der Zahl steht (Bsp: 6 = [0,0,1,1,0,0,0])
* **long[] pf_p(long value):**
  Gibt die Primfaktoren auf der Konsole aus
* **long bk(short n, short k):**
  Berechnet den Binomialkoeffizient $\binom nk$ (Achtung: bei hohen Werte kommt es schnell zu long-Overflows)
* **BigInteger bk(int n, int k):**
  Berechnet den Binomialkoeffizient $\binom nk$ als BigInteger
* **long fa(short n):**
  Berechnet die Fakultät von $n$: $n! = 1 \cdot 2 \cdot \dots \cdot n$ (Achtung: bei hohen Werte kommt es schnell zu long-Overflows)
* **BigInteger fa(int n):**
  Berechnet die Fakultät von $n$: $n! = 1 \cdot 2 \cdot \dots \cdot n$ als BigInteger
  **long phi(int n):**
  Berechnet die Eulersche Phi-Funktion des Wertes $n$