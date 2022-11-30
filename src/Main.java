public class Main {
    public static void main(String[] args) {
        PeopleBlackDay peopleOne = new PeopleBlackDay(51, 0, StatusPeople.STUPID);
        PeopleBlackDay peopleTwo = new PeopleBlackDay(541, 0, StatusPeople.STUPID);
        PeopleTrade trader = new PeopleTrade(541, 0, StatusPeople.STUPID);
        OilSociety oilSociety = new OilSociety(StatusSearch.NORMAL, 10054, 2000000, 10000000);
        StatusShow statusShow = new StatusShow();

        trader.ChangeStatus();
        peopleOne.ChangeStatus();
        peopleTwo.ChangeStatus();

        statusShow.StatusTraders(trader);
        statusShow.StatusBD(peopleOne, peopleTwo);
        statusShow.CheckStatusPeople();

        oilSociety.SetCost(1);
            trader.BuyShare(5, oilSociety);
            trader.ShowBalance();

        oilSociety.SetCost(2);
            trader.SellShare(5, oilSociety);
            trader.ShowBalance();

        oilSociety.SetCost(3);
            trader.BuyShare(10, oilSociety);
            trader.ShowBalance();

        oilSociety.SetCost(4);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

        oilSociety.SetCost(5);
            trader.BuyShare(20, oilSociety);
            trader.ShowBalance();

        oilSociety.ChangeStatus();

        oilSociety.SetCost(0);
            trader.SellShare(trader.getNumberOfShare(), oilSociety);
            trader.ShowBalance();
            peopleOne.BuyAllShare(oilSociety);
            peopleOne.ShowBalance();
            peopleTwo.BuyAllShare(oilSociety);
            peopleTwo.ShowBalance();

        oilSociety.SellAllShare();
        oilSociety.ShowBalance();
    }
}
