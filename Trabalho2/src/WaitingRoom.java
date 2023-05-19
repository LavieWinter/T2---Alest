public class WaitingRoom {
    private ArrayQueue<Patient> queue;
    private double passedBy;
    private double totalTime;
    private int openedComplaints;

    public WaitingRoom() {
        this.queue = new ArrayQueue<>(50);
        this.passedBy = 0;
        this.totalTime = 0;
        this.openedComplaints = 0;
    }

    public boolean enterRoom() {
        try {
            queue.enqueue(new Patient());
            passedBy++;
            return true;
        } catch (Exception e) {
            System.out.println("WaitingRoom.enterRoom(): " + e.getMessage());
            return false;
        }
    }

    public void stayIn() {
        for(int i = 0; i <= queue.size(); i++){
            queue.get(i).waiting();
        }
        totalTime += queue.size();
    }

    public Patient leaveRoom() {
        try {
            Patient aux = queue.dequeue();
            aux.reset();
            return aux;
        } catch (Exception e) {
            System.out.println("WaitingRoom.leaveRoom(): " + e.getMessage());
            return null;
        }
    }

    public void checkTime() {
        for(int i = 0; i <= queue.size(); i++){
            Patient aux = queue.get(i);
            if(aux.getWaitTime() > 50 && !aux.complained()){
                openedComplaints++;
                aux.complain();
            }
        }
    }

    public int size(){
        return queue.size();
    }

    public int openedComplaints() {
        return openedComplaints;
    }

    public double avgWaitTime() {
        return totalTime/passedBy;
    }

    public void print(){
        for(int i = 0; i < queue.size(); i++){
            System.out.println(i + ": " + queue.get(i).getWaitTime() + ", " + queue.get(i).complained());
        }
    }
}