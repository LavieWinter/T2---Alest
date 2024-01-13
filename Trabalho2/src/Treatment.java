public class Treatment {
    private boolean working;
    private int roundsLeft;
    private Patient patient;

    public Treatment() {
        this.working = false;
        this.roundsLeft = 0;
        this.patient = null;
    }

    public void seePatient(Patient patient) {
        working = true;
        roundsLeft = (int)(Math.random()*4)+2;
        // System.out.println("new treat rounds left: "+roundsLeft);
        this.patient = patient;
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

    public void endService() {
        working = false;
    }
}