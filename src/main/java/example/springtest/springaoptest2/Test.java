package example.springtest.springaoptest2;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class Test {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @org.junit.Test
    public void test() {
//        System.out.println(LocalDate.now().getMonth().getValue());
//        System.out.println(LocalDateTime.now().getMonth().getValue());
//        System.out.println(LocalDateTime.now().toString().substring(5,7));
//        System.out.println( LocalDate.parse(LocalDate.now().format("yyyy-MM-dd HH:mm:ss")).getMonthValue());
//        String yearMonth = LocalDateTime.now().getYear() + "" + LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER)).getMonthValue();
//        System.out.println(yearMonth+"-------");

//        LocalDateTime gmtModifiedDate = LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(gmtModifiedDate.getMonthValue());
//        System.out.println(LocalDateTime.now());
//        Calendar now = Calendar.getInstance();
//        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));

        User monthVo = new User("123.324");
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        monthVo.setProductPriceModify(nf.format(new BigDecimal(monthVo.getProductPriceModify())));
        if (monthVo.getProductPriceModify().substring(monthVo.getProductPriceModify().indexOf(".") + 1).equals("00")) {
            monthVo.setProductPriceModify(monthVo.getProductPriceModify().substring(0, monthVo.getProductPriceModify().indexOf(".")));
        }
        System.out.println(monthVo.getProductPriceModify());
    }



}
