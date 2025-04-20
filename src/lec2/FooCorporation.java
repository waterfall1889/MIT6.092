package lec2;

public class FooCorporation {
    public class Worker{
        int workingHours;
        double basicSalary;

        Worker(int workingHours, double basicSalary){
            this.workingHours = workingHours;
            this.basicSalary = basicSalary;
        }
    }

    public void calculateTotal(Worker[] workers){
        double total = 0;

        for(Worker worker : workers){
            if(worker.workingHours > 60){
                System.out.println("Error: working time is too long");
                return;
            }
            if(worker.basicSalary < 8.00){
                System.out.println("Error: basic salary is too low");
                return;
            }
            if(worker.workingHours <= 40){
                total += worker.basicSalary*worker.workingHours;
            }
            else{
                total += worker.basicSalary*40;
                total += (worker.workingHours-40)*worker.basicSalary*1.5;
            }

        }
        System.out.println("Total salary is " + total);
    }
    public static void main(String[] args) {
        FooCorporation corporation = new FooCorporation();
        Worker worker1 = corporation.new Worker(35,7.50);
        Worker worker2 = corporation.new Worker(47,8.20);
        Worker worker3 =  corporation.new Worker(73,10.00);
        Worker[] workers = new Worker[3];
        workers[0] = worker1;
        workers[1] = worker2;
        workers[2] = worker3;
        corporation.calculateTotal(workers);
    }
}
