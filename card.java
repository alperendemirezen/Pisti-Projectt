public class card {

    private int value;
    private String symbol;

    public card(int a,String b) {
        value=a;
        symbol=b;

    }
    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}
    public String getSymbol() {return symbol;}
    public void setSymbol(String symbol) {this.symbol = symbol;}
    public void copyCard(card x){
        this.value=x.getValue();
        this.symbol=x.getSymbol();
    }
}



