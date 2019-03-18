
public class LesOperateursBitABit {

	public static void main(String[] args) {
		System.out.println("45 &(et) 22 = " + (45 & 22));
		System.out.println("99 |(ou) 46 = " + (99 | 46));
		System.out.println("99 ^(ou exclusif) 46 = " + (99 ^ 46));
		System.out.println("26 >>(décalage signé vers la droite) 1 = " + (26 >> 1));
		System.out.println("-26 >>(décalage signé vers la droite) 1 = " + (-26 >> 1));
		System.out.println("26 <<(décalage vers la gauche) 1 = " + (26 << 1));
		System.out.println("26 >>>(décalage non signé vers la droite) 1 = " + (26 >>> 1));
		System.out.println("-26 >>>(décalage non signé vers la droite) 1 = " + (-26 >>> 1));
	}

}
