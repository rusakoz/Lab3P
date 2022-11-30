import java.util.Objects;

public class PeopleBlackDay extends People implements Status, Balance, ShareAction {

    public PeopleBlackDay(){
    }
    public PeopleBlackDay(int SaveMoney, int NumberOfShare, StatusPeople type){
        super(SaveMoney, NumberOfShare, type);
    }

    public PeopleBlackDay(String name, int SaveMoney, int NumberOfShare, StatusPeople type){
        super(name, SaveMoney, NumberOfShare, type);
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
    public void BuyAllShare(OilSociety a) {
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
    public void BuyShare(int count, OilSociety a) {

    }

    @Override
    public void SellShare(int count, OilSociety a){
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
