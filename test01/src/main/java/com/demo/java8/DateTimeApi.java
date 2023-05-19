package com.demo.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: workspace-IDEAInit
 * @description: java8新的datetimeapi
 * @author: lzz
 * @create: 2022-03-03 10:23
 *
 * 1.获取当前时间
 * LocalDate d = LocalDate.now(); // 当前日期
 * LocalTime t = LocalTime.now(); // 当前时间
 * LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
 *
 * 2.指定的日期和时间创建
 * // 指定各独立的日期和时间:
 * LocalDate d2 = LocalDate.of(2022, 4, 20); // 2022-04-20, 注意04=4月
 * LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
 * LocalDateTime dt2 = LocalDateTime.of(2022, 4, 20, 15, 16, 17);//2022-04-20T15:16:17
 * LocalDateTime dt3 = LocalDateTime.of(d2, t2);//2022-04-20T15:16:17
 *
 * //传入时间字符串
 * LocalDate d = LocalDate.parse("2022-04-20");
 * LocalTime t = LocalTime.parse("15:16:17");
 * LocalDateTime dt3 = LocalDateTime.parse(" 2022-04-20 15:16:17");
 *
 * 3.加减日期
 * LocalDateTime dt = LocalDateTime.now();
 * // 加1天减1小时:
 * LocalDateTime dt2 = dt.plusDays(1).minusHours(1);
 * // 减1月:
 * LocalDateTime dt3 = dt2.minusMonths(1);
 * System.out.println(dt3);
 * //对时间进行操作，出现跨年、跨月操作时，时间会自动进行转换，比如：2019-10-31减去1个月得到的结果是2019-09-30，因为9月没有31日
 *
 * 4.时间调整
 * 对日期和时间进行调整则使用withXxx()方法，例如：withHour(15)会把10:11:12变为15:11:12：
 * 调整年：withYear()
 * 调整月：withMonth()
 * 调整日：withDayOfMonth()
 * 调整时：withHour()
 * 调整分：withMinute()
 * 调整秒：withSecond()
 *
 * LocalDate dt = LocalDate.of(2020, 3, 31); //2020-03-31
 * System.out.println(dt);
 * // 月份变为4:
 * LocalDate dt3 = dt.withMonth(4);
 * System.out.println(dt3); //2020-04-30
 * //对时间进行操作，出现跨年、跨月操作时，时间会自动进行转换，比如：2020-03-31调整为4个月得到的结果是2020-04-30，因为4月没有31日。
 *
 * 5、时间调整进阶配合 TemporalAdjusters
 *
 * 通过with()可以进行更加复杂的运算
 *
 *  dayOfWeekInMonth //它的值为同一个月中每一周的第几天
 *  firstDayOfMonth //它的值为当月的第一天
 *  firstDayOfNextMonth //它的值为下月的第一天
 *  firstDayOfNextYear //它的值为明年的第一天
 *  firstDayOfYear //它的值为当年的第一天
 *  firstInMonth //它的值为同一个月中，第一个符合星期几要求的值
 *  lastDayOfMonth //它的值为当月的最后一天
 *  lastDayOfYear //它的值为今年的最后一天
 *  //对指定星期的操作 - DayOfWeek
 *  lastInMonth //它的值为同一个月中，符合星期几要求的值
 *  next/previous//将日期向前一周或者向后一周，调整到指定星期几
 *  nextOrSame/previousOrSame //将日期向前或者向后，调整到指定星期几(如当前日期不存在于调整周的区间内则跨周)，比如调整到周四，如果当天周二，则为本周周四;如果当天周五，则为下周四
 *
 * //实列
 * LocalDate dt = LocalDate.now();
 * //明年的第一天
 * System.out.println(dt.with(TemporalAdjusters.firstDayOfNextYear()));
 * //两周后的周五
 * System.out.println(dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusWeeks(1));
 *
 * 6、时区操作
 *
 * ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区时间
 * ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));//指定时区获取当前时间
 *
 * //atZone时区转换，通过ZoneId指定要转换到的时区
 * //LocalDateTime转ZonedDateTime
 * LocalDateTime ldt = LocalDateTime.now();
 * //2020-04-15T15:16:17+08:00[Asia/Shanghai] 获取吗默认时区
 * ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
 * //2020-04-15T03:16:17-04:00[America/New_York]，与美国差12小时
 * ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));
 *
 * //时区转换
 * //转为指定时区时间
 * ZonedDateTime zny = ldt.withZoneSameInstant(ZoneId.of("America/New_York"));
 * //转为当前时区时间
 * LocalDateTime date = zny.toLocalDateTime();
 *
 * 7、时间戳操作
 *
 * System.currentTimeMillis();//毫秒级时间戳
 * Instant now = Instant.now();
 * System.out.println(now.getEpochSecond()); // 秒
 * System.out.println(now.toEpochMilli()); // 毫秒
 * Instant.ofEpochSecond(value);//设置秒时间戳
 * Instant.ofEpochMilli(value);//设置毫秒时间戳
 *
 *
 * //当前时间戳转换为指定时区
 * Instant ins = Instant.now();
 * ZonedDateTime zdt = ins.atZone(ZoneId.of("America/New_York"))
 *
 * //时间戳转LocalDateTime
 * LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTime), ZoneId.systemDefault());
 *
 * 8、日期格式化
 *
 * LocalDateTime dt = LocalDateTime .now();
 * DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 * System.out.println(dateTimeFormatter.format(dt));
 *
 * 9、时间差
 *
 * LocalDate startDate=startDate;
 * LocalDate endDate=endDate;
 * long y = ChronoUnit.YEARS.between(startDate, endDate); //获取两个日期间隔年
 * long m = ChronoUnit.MONTHS.between(startDate, endDate);//获取两个日期间隔月
 * long d = ChronoUnit.DAYS.between(startDate, endDate); //获取两个日期间隔天
 *
 *
 */
public class DateTimeApi {

    public static void main(String[] args) {
        Date date = new Date();
        LocalDate localDate = dateToLocalDate(date);
        LocalDateTime localDateTime = dateToLocalDateTime(date);

        System.err.println("date:"+date);
        System.err.println("localDate:"+localDate);
        System.err.println("localDateTime:"+localDateTime);
    }

    /**
     * 时间戳转日期字符串
     * @param time
     * @return
     */
    public static String timeStampToDate(String time){
        if(null!=time&&!"".equals(time)){
            long parseLong = Long.parseLong(time);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(parseLong), ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return dateTimeFormatter.format(localDateTime);
        }

        return null;
    }

    //新旧date api相互装换
    //localDateToDate
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    //localDateTimeToDate
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    //dateToLocalDate
    public static LocalDate dateToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    //dateToLocalDateTime
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
