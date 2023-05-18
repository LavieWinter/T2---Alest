public class App {
    public static void main(String[] args){
        emergencyRoom(500);
    }

    public static void emergencyRoom(int rounds){        
        WaitingRoom wRoom = new WaitingRoom();
        int perda = 0;

        Evaluation sala1 = new Evaluation();

        for(int i = 0; i < rounds; i++){
            double chance = Math.random();
            if(chance >= 0.5){
                if(!wRoom.enterRoom()){
                    perda++;
                    System.out.println(perda);
                    System.out.println(wRoom.size());
                };
            }
            if(wRoom.size() != 0){
                if(!sala1.isWorking()){
                    sala1.insere(wRoom.leaveRoom());
                }
            }
            if(sala1.roundsLeft() == 0){
                Patient aux = sala1.remove();
            }
        }
        wRoom.print();
    }
}