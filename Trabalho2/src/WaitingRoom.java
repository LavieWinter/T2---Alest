public class WaitingRoom {
    private ArrayQueue<Patient> queue;
    private int openedComplaints;
    private double passedBy;
    private double totalTime;

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
        for(int i = 0; i < queue.size(); i++){
            Patient aux = queue.get(i);
            if(aux.getWaitTime() > 50 && !aux.complained()){
                aux.complain();
                openedComplaints++;
            }
            aux.waiting();
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

    public int size(){
        return queue.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int openedComplaints() {
        return openedComplaints;
    }

    public void setOpenComplaints(int num) {
        this.openedComplaints = num;
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