package View;

import Controller.Converter;
import Shared.Constants.Menu;

import java.util.Scanner;

public class ViewConvert {
    public static Scanner sc = new Scanner(System.in);

    public void printMenu(){
        printDivider();
        System.out.println(Menu.TITLE);
        System.out.println();
        System.out.println(Menu.OPTIONS);
        System.out.println();
        printDivider();
    }

    public int getValueOption(){
        System.out.println(Menu.INPUT_OPTION);
        var valueOption = sc.nextLine();
        if(!isValidOption(valueOption)){
            System.out.println(Menu.OPTIONS);
            return -1;
        }
        return Integer.parseInt(valueOption);
    }

    public double getValueConvert(){
        System.out.println(Menu.INPUT_VALUE);
        var valueConvert = sc.nextLine();
        if(!isValidValue(valueConvert)){
            return -1;
        }
        return Double.parseDouble(valueConvert);
    }

    public void processConvert(int numberOption, double valueConvert){
        if(numberOption != -1 && valueConvert != -1){
            var controller = new Converter();
            var codes = controller.getCodesConvert(numberOption);
            var response = controller.getResponse(codes, valueConvert);

            if(!response.isSuccess()){
                System.out.println(Menu.ERROR_MESSAGE);
            }else{
                System.out.printf((Menu.SUCCESS_MESSAGE) + "%n", valueConvert, codes[0], response.getValueConvert(), codes[1]);
            }
            System.out.println();
        }
    }

    public void printExit(){
        System.out.println(Menu.EXIT_MESSAGE);
    }

    /* PRIVATE METHODS */
    private static void printDivider(){
        System.out.println("******************************************");
        System.out.println();
    }

    private static boolean isValidOption(String valueOption){
        if(valueOption.isBlank()){
            return false;
        }

        try{
            var numberOption = Integer.parseInt(valueOption);
            if(numberOption < 0 || numberOption > 7){
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    private static boolean isValidValue(String valueConvert){
        if(valueConvert.isBlank()){
            return false;
        }

        try{
            var numberOption = Double.parseDouble(valueConvert);
            if(numberOption < 0){
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
