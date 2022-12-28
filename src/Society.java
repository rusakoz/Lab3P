import java.util.Objects;

public abstract class Society {
    private StatusSociety type;
    private int Cost;
    private int BankShare;
    private int BankMoney;

    public Society(){}

    public Society(int cost, int BankShare, int BankMoney){
        this.Cost = cost;
        this.BankShare = BankShare;
        this.BankMoney = BankMoney;
    }

    public Society(StatusSociety type, int cost, int BankShare, int BankMoney) {
        this.type = type;
        this.Cost = cost;
        this.BankShare = BankShare;
        this.BankMoney = BankMoney;
    }

    public static class OilSociety extends Society implements Status, Balance {
        public OilSociety(StatusSociety type, int cost, int BankShare, int BankMoney) {
            super(type, cost, BankShare, BankMoney);
        }

        @Override
        public void setCost(int c) {
            if (getType().equals(StatusSociety.FOUND)) {
                super.setCost(10);
                System.out.println("Забил нефтяной фонтан и акции выросли до 10\nНефтяное общество утановило новую цену на акции: " + getCost() + " | " + toString());
            } else {
                super.setCost(c);
                System.out.println("Нефтяное общество утановило новую цену на акции: " + getCost() + " | " + toString());
            }
        }

        @Override
        public void ShowBalance() {
            System.out.println(toString());
        }

        @Override
        public void ChangeStatus() {
            if (getType().equals(StatusSociety.NORMAL)) {
                setType(StatusSociety.FOUND);
            }
        }

        public void SellAllShare() {
            if (getType().equals(StatusSociety.FOUND)) {
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
            return Objects.equals(getBankMoney(), man.getBankMoney()) &&
                    Objects.equals(getBankShare(), man.getBankShare()) &&
                    Objects.equals(getCost(), man.getCost()) &&
                    getType() == man.getType();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getType(), getBankMoney(), getBankShare(), getCost());
        }

        @Override
        public String toString() {
            return "Доступное кол-во акций - " + getBankShare() + " | Баланс нефтяного общества - " + getBankMoney() + "";
        }
    }

    public static class PlantSociety extends Society implements Balance{
        public PlantSociety(StatusSociety type, int cost, int BankShare, int BankMoney){
            super(type, cost, BankShare, BankMoney);
        }
        public PlantSociety(){}

        @Override
        public void setType(StatusSociety type) {
            super.setType(type);
            if(type.equals(StatusSociety.OPEN)){
                System.out.println("Общество растений открыто");
            }
            if(type.equals(StatusSociety.CLOSE)){
                System.out.println("Общество растений закрыто");
            }
        }

        @Override
        public void ShowBalance() {
            System.out.println(toString());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PlantSociety man = (PlantSociety) o;
            return Objects.equals(getBankMoney(), man.getBankMoney()) &&
                    Objects.equals(getBankShare(), man.getBankShare()) &&
                    Objects.equals(getCost(), man.getCost()) &&
                    getType() == man.getType();
        }

        @Override
        public void setCost(int cost) {
            super.setCost(cost);
            System.out.println("Общество растений установило цену на акции: "+cost+" | "+toString());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getType(), getBankMoney(), getBankShare(), getCost());
        }

        @Override
        public String toString() {
            return "Доступное кол-во акций - " + getBankShare() + " | Баланс общества растений - " + getBankMoney() + "";
        }

    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getCost() {
        return Cost;
    }

    public int getBankShare() {
        return this.BankShare;
    }

    public void setBankShare(int sum) {
        this.BankShare = sum;
    }

    public StatusSociety getType() {
        return type;
    }

    public void setType(StatusSociety type) {
        this.type = type;
    }

    public int getBankMoney() {
        return BankMoney;
    }

    public void setBankMoney(int bankMoney) {
        BankMoney = bankMoney;
    }
}