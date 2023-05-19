public class PriorityQueue {
    private LinkedQueue<Patient> red;
    private LinkedQueue<Patient> yellow;
    private LinkedQueue<Patient> green;
    private LinkedQueue<Patient> blue;

    public PriorityQueue() {
        this.red = new LinkedQueue<>();
        this.yellow = new LinkedQueue<>();
        this.green = new LinkedQueue<>();
        this.blue = new LinkedQueue<>();
    }

    public void add(Patient patient) {
        System.out.println("Paciente adicionado na fila de prioridade");
        //20% red
        //10% yellow
        //30% green
        //40% blue
    } 

    // public Patient remove() {

    // }

    public boolean isEmpty() {
        return red.isEmpty() && yellow.isEmpty() && green.isEmpty() && blue.isEmpty();
    }
}