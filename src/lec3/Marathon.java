package lec3;

class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };
        String fastest1 = "";
        String fastest2 = "";
        int f1 = 1000, f2 = 1000;
        System.out.println("All participant information:");
        for (int i = 0; i < names.length; i++) {
            if(times[i] < f1){
                fastest2 = fastest1;
                fastest1 = names[i];
                f2 = f1;
                f1 = times[i];
            }
            else if(times[i] < f2 && times[i] > f1){
                f2 = times[i];
                fastest2 = names[i];
            }
            System.out.println(names[i] + ": " + times[i]);
        }
        System.out.println("Fastest 1: " + fastest1 + " Time:" + f1);
        System.out.println("Fastest 2: " + fastest2 + " Time:" + f2);
    }
}