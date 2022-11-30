public abstract class People {
    private String name;
    private int SaveMoney;
    private int NumberOfShare;
    private StatusPeople Type;

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
}