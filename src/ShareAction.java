
public interface ShareAction {
    default void BuyShare(int count, Society.PlantSociety a){}
    default void BuyShare(int count, Society.OilSociety a){}
    default void SellShare(int count, Society.OilSociety a){}
    default void BuyAllShare(Society.OilSociety a){}
}
