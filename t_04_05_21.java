package com.company.Hw;

import java.time.LocalDateTime;

public class t_04_05_21 {
    public void main() throws t_04_05_21Exception {
        Date currentDate = new Date().getCurrentTime();
        System.out.println(currentDate);
    }
}

class Minute {
    private long minutes;

    public Minute(long seconds) throws t_04_05_21Exception {
        setMinutes(seconds);
    }

    public void setMinutes(long seconds) throws t_04_05_21Exception {
        if (seconds < 0) {
            throw new t_04_05_21Exception("Time cannot be negative. (seconds >= 0)");
        }
        this.minutes = seconds/60;
    }

    public long getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "minutes=" + minutes;
    }
}

class Hour extends Minute {
    private long hours;

    public Hour(long seconds) throws t_04_05_21Exception {
        super(seconds%3600);
        setHours(seconds);
    }

    public void setHours(long seconds) throws t_04_05_21Exception {
        this.hours = seconds/3600;
        if (this.hours >= 24) {
            throw new t_04_05_21Exception("One date doesn't contain so many seconds. (MAX = 86400)");
        }
    }

    public long getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "hours=" + hours + ", " + super.toString();
    }
}

class Date extends Hour {
    public Date() throws t_04_05_21Exception {
        super(0);
    }

    public Date(long seconds) throws t_04_05_21Exception {
        super(seconds);
    }

    @Override
    public long getHours() {
        return super.getHours();
    }

    @Override
    public long getMinutes() {
        return super.getMinutes();
    }

    public Date getCurrentTime() throws t_04_05_21Exception {
        long currentTime = LocalDateTime.now().toLocalTime().toSecondOfDay();
        return new Date(currentTime);
    }

    public String getDateType() throws t_04_05_21Exception {
        String dateType = null;
        if (0 <= super.getHours() && super.getHours() < 6) {
            dateType = "night";
        } else if (6 <= super.getHours() && super.getHours() < 12) {
            dateType = "morning";
        } else if (12 <= super.getHours() && super.getHours() < 18) {
            dateType = "afternoon";
        } else if (18 <= super.getHours() && super.getHours() < 24){
            dateType = "evening";
        } else {
            throw new t_04_05_21Exception("Incorrect date time. (time != [0:00; 23:59])");
        }
        return dateType;
    }

    @Override
    public String toString() {
        try {
            return "Current time: " + super.toString() + " - " + this.getDateType();
        } catch (t_04_05_21Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

class t_04_05_21Exception extends Exception {
    public String message;

    public t_04_05_21Exception() {}

    public t_04_05_21Exception(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception [" + this.message + "]";
    }
}
