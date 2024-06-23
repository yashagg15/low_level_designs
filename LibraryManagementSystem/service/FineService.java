package LibraryManagementSystem.service;

import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.Fine;

import java.util.Date;

public class FineService {

    public Fine calculateFine(BookItem bookItem) {

        Date todayDate = new Date();
        Date dueDateCustom = new Date();
        dueDateCustom.setDate(11);
        dueDateCustom.setMonth(3);
        dueDateCustom.setYear(124);
        bookItem.setDueDate(dueDateCustom);
        Date dueDate = bookItem.getDueDate();
        long time_diff = todayDate.getTime() - dueDate.getTime();
        if (time_diff < 0) {
            return null;
        }
        long days_difference = (time_diff / (1000 * 60 * 60 * 24)) % 365;
        double finePrice = 100.0 * days_difference;
        Fine fine = new Fine(bookItem, todayDate, days_difference, finePrice);
        return fine;

    }
}
