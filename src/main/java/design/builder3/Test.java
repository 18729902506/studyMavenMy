package design.builder3;

import java.time.format.DateTimeFormatter;

public class Test {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) {

//        Course course = new Course.CourseBuilder().buildCourseBook("java")
//                                                  .buildCourseVideo("123")
//                                                  .buildCoursePpt("gfds")
//                                                  .buildCourseName("sss").build();
//        System.out.println(course.toString());
//        LocalDate first = LocalDate.from(FORMATTER.parse("2019-01".replaceAll("-",".")+".01"));
        //当月最后一天
//        String end  = first.with(TemporalAdjusters.lastDayOfMonth()).toString().replaceAll("-",".");

//        System.out.println(end);

//        LocalDate firstDay = LocalDate.from(FORMATTER.parse("2019-12-01"));
//        String first = firstDay.toString().replaceAll("-",".") + ".01";
//        //当月最后一天
//        String end  = firstDay.with(TemporalAdjusters.lastDayOfMonth()).toString().replaceAll("-", ".");
//        System.out.println(first + "-" + end);

//        Double d = Double.valueOf(null);
//        System.out.println(d);

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list.toString());

        String url = "/account/statement/getAccountStatementPdf ";
        System.out.println("---"+url.trim()+"---");

        String url2 = " /account/statement/getAccountStatementPdf ";
        System.out.println("***"+url2.trim()+"***");

        System.out.println("%%%"+url2+"%%%");
    }
}
