import java.util.Date;

public class KHQ3 {
    long nowTime;

    public KHQ3() {
        this.nowTime = System.currentTimeMillis();
    }
    @Override
    public String toString() {
        return String.valueOf(nowTime);
    }
    public String toDate(long unixTimeStamp) {
        int days = (int) (unixTimeStamp / 86400) + 1;
        long remianingSecond = unixTimeStamp % 86400;
        long remianingSecond2 = remianingSecond % 3600;
        int periodicity = days / 1461;
        int remainingDay = days % 1461;
        int year = 1970 + periodicity * 4;
        boolean leapyear = false;
        if (remainingDay < 365) {
        } else if (remainingDay < 365 * 2) {
            year += 1;
            remainingDay -= 365;
        } else if (remainingDay < 365 * 3) {
            year += 2;
            remainingDay -= 365 * 2;
            leapyear = true;
        } else {
            year += 3;
            remainingDay -= 365 * 2 + 366;
        }
        int[] month1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] trueMonth = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (leapyear) {
            for (int a = 0; a < trueMonth.length; ++a) {
                trueMonth[a] = month2[a];
            }
        } else {
            for (int a = 0; a < trueMonth.length; ++a) {
                trueMonth[a] = month1[a];
            }
        }
        int month = 0, day = 0;
        for (int a = 0; a < 12; ++a) {
            int temp = remainingDay - trueMonth[a];
            if (temp <= 0) {
                month = a + 1;
                if (temp == 0) {
                    day = trueMonth[a];
                } else {
                    day = remainingDay;
                }
                break;
            }
            remainingDay = temp;
        }
        int hour, minute, second;
        hour = (int) (remianingSecond / (long) 3600) + 8;
        minute = (int) (remianingSecond2 / (long) 60);
        second = (int) (remianingSecond2 % (long) 60);
        return year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
    }

    public long toTime(String str) {
        String[] StrArray = str.split("-");
        int Year = Integer.parseInt(StrArray[0]);
        int Month = Integer.parseInt(StrArray[1]);
        int Day = Integer.parseInt(StrArray[2]);
        int Hour = Integer.parseInt(StrArray[3]);
        int Minute = Integer.parseInt(StrArray[4]);
        int Second = Integer.parseInt(StrArray[5]);
        long UnixTimeStamp = (long) (Second + Minute * 60 + (Hour - 8) * 3600 + Day * 86400);
        int Periodicity = (Year - 1970) / 4;
        int Days = Periodicity * 1461;
        UnixTimeStamp = (long) (UnixTimeStamp + (Days - 1) * 86400);
        boolean Leapyear = false;
        int[] month1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] trueMonth = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (Year % 4 == 0) {
            Leapyear = true;
        }
        if (Leapyear) {
            for (int a = 0; a < trueMonth.length; ++a) {
                trueMonth[a] = month2[a];
            }
        } else {
            for (int a = 0; a < trueMonth.length; ++a) {
                trueMonth[a] = month1[a];
            }
        }
        int sum = 0;
        for (int a = 0; a < Month - 1; ++a) {
            sum += trueMonth[a];
        }
        UnixTimeStamp = (long) (UnixTimeStamp + sum * 86400);
        return UnixTimeStamp;
    }

    public static void main(String[] args) {
        System.out.println(new KHQ3());
        System.out.println(new KHQ3().toDate(5000));
        System.out.println(new KHQ3().toTime("1970-1-1-9-23-20"));
    }
}