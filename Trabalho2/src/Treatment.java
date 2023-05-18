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
        this.patient = patient;
    }

    public void passTime() {
        if(roundsLeft == 0){
            endService();
        }
        else{
            roundsLeft--;
        }
    }

    public void endService() {
        working = false;
    }

    public boolean working(){
        return working;
    }
}