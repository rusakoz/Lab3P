
public interface ShareAction {
    public void BuyShare(int count, Society.PlantSociety a);
    public void BuyShare(int count, Society.OilSociety a);
    public void SellShare(int count, Society.OilSociety a);
    public void SellShare();
    public void BuyAllShare(Society.OilSociety a);
}
