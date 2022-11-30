import java.util.Objects;

public class PeopleTrade extends People implements Status, Balance, ShareAction {

    public PeopleTrade(){
    }
    public PeopleTrade(int SaveMoney, int NumberOfShare, StatusPeople type){
        super(SaveMoney, NumberOfShare, type);
    }

    public PeopleTrade(String name, int SaveMoney, int NumberOfShare, StatusPeople type){
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
    public void BuyShare(int count, OilSociety a){
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
    public void SellShare(int count, OilSociety a){
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
    public void BuyAllShare(OilSociety a) {

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