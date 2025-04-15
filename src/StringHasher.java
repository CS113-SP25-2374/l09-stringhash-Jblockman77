public class StringHasher {

    public static int badHash(String s) {
        return s.length(); // Not great – lots of collisions!
    }

    public static int betterHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i); // Still not great – order doesn't matter
        }
        return hash;
    }

    public static int cheapAndEasy(String s){
        return s.hashCode();
    }

    public static int javaHashCode(String s) {
        // implement the official hashCode for Strings!
        // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        int hash = 0;
        int n = s.length()-1;
        for(int i = 0; i< s.length(); i++){
            hash += (int) Math.pow(31, (n-i)) * s.charAt(i);
            // lesson learned, convert it to an int.
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] testStrings = {
                "Cat", "hello", "olleh", "world", "dlrow", "java", "avaj",
                "hash", "shah", "code", "decode",
        };


        System.out.println("Cat".hashCode()); // Here for testing purposes
        System.out.println("decode".hashCode()); // Here for testing purposes
        System.out.println("String\t\tbadHash\t\tbetterHash\t\thashCode");
        for (String s : testStrings) {
            System.out.printf("%-10s\t%-10d\t%-12d\t%-10d\n",
                    s, badHash(s), betterHash(s), javaHashCode(s));
        }
    }
}
