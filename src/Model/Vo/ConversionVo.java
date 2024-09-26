package Model.Vo;

import Model.Dto.GenericResponseDto;

public class ConversionVo {
    private boolean success;
    private double valueConvert;

    public ConversionVo() {}
    public ConversionVo(GenericResponseDto response) {
        this.success = response.result().equalsIgnoreCase("success");
        this.valueConvert = response.conversionResult();
    }

    public boolean isSuccess() {
        return success;
    }

    public double getValueConvert() {
        return valueConvert;
    }

    @Override
    public String toString() {
        return "ConversionVo{" +
                "success=" + this.success +
                ", valueConvert=" + this.valueConvert +
                '}';
    }
}
