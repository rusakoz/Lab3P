public class Main {
    public static void main(String[] args) {
        People.PeopleBlackDay peopleOne = new People.PeopleBlackDay(51, 0, StatusPeople.STUPID);
        People.PeopleBlackDay peopleTwo = new People.PeopleBlackDay(541, 0, StatusPeople.STUPID);
        People.PeopleTrade trader = new People.PeopleTrade(541, 0, StatusPeople.STUPID);
        People.PeopleTrade traderTwo = new People.PeopleTrade("Ruslan",541, 0, Location.STREET);
        People.Shorty Shorty = new People.Shorty("Коротышка",5351, 0, Location.STREET);
        People.ActionSellers Neznaika = new People.ActionSellers("Незнайка",5351, 0, Location.PLANT_SOCIETY);
        People.ActionSellers Kozlik = new People.ActionSellers("Козлик",5351, 0, Location.PLANT_SOCIETY);
        People.ActionExchanger Miga = new People.ActionExchanger("Мига",5351, 0, Location.PLANT_SOCIETY);
        People.ActionExchanger Gulio = new People.ActionExchanger("Жулио",5351, 0, Location.PLANT_SOCIETY);
        Society.OilSociety oilSociety = new Society.OilSociety(StatusSociety.NORMAL, 10054, 2000000, 10000000);
        Society.PlantSociety plantSociety = new Society.PlantSociety(StatusSociety.OPEN, 10054, 2000000, 10000000);
        Bank bank = new Bank(300000000);
        StatusShow statusShow = new StatusShow();

        plantSociety.setCost(3);

        Shorty.setLocation(Location.PLANT_SOCIETY);
        Shorty.BuyShare(314, plantSociety);
        Shorty.setLocation(Location.STREET);
        Neznaika.SellShare();
        Kozlik.SellShare();
        Miga.setLocation(Location.BANK);
        Miga.MoneyExchange(bank);
        Miga.setLocation(Location.PLANT_SOCIETY);
        plantSociety.setType(StatusSociety.CLOSE);
        try {
        traderTwo.ChangeLocation(Location.PLANT_SOCIETY, plantSociety);
        } catch (StatusSocietyException a){
            System.out.println(a.getMessage());
            System.out.println("Проверяем открыто ли общество растений! - "+plantSociety.getType());
        }

        trader.ChangeStatus();
        peopleOne.ChangeStatus();
        peopleTwo.ChangeStatus();

        statusShow.StatusTraders(trader);
        statusShow.StatusBD(peopleOne, peopleTwo);
        statusShow.CheckStatusPeople();

        oilSociety.setCost(1);
            trader.BuyShare(5, oilSociety);
            trader.ShowBalance();

        oilSociety.setCost(2);
            trader.SellShare(5, oilSociety);
            trader.ShowBalance();

        oilSociety.setCost(3);
            trader.BuyShare(10, oilSociety);
            trader.ShowBalance();

        oilSociety.setCost(4);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

        oilSociety.setCost(5);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

        oilSociety.ChangeStatus();

        oilSociety.setCost(0);
            trader.SellShare(trader.getNumberOfShare(), oilSociety);
            trader.ShowBalance();
            peopleOne.BuyAllShare(oilSociety);
            peopleOne.ShowBalance();
            peopleTwo.BuyAllShare(oilSociety);
            peopleTwo.ShowBalance();

        oilSociety.SellAllShare();
        oilSociety.ShowBalance();

        Miga.AllSell();
        Gulio.AllSell();
    }
}
