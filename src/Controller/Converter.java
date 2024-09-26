package Controller;

import Model.Vo.ConversionVo;
import Shared.Constants.Option;
import Api.ApiExchange;

public class Converter {

    public String[] getCodesConvert(int numberOperation){
        var operation = switch (numberOperation) {
            case 1 -> Option.DOLAR_A_PESO_ARG;
            case 2 -> Option.PESO_ARG_A_DOLAR;
            case 3 -> Option.DOLAR_A_REAL_BRA;
            case 4 -> Option.REAL_BRA_A_DOLAR;
            case 5 -> Option.DOLAR_A_PESO_COL;
            case 6 -> Option.PESO_COL_A_DOLAR;
            default -> "";
        };
        return operation.split("_");
    }

    public ConversionVo getResponse(String[] codes, double valueConvert){
        var api = new ApiExchange();
        return api.convert(codes, valueConvert);
    }
}
