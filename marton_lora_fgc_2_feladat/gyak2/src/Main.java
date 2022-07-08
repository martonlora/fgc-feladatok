import java.util.*;

public class Main {
    public static void main(String[] args) {
        //feladat: egy határértékig (n) előállítani az összes iker-majdnem-prímet
        //majdnem prím: két prímszám szorzata
        //iker-majdnem-prím: ha két szomszédos szám majdnem prím
        //pl. 9 (3x3) és 10 (2x5)

        Scanner input = new Scanner(System.in);
        System.out.println("Allitsunk elo iker-majdnem-primszamokat!");
        System.out.println("Adjon meg egy felso hatarerteket:");
        int n = 0;
        n = input.nextInt();

        //prímszámok kiválogatása
        ArrayList<Integer> primszamok = new ArrayList<Integer>();
        primszamok.add(2);
        for (int i = 3; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    if (primszamok.contains(i)) {
                        primszamok.remove(primszamok.indexOf(i));
                    }
                    break;
                }
                else if (!primszamok.contains(i)) {
                    primszamok.add(i);
                }
            }
        }

        //majdnem prímek kiválogatása
        //majdnem prím: két prímszám szorzata
        ArrayList<Integer> majdnemPrimek = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            for (int prim : primszamok) {
                if (prim >= i) {
                    break;
                }
                else if (i % prim == 0 && !majdnemPrimek.contains(i)) {
                    if (primszamok.contains(i / prim)) {
                        majdnemPrimek.add(i);
                    }
                }
            }
        }

        //iker-majdnem-prímek kiválogatása
        //iker-majdnem-prím: ha két szomszédos szám majdnem prím
        ArrayList<Integer> ikerMajdnemPrimek = new ArrayList<Integer>();
        for (int majdnemprim : majdnemPrimek) {
            if (majdnemPrimek.contains(majdnemprim-1) || majdnemPrimek.contains(majdnemprim+1)) {
                ikerMajdnemPrimek.add(majdnemprim);
            }
        }
        for (int szam : ikerMajdnemPrimek) {
            System.out.println(szam);
        }
    }
}