package assignment1;

public class Person {
    private int birth;
    private int death;

    public Person(int birth, int death) {
        if(birth>death) throw new IllegalArgumentException("NV");
        this.birth = birth;
        this.death = death;
    }

    public int getBirth() {
        return birth;
    }

    public int getDeath() {
        return death;
    }

    public class Cencus {
        public int livingyears(Person[] people, int start, int end) {
            if(start>end) throw new IllegalArgumentException("Invalid input");

            int bestYear = 0;
            int maxCount = 0;

            for(int year=start; year<=end; year++) {
                int count = 0;
                for (Person person : people) {
                    if (person.getBirth() <= year && person.getDeath() >= year){
                        count ++;
                    }
                }

                if(count > maxCount){
                    maxCount = count;
                    bestYear = year;
                }
            }
            return bestYear;
        }
    }
}


