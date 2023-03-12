public class Bank implements Balance{
    private int Money;
    private int SizeStorage;

    public Bank(int money, int sizeStorage){
        this.Money = money;
        this.SizeStorage = sizeStorage;
    }
    private class Storage {
        public void CapacityStorage() {
            System.out.println("Хранилище заполнено на " + getMoney() + " из " + getSizeStorage());
        }
    }

    @Override
    public void ShowBalance() {
        Storage storage = new Storage();
        storage.CapacityStorage();
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public int getSizeStorage() {
        return SizeStorage;
    }
}
