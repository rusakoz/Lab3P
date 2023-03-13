
public class StatusShow {
    StatusShow(){
    }
    public void StatusPeople(People.PeopleTrade b, People.PeopleBlackDay a){
        if(b.getType().equals(StatusPeople.SMART) & a.getType().equals(StatusPeople.SMART)){
            System.out.println("Жители поняли, что акции со временем дорожают");
        }
    }
}
