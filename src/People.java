import java.util.Objects;

public abstract class People {
    private String name;
    private int SaveMoney;
    private int NumberOfShare;
    private StatusPeople Type;
    private Location location;

    public People(){
    }
    protected People(int SaveMoney, int NumberOfShare, StatusPeople type){
        this.name = "Неизвестный житель";
        this.SaveMoney = SaveMoney;
        this.NumberOfShare = NumberOfShare;
        this.Type = type;
    }

    protected People(String name, int SaveMoney, int NumberOfShare, StatusPeople type){
        this.name = name;
        this.SaveMoney = SaveMoney;
        this.NumberOfShare = NumberOfShare;
        this.Type = type;
    }

    protected People(String name, int SaveMoney, int NumberOfShare, Location type){
        this.name = name;
        this.SaveMoney = SaveMoney;
        this.NumberOfShare = NumberOfShare;
        this.location = type;
    }


    public static class PeopleBlackDay extends People implements Status, Balance, ShareAction{

        public PeopleBlackDay(int SaveMoney, int NumberOfShare, StatusPeople type){
            super(SaveMoney, NumberOfShare, type);
        }

        @Override
        public void ShowBalance(){
            System.out.println("Баланс денег: "+super.getSaveMoney()+"\nБаланс акций: "+super.getNumberOfShare());
        }

        @Override
        public void ChangeStatus(){
            if(getType().equals(StatusPeople.STUPID)){
                setType(StatusPeople.SMART);
            }
        }

        @Override
        public void BuyAllShare(Society.OilSociety a) {
            int count = super.getSaveMoney() / a.getCost();
            if (a.getCost() == 10 & count >= 1){
                if (super.getSaveMoney() >= count * a.getCost()) {
                    a.setBankShare(a.getBankShare() - count);
                    a.setBankMoney(a.getBankMoney() + count * a.getCost());
                    super.setSaveMoney(super.getSaveMoney() - count * a.getCost());
                    super.setNumberOfShare(count);
                    System.out.println(""+getName()+" купил "+count+" акций");

                }
                else
                    System.out.println(""+getName()+" не имеет достаточно средств для покупки акций");
            }
        }

        @Override
        public void BuyShare(int count, Society.OilSociety a) {

        }

        @Override
        public void BuyShare(int count, Society.PlantSociety a) {

        }

        @Override
        public void SellShare() {

        }

        @Override
        public void SellShare(int count, Society.OilSociety a){
            System.out.println("Я никогда не продам эти акции :(");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PeopleBlackDay man = (PeopleBlackDay) o;
            return Objects.equals(getName(), man.getName()) &&
                    Objects.equals(getSaveMoney(), man.getSaveMoney()) &&
                    Objects.equals(getNumberOfShare(), man.getNumberOfShare()) &&
                    getType() == man.getType();
        }
        @Override
        public int hashCode(){
            return Objects.hash(getName(), getSaveMoney(), getNumberOfShare(), getType());
        }

        @Override
        public String toString(){
            return "";
        }
    }

    public static class PeopleTrade extends People implements Status, Balance, ShareAction{

        public PeopleTrade(int SaveMoney, int NumberOfShare, StatusPeople type){
            super(SaveMoney, NumberOfShare, type);
        }

        public PeopleTrade(String name, int SaveMoney, int NumberOfShare, Location type){
            super(name, SaveMoney, NumberOfShare, type);
        }
        public void ChangeLocation(Location location, Society.PlantSociety a) throws StatusSocietyException{
            if(a.getType() == StatusSociety.OPEN & location == Location.PLANT_SOCIETY) {
                super.setLocation(location);
                System.out.println(getName()+" вошел в общество растений");
            }
            else{
                throw new StatusSocietyException(getName()+" я не могу войти в общество растений");
            }
        }

        @Override
        public void ShowBalance(){
            System.out.println("Баланс денег: "+super.getSaveMoney()+"\nБаланс акций: "+super.getNumberOfShare());
        }

        @Override
        public void ChangeStatus(){
            if(getType().equals(StatusPeople.STUPID)){
                setType(StatusPeople.SMART);
            }
        }

        @Override
        public void BuyShare(int count, Society.PlantSociety a) {

        }

        @Override
        public void BuyShare(int count, Society.OilSociety a){
            if (super.getSaveMoney() >= count * a.getCost()) {
                a.setBankShare(a.getBankShare() - count);
                a.setBankMoney(a.getBankMoney() + count * a.getCost());
                super.setSaveMoney(super.getSaveMoney() - count * a.getCost());
                super.setNumberOfShare(super.getNumberOfShare() + count);
                System.out.println("Житель-трейдер купил "+count+" акций");

            }
            else
                System.out.println("Житель-трейдер не имеет достаточно средств для покупки акций");
        }

        @Override
        public void SellShare() {

        }

        @Override
        public void SellShare(int count, Society.OilSociety a){
            if(super.getNumberOfShare() > 0 & count <= super.getNumberOfShare()){
                a.setBankShare(a.getBankShare() + count);
                a.setBankMoney(a.getBankMoney() - count * a.getCost());
                super.setSaveMoney(super.getSaveMoney() + count * a.getCost());
                super.setNumberOfShare(super.getNumberOfShare() - count);
                System.out.println(""+getName()+"-трейдер продал "+count+" акций");
            }
            else
                System.out.println("У "+getName()+" нет акций");
        }

        @Override
        public void BuyAllShare(Society.OilSociety a) {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PeopleTrade man = (PeopleTrade) o;
            return Objects.equals(getName(), man.getName()) &&
                    Objects.equals(getSaveMoney(), man.getSaveMoney()) &&
                    Objects.equals(getNumberOfShare(), man.getNumberOfShare()) &&
                    getType() == man.getType();
        }
        @Override
        public int hashCode(){
            return Objects.hash(getName(), getSaveMoney(), getNumberOfShare(), getType());
        }

        @Override
        public String toString(){
            return "";
        }
    }

    public static class Shorty extends People implements Balance, ShareAction{

        public Shorty(String name, int SaveMoney, int NumberOfShare, Location type){
            super(name, SaveMoney, NumberOfShare, type);
        }

        @Override
        public void setLocation(Location location) {
            super.setLocation(location);
            if(location.equals(Location.STREET)) {
                System.out.println(getName() + " вышел на улицу");
            }
            if(location.equals(Location.PLANT_SOCIETY)) {
                System.out.println(getName() + " пришел в общество растений");
            }
        }

        @Override
        public void ShowBalance(){
            System.out.println("Баланс денег: "+super.getSaveMoney()+"\nБаланс акций: "+super.getNumberOfShare());
        }

        @Override
        public void BuyShare(int count, Society.OilSociety a) {

        }

        @Override
        public void BuyShare(int count, Society.PlantSociety a){
            if (super.getSaveMoney() >= count * a.getCost()) {
                a.setBankShare(a.getBankShare() - count);
                a.setBankMoney(a.getBankMoney() + count * a.getCost());
                super.setSaveMoney(super.getSaveMoney() - count * a.getCost());
                super.setNumberOfShare(super.getNumberOfShare() + count);
                System.out.println(getName()+" купил "+count+" акций");

            }
            else
                System.out.println(getName()+" не имеет достаточно средств для покупки акций");
        }

        @Override
        public void SellShare() {

        }

        @Override
        public void SellShare(int count, Society.OilSociety a){
        }

        @Override
        public void BuyAllShare(Society.OilSociety a) {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shorty man = (Shorty) o;
            return Objects.equals(getName(), man.getName()) &&
                    Objects.equals(getSaveMoney(), man.getSaveMoney()) &&
                    Objects.equals(getNumberOfShare(), man.getNumberOfShare()) &&
                    getLocation() == man.getLocation();
        }
        @Override
        public int hashCode(){
            return Objects.hash(getName(), getSaveMoney(), getNumberOfShare(), getType());
        }

        @Override
        public String toString(){
            return "";
        }
    }

    public static class ActionSellers extends People{

        public ActionSellers(String name, int SaveMoney, int NumberOfShare, Location type){
            super(name, SaveMoney, NumberOfShare, type);
        }

        public void SellShare(){
            System.out.println(getName()+toString());
        }

        @Override
        public String toString(){
            return " продает акции общества растений";
        }
    }

    public static class ActionExchanger extends People implements Balance{

        public ActionExchanger(String name, int SaveMoney, int NumberOfShare, Location type){
            super(name, SaveMoney, NumberOfShare, type);
        }

        public void AllSell(){
            System.out.println(getName()+" пустил в продажу оставшиеся акции");
        }

        @Override
        public void setLocation(Location location) {
            super.setLocation(location);
            if(location.equals(Location.BANK)) {
                System.out.println(getName() + " пришел в банк");
            }
            if(location.equals(Location.PLANT_SOCIETY)) {
                System.out.println(getName() + " пришел в общество растений");
            }
        }

        public void MoneyExchange(Bank a){
            a.setMoney(a.getMoney()+getSaveMoney());
            setSaveMoney(getSaveMoney() / 10);
            System.out.println(getName()+" обменял мелкие деньги на крупные");
        }

        @Override
        public void ShowBalance(){
            System.out.println("Баланс денег: "+super.getSaveMoney()+"\nБаланс акций: "+super.getNumberOfShare());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ActionExchanger man = (ActionExchanger) o;
            return Objects.equals(getName(), man.getName()) &&
                    Objects.equals(getSaveMoney(), man.getSaveMoney()) &&
                    Objects.equals(getNumberOfShare(), man.getNumberOfShare()) &&
                    getLocation() == man.getLocation();
        }
        @Override
        public int hashCode(){
            return Objects.hash(getName(), getSaveMoney(), getNumberOfShare(), getType());
        }

    }

    public int getSaveMoney() {
        return SaveMoney;
    }

    public void setSaveMoney(int saveMoney) {
        SaveMoney = saveMoney;
    }

    public StatusPeople getType() {
        return this.Type;
    }

    public void setType(StatusPeople type) {
        this.Type = type;
    }

    public int getNumberOfShare() {
        return NumberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        NumberOfShare = numberOfShare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}