public class PriorityQueue {
    private LinkedQueue<Patient> red; //20% 
    private LinkedQueue<Patient> yellow; //10%
    private LinkedQueue<Patient> green; //30%
    private LinkedQueue<Patient> blue; //40%
    private int openedComplaints;

    public PriorityQueue() {
        this.red = new LinkedQueue<>();
        this.yellow = new LinkedQueue<>();
        this.green = new LinkedQueue<>();
        this.blue = new LinkedQueue<>();
        this.openedComplaints = 0;
    }

    public void add(Patient patient) {
        int chance = (int)(Math.random()*10);
        if(chance >= 2){
            if(chance >= 3){
                if(chance >= 6){
                    blue.enqueue(patient);
                }
                else {
                    green.enqueue(patient);
                }
            }
            else {
                yellow.enqueue(patient);
            }
        }
        else {
            red.enqueue(patient);
        }
        System.out.println("Paciente adicionado na fila de prioridade");
    } 

    public Patient remove() {
        if(red.isEmpty()){
            if(yellow.isEmpty()){
                if(green.isEmpty()){
                    if(!blue.isEmpty()){
                        try {
                            return blue.dequeue();
                        } catch (Exception e) {
                            System.out.println("PriorityQueue.remove(): "+e.getMessage());
                        }
                    }
                }
                else {
                    try {
                        return green.dequeue();
                    } catch (Exception e) {
                        System.out.println("PriorityQueue.remove(): "+e.getMessage());
                    }
                }
            }
            else {
                try {
                    return yellow.dequeue();
                } catch (Exception e) {
                    System.out.println("PriorityQueue.remove(): "+e.getMessage());
                }
            }
        }
        else {
            try {
                return red.dequeue();
            } catch (Exception e) {
                System.out.println("PriorityQueue.remove(): "+e.getMessage());
            }
        }
        return null;
    }

    public void stayIn() {
        if(!red.isEmpty()){
            for(int i = 0; i < red.size(); i++){
                Patient aux = red.get(i);
                if(aux.getWaitTime() >= 10 && !aux.complained()){
                    aux.complain();
                    openedComplaints++;
                }
                aux.waiting();
            }
        }
        if(!yellow.isEmpty()){   
            for(int i = 0; i < yellow.size(); i++){
                Patient aux = yellow.get(i);
                if(aux.getWaitTime() >= 10 && !aux.complained()){
                    aux.complain();
                    openedComplaints++;
                }
                aux.waiting();
            }
        }
        if(!green.isEmpty()){
            for(int i = 0; i < green.size(); i++){
                Patient aux = green.get(i);
                if(aux.getWaitTime() >= 10 && !aux.complained()){
                    aux.complain();
                    openedComplaints++;
                }
                aux.waiting();
            }
        }
        if(!blue.isEmpty()){
            for(int i = 0; i < blue.size(); i++){
                Patient aux = blue.get(i);
                if(aux.getWaitTime() >= 10 && !aux.complained()){
                    aux.complain();
                    openedComplaints++;
                }
                aux.waiting();
            }
        }
        red.updateTotalTime();
        yellow.updateTotalTime();
        green.updateTotalTime();
        blue.updateTotalTime();
    }

    public boolean isEmpty() {
        return red.isEmpty() && yellow.isEmpty() && green.isEmpty() && blue.isEmpty();
    }
}