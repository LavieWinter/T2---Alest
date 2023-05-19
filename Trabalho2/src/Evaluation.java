public class Evaluation {
    private Patient patient;
    private boolean working;
    private int roundsLeft;

    public Evaluation() {
        this.roundsLeft = 0;
        this.working = false;
        this.patient = null;
    }

    public void insert(Patient patient) {
        working = true;
        roundsLeft = (int)(Math.random()*3);
        this.patient = patient;
    }
    
    public Patient remove() {
        working = false;
        return patient;
    }
    
    public void passTime() {
        roundsLeft--;
    }
    
    public int roundsLeft(){
        return roundsLeft;
    }

    public boolean isWorking(){
        return working;
    }
}