package temp;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp1 {

    String regEx ="[a-zA-Z0-9_]*";

    private static void splitBarcode(String targetStr, String splitStr, int fromIndex, List<String> list) {
        if (StringUtils.isEmpty(targetStr) || StringUtils.isEmpty(splitStr)) {
            return;
        }

        int index = targetStr.indexOf(splitStr, fromIndex);

        if (index != -1) {
            String unitNameString = targetStr.substring(fromIndex, index);
            list.add(unitNameString);
            splitBarcode(targetStr, splitStr, index + 1, list);
        } else {
            String unitNameString = targetStr.substring(fromIndex);
            list.add(unitNameString);
        }
    }
//     . - _

    public static void main(String[] args) {

        StringBuilder barcodeEffective = new StringBuilder();
        List<String> barcodes = Arrays.asList("123123");
        int tmp = 0;
        for (String barcode : barcodes) {
            barcodeEffective.append(barcode).append("|");
            tmp++;
        }
        System.out.println(barcodeEffective.substring(0,barcodeEffective.length() - 1));
    }

}
