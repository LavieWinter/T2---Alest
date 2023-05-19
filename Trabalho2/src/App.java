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
            double chance = Math.random();
            if(chance >= 0.5){
                if(!wRoom.enterRoom()){
                    lostPatients++;
                    System.out.println("lostPatients: "+lostPatients);
                };
            }
            System.out.println("round: "+i+" tam: "+wRoom.size());
            
            for(int j = 0; j < evalRooms.size(); j++){
                try {
                    Evaluation aux = evalRooms.get(j);
                    if(aux.isWorking() && (aux.roundsLeft() <= 0)){
                        pQueue.add(aux.remove());
                    }
                    if(!aux.isWorking()){
                        if(wRoom.size() != 0){ // IMPLEMENTAR METODO ISEMPTY() E BOTAR NO UML
                            aux.insert(wRoom.leaveRoom());
                            System.out.println("Paciente adicionado na triagem");
                        }
                    }
                } catch (Exception e) {
                    break;
                }
            }
            
            // if(wRoom.size() != 0){
                // if(!sala1.isWorking()){
                    // sala1.insert(wRoom.leaveRoom());
                // }
            // }
            // if(sala1.roundsLeft() == 0){
                // esse if pode ser substituído pela chamada de passTime()
                // Patient aux = sala1.remove();
            // }

            //Fix Patient's Wait Time
            wRoom.stayIn();
            for(int j = 0; j < evalRooms.size(); j++){
                try {
                    evalRooms.get(j).passTime();
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