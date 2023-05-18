public class Patient {
    private int waitTime;
    private boolean complained;
    
    public Patient() {
        this.waitTime = 0;
        this.complained = false;
    }

    public void waiting() {
        waitTime++;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void complain() {
        complained = true;
    }

    public boolean complained() {
        return complained;
    }

    public void reset() {
        waitTime = 0;
        complained = false;
    }
}