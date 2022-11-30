
public class StatusShow {
    private boolean g;
    private boolean g2;
    StatusShow(){
    }
    public void StatusTraders(PeopleTrade... a){
        int count3 = a.length;
        int count = 0;
        for (PeopleTrade peopleTrade : a) {
            if (peopleTrade.getType() == StatusPeople.SMART) {
                count += 1;
            }
        }
        this.g = count == count3;
    }
    public void StatusBD(PeopleBlackDay... b){
        int count4 = b.length;
        int count2 = 0;
        for (PeopleBlackDay peopleBlackDay : b) {
            if (peopleBlackDay.getType() == StatusPeople.SMART) {
                count2 += 1;
            }
        }
        this.g2 = count2 == count4;
    }
    public void CheckStatusPeople(){
        if(this.g == this.g2){
            System.out.println("Жители поняли, что акции со временем дорожают");
        }
        else
            System.out.println("Жители не поняли :(");
    }
}
