import View.ViewConvert;

public class Main {
    public static void main(String[] args) {
        var view = new ViewConvert();
        while(true){
            view.printMenu();

            int numberOption;
            do{
                numberOption = view.getValueOption();
            }while(numberOption == -1);

            if(numberOption == 7){
                break;
            }

            double valueConvert;
            do{
                valueConvert = view.getValueConvert();
            }while(valueConvert == -1);

            view.processConvert(numberOption, valueConvert);
        }
        view.printExit();
    }
}