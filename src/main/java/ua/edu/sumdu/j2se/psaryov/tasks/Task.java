package ua.edu.sumdu.j2se.psaryov.tasks;

public class Task {

    private String title;
    private int start;
    private int end;
    private int interval;
    private boolean active;


    /**
     * создание неактивной задачи
     * которая не повторяется
     * @param title описание задачи
     * @param time время разового выполнения задачи
     */

    public Task(String title, int time) {
        start = time;
        end = time;
        interval = 0;
        active = false;
        this.title = title;
    }


    /**
     * создание неактивной задачи, которая повторяется
     * @param title описание задачи
     * @param start начало промежутка времени для выполнения
     * @param end конец промежутка времени для выполнения
     * @param interval интервал повторения
     */

    public Task(String title, int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.title = title;
        this.active = false;
    }


    /**
     * возвращает описание задачи
     * @return описание задачи
     */

    public String getTitle() {
        return title;
    }


    /**
     * устанавливает новое описание задачи
     * @param title описание задачи
     */

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * проверяет задачу на активность
     * @return возвращает true когда задача активна
     */

    public boolean isActive() {
        return active;
    }


    /**
     * устанавливает новое состояние активности задачи
     * @param active новое состояние активности
     */

    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * возвращает время выполнения или начало интервала
     * @return если задача не повторяется то возвращает время выполнения
     * если повторяется то начало интервала
     */

    public int getTime() {
        return start;
    }


    /**
     * превращает задачу на неповторяемую
     * и устанавливает новое время выполнения
     * @param time новое время выполнения
     */

    public void setTime(int time) {
        start = time;
        end = time;
        interval = 0;
    }


    /**
     * возвращает вермя начала интервала или время выполнения
     * @return для задачи которая не повторяется - время выполнения
     * для задачи которая повторяется - начало интервала
     */



    public int getStartTime() {
        return start;
    }


    /**
     * возвращает вермя конца интервала или время выполнения
     * @return для задачи которая не повторяется - время выполнения
     * для задачи которая повторяется - конец интервала
     */


    public int getEndTime() {
        return end;
    }

    /**
     * возвращает интервал
     * @return если задача не повторяется - возвращает 0
     * если повторяется то интервал
     */


    public int getRepeatInterval() {
        return interval;
    }

    /**
     * превращает задачу на повторяющуюся и устанавливает новые параметры
     * @param start новое начало интервала
     * @param end новый конец интервала
     * @param interval новый интервал
     */


    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    /**
     * определяет повторяется ли задача
     * @return если повторяется - true, если нет - false
     */


    public boolean isRepeated() {
        return interval != 0;
    }

    /**
     * определяет время выполнения задачи после заданного времени
     * @param current заданное время
     * @return если задача выполняется после заданного времени - возвращает время выполнения
     * если не возвращается то возвращает -1
     */
    

    public int nextTimeAfter(int current) {
        if (!active) {
            return -1;
        }

        if (interval == 0) {
            if (end - current > 0) {
                return end;
            }
            else {
                return -1;
            }
        }
        else {
            for (int i = start; i <= end; i += interval) {
                if (i - current > 0) {
                    return i;
                }
            }
            return -1;
        }
    }
}

