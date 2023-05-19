public class App {
    public static void main(String[] args) {
        emergencyRoom(500);
    }

    private static void emergencyRoom(int rounds) {
        //Instantiate necessary variables   
        WaitingRoom wRoom = new WaitingRoom();

        ArrayList<Evaluation> evalRooms = new ArrayList<>();
        evalRooms.add(new Evaluation());

        PriorityQueue pQueue = new PriorityQueue();
        
        ArrayList<Treatment> treatRooms = new ArrayList<>();
        treatRooms.add(new Treatment());
        
        //Rounds for loop
        int lostPatients = 0;
        for(int i = 0; i < rounds; i++){
            //Patient Might Enter Emergency Room
            double chance = Math.random();
            if(chance >= 0.5){
                if(!wRoom.enterRoom()){
                    lostPatients++;
                    System.out.println("lostPatients: "+lostPatients);
                };
            }
            System.out.println("round: "+i+" tam: "+wRoom.size());
            
            //Patient Might be Called for Evaluation
            for(int j = 0; j < evalRooms.size(); j++){
                try {
                    Evaluation eval = evalRooms.get(j);
                    if(eval.isWorking() && (eval.roundsLeft() <= 0)){
                        pQueue.add(eval.remove());
                    }
                    if(!eval.isWorking()){
                        if(!wRoom.isEmpty()){
                            eval.insert(wRoom.leaveRoom());
                            System.out.println("Paciente adicionado na triagem");
                        }
                    }
                } catch (Exception e) {
                    break;
                }
            }
            
            //Patient Might See the Doctor
            for(int j = 0; j < treatRooms.size(); j++){
                try {
                    Treatment treat = treatRooms.get(j);
                    if(treat.isWorking() && (treat.roundsLeft() <= 0)){
                        treat.endService();
                    }
                    if(!treat.isWorking()){
                        if(!pQueue.isEmpty()){
                            treat.seePatient(pQueue.remove());
                            System.out.println("Paciente sendo atendido");
                        }
                    }
                } catch (Exception e) {
                    break;
                }
            }

            //Fix Patient's Wait Time
            wRoom.stayIn();
            for(int j = 0; j < evalRooms.size(); j++){
                try {
                    evalRooms.get(j).passTime();
                } catch (Exception e) {
                    break;
                }
            }
            pQueue.stayIn();
            for(int j = 0; j < treatRooms.size(); j++){
                try {
                    treatRooms.get(j).passTime();
                } catch (Exception e) {
                    break;
                }
            }
        }
        // wRoom.print();

        //Log Reports
        System.out.println("Report (a):");
        System.out.println("\tPatients Lost due to Full Waiting Room: " + lostPatients);
        System.out.println("Report (b):");
        System.out.println("\tAvg Wait Time in Waiting Room: " + wRoom.avgWaitTime());
        System.out.println("\tAvg Wait Time in Red Queue: " + "TO COMPLETE");
        System.out.println("\tAvg Wait Time in Yellow Queue: " + "TO COMPLETE");
        System.out.println("\tAvg Wait Time in Green Queue: " + "TO COMPLETE");
        System.out.println("\tAvg Wait Time in Blue Queue: " + "TO COMPLETE");
        System.out.println("Report (c):");
        System.out.println("\tNumber of Personnel Working in Evaluation: " + evalRooms.size());
        System.out.println("\tNumber of Doctors Working in Treatment: " + treatRooms.size());
    }
}