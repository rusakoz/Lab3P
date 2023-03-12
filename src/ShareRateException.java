public class ShareRateException extends Exception{
    public ShareRateException(int m){
        super("Стоимость акций не может быть меньше нуля, заданное значение -  " + m);
    }
}
