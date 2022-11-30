import java.util.Objects;

public class OilSociety implements Status, Balance {
    private StatusSearch type;
    private int Cost;
    private int BankShare;
    private int BankMoney;


    public OilSociety(StatusSearch type, int cost, int BankShare, int BankMoney) {
        this.type = type;
        this.Cost = cost;
        this.BankShare = BankShare;
        this.BankMoney = BankMoney;
    }

    public void SetCost(int c){
        if(getType().equals(StatusSearch.FOUND)){
            this.Cost = 10;
            System.out.println("Забил нефтяной фонтан и акции выросли до 10\nНефтяное общество утановило новую цену на акции: " + getCost() + " | " + toString());
        }
        else {
            this.Cost = c;
            System.out.println("Нефтяное общество утановило новую цену на акции: " + getCost() + " | " + toString());
        }
    }

    public int getCost(){
        return Cost;
    }

    public int getBankShare(){
        return this.BankShare;
    }

    public void setBankShare(int sum){
        this.BankShare = sum;
    }

    public StatusSearch getType() {
        return type;
    }

    public void setType(StatusSearch type) {
        this.type = type;
    }

    public int getBankMoney() {
        return BankMoney;
    }

    public void setBankMoney(int bankMoney) {
        BankMoney = bankMoney;
    }

    @Override
    public void ShowBalance() {
        System.out.println(toString());
    }

    @Override
    public void ChangeStatus() {
        if(getType().equals(StatusSearch.NORMAL)){
            setType(StatusSearch.FOUND);
        }
    }

    public void SellAllShare(){
        if (getType().equals(StatusSearch.FOUND)){
            setBankMoney(getBankMoney() + getBankShare() * getCost());
            setBankShare(0);
            System.out.println("Все акции распроданы");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OilSociety man = (OilSociety) o;
        return Objects.equals(BankMoney, man.BankMoney) &&
                Objects.equals(BankShare, man.BankShare) &&
                Objects.equals(Cost, man.Cost) &&
                type == man.type;
    }

    @Override
    public int hashCode(){
        return Objects.hash(type, BankMoney, BankShare, Cost);
    }

    @Override
    public String toString(){
        return "Доступное кол-во акций - "+getBankShare()+" | Баланс нефтяного общества - "+getBankMoney()+"";
    }
}
