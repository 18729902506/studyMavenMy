package com.streatest.testthree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,700),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //找出2011年的所有交易并按照交易额排序(从低到高)，（先过滤出2011年，再对交易额进行排序）
        List<Transaction> trans2011  =  transactions.stream()
                                                    .filter(transaction -> transaction.getYear() == 2011)
                                                    .sorted(Comparator.comparing(Transaction::getValue))
                                                    .collect(Collectors.toList());

        //交易员都在哪些不同的城市工作过（拿到交易员的城市，在进行去重操作）
        List<String> cities = transactions.stream()
                                          .map(transaction -> transaction.getTrader().getCity())
                                          .distinct()
                                          .collect(Collectors.toList());


        //查找出所有来自剑桥的交易员，并按姓名排序
        List<Trader> trade = transactions.stream()
                                        //从交易中提取出所有的交易员
                                         .map(Transaction::getTrader)
                                         .filter(trader -> trader.getCity().equals("Cambridge"))
                                         .distinct()
                                         .sorted(Comparator.comparing(Trader::getName))
                                         .collect(Collectors.toList());

        //返回所有交易员的姓名字符串，并按字母排序
        String traderStr =
                transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                        //逐个拼接每个名字，得到一个将所有名字连接起来的String
                            .reduce(" ",(n1,n2) -> n1 + n2);

        //有没有是在米兰工作的
        boolean milanBased =
                transactions.stream()
                            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                    .filter(t -> ("Cambridge").equals(t.getTrader().getCity()))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);

        //所有交易中，最高的交易额是多少
        Optional<Integer> highestValue =
                transactions.stream()
                            .map(Transaction::getValue)
                        //计算生成的流中最大的值
                            .reduce(Integer::max);

        //找到交易额最小的交易
        Optional<Transaction> samllestTransaction = transactions.stream()
                                                                .min(Comparator.comparing(Transaction::getValue));
    }
}
