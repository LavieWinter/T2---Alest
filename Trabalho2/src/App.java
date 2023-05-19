public class App {
    public static void main(String[] args){
        emergencyRoom(500);
    }

    public static void emergencyRoom(int rounds){
        //Inicializar o necessario para o programa     
        WaitingRoom wRoom = new WaitingRoom();

        ArrayList<Evaluation> evalRooms = new ArrayList<>();
        evalRooms.add(new Evaluation());

        PriorityQueue queue = new PriorityQueue();
        
        ArrayList<Treatment> treatRooms = new ArrayList<>();
        treatRooms.add(new Treatment());
        
        //rounds for loop
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
            // if(wRoom.size() != 0){
                // if(!sala1.isWorking()){
                    // sala1.insert(wRoom.leaveRoom());
                // }
            // }
            // if(sala1.roundsLeft() == 0){
                // esse if pode ser substituído pela chamada de passTime()
                // Patient aux = sala1.remove();
            // }
            
        }
        wRoom.print();
    }
}