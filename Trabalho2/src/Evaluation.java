public class Evaluation {
    private int roundsLeft;
    private boolean working;
    private Patient patient;

    public Evaluation() {
        this.roundsLeft = 0;
        this.working = false;
        this.patient = null;
    }

    public void insert(Patient patient) {
        working = true;
        roundsLeft = (int)(Math.random()*2)+1;
        this.patient = patient;
    }

    public void passTime() { //IMPLEMENTAR NO UML
        roundsLeft--;
    }

    public Patient remove() {
        working = false;
        return patient;
    }

    public int roundsLeft(){
        return roundsLeft;
    }

    public boolean isWorking(){
        return working;
    }
}