public class Main {
    public static void main(String[] args) {
        People.PeopleBlackDay peopleOne = new People.PeopleBlackDay(51, 0, StatusPeople.STUPID);
        People.PeopleTrade trader = new People.PeopleTrade(541, 0, StatusPeople.STUPID);
        People.PeopleTrade traderTwo = new People.PeopleTrade("NoName", 541, 0, Location.STREET);
        People.Shorty Shorty = new People.Shorty("Коротышка", 5351, 0, Location.STREET);
        People.ActionSellers Neznaika = new People.ActionSellers("Незнайка", 5351, 0, Location.PLANT_SOCIETY);
        People.ActionSellers Kozlik = new People.ActionSellers("Козлик", 5351, 0, Location.PLANT_SOCIETY);
        People.ActionExchanger Miga = new People.ActionExchanger("Мига", 5351, 0, Location.PLANT_SOCIETY);
        People.ActionExchanger Gulio = new People.ActionExchanger("Жулио", 5351, 0, Location.PLANT_SOCIETY);
        Society.OilSociety oilSociety = new Society.OilSociety(StatusSociety.NORMAL, 10054, 2000000, 10000000);
        Society.PlantSociety plantSociety = new Society.PlantSociety(StatusSociety.OPEN, 10054, 2000000, 10000000);
        Bank bank = new Bank(5123000, 2000000000);
        StatusShow statusShow = new StatusShow();

        try {
            plantSociety.setRate(3);
        } catch (ShareRateException ex) {
            System.err.println(ex.getMessage());
        }

        Shorty.ChangeLocation(Location.PLANT_SOCIETY);
        Shorty.BuyShare(314, plantSociety);
        Shorty.ChangeLocation(Location.STREET);
        Neznaika.SellShare();
        Kozlik.SellShare();
        Miga.ChangeLocation(Location.BANK);
        Miga.MoneyExchange(bank);
        bank.ShowBalance();
        Miga.ChangeLocation(Location.PLANT_SOCIETY);

        traderTwo.ChangeLocation(Location.PLANT_SOCIETY);

        trader.ChangeStatus();
        peopleOne.ChangeStatus();
        statusShow.StatusPeople(trader, peopleOne);

            oilSociety.setRate(1);
            trader.BuyShare(5, oilSociety);
            trader.ShowBalance();

            oilSociety.setRate(2);
            trader.SellShare(5, oilSociety);
            trader.ShowBalance();

            oilSociety.setRate(3);
            trader.BuyShare(10, oilSociety);
            trader.ShowBalance();

            oilSociety.setRate(4);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

            oilSociety.setRate(5);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

            oilSociety.ChangeStatus();

            oilSociety.setRate(32);
            trader.SellShare(trader.getNumberOfShare(), oilSociety);
            trader.ShowBalance();
            peopleOne.BuyAllShare(oilSociety);
            peopleOne.ShowBalance();

            oilSociety.SellAllShare();
            oilSociety.ShowBalance();

            Miga.AllSell();
            Gulio.AllSell();

            Output output = new Output() {
                @Override
                public void Output() {
                    System.out.println("--- Конец истории ---");
                }
            };
            output.Output();

    }
}
