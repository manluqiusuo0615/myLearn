package learn.enumeration;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 9:48
 */
public enum Coin {
    penny("hello"),nickel("world"),
    dime("welcome"),quarter("hello world");
    private String value;
    public String getValue(){
        return value;
    }
    Coin(String value){
        this.value = value;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Coin coin = Coin.quarter;
        System.out.println(coin.getValue());
        coin.setName("四分之一");
        System.out.println("===="+coin.getName());
    }
}
