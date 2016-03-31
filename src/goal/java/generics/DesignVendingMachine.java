package goal.java.generics;

public class DesignVendingMachine {

    public static void main(String[] args) {
        Coin coinUS = new CoinUS("USCoin");
        Coin coinUK = new CoinUK("UKCoin");
        System.out.println(coinUS.getCoinType() + "--" + coinUK.getCoinType());
    }

}

interface Coin {

    public Coin getCoin();

    public String getCoinType();
}

interface Product {
    public void setProduct(Product product);

    public Product getProduct();
}

class CoinUS implements Coin {

    String coinType;

    public CoinUS(String coinType) {
        this.coinType = coinType;
    }

    @Override
    public Coin getCoin() {
        return this;
    }

    @Override
    public String getCoinType() {
        return coinType;
    }

}

class CoinUK implements Coin {

    String coinType;

    public CoinUK(String string) {
        coinType = string;
    }

    @Override
    public Coin getCoin() {
        return this;
    }

    @Override
    public String getCoinType() {
        return coinType;
    }

}
