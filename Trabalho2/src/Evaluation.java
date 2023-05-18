public class Evaluation {
    private int roundsLeft;
    private boolean working;
    private Patient patient;

    public Evaluation() {
        this.roundsLeft = 0;
        this.working = false;
        this.patient = null;
    }

    public void insere(Patient patient) {
        working = true;
        roundsLeft = (int)(Math.random()*2)+1;
        this.patient = patient;
    }

    public Patient remove() {
        this.working = false;
        return patient;
    }

    public int roundsLeft(){
        return roundsLeft;
    }

    public boolean isWorking(){
        return working;
    }
    // roundsLeft = (int)(Math.random()*3)+1;

}