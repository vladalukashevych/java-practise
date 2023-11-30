import com.education.ztu.*;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        StringTask1.DoTask("I learn Java!!!");
//        StringTask2.DoTask(4, 36);
//        DateTimeTask.DoTask();


        String[][] purchases = {
                {"Джинси", "Жіночий одяг", "1500.78"},
                {"Спідниця", "Жіночий одяг", "1000.56"},
                {"Краватка", "Чоловічий одяг", "500.78"},
                {"Шкарпетки", "Чоловічий одяг", "500.78"},
                {"Футболка", "Чоловічий одяг", "750.99"},
                {"Штани", "Жіночий одяг", "1200.00"},
                {"Сукня", "Жіночий одяг", "2000.25"},
                {"Світшот", "Чоловічий одяг", "900.49"},
                {"Шарф", "Аксесуари", "300.25"},
                {"Капелюх", "Аксесуари", "450.99"},
                {"Кросівки", "Взуття", "1800.75"}
        };


        Receipt.Print(purchases);

//        Locale.setDefault(new Locale("en", "GB"));
//        Receipt.Print(purchases);
//
//        Locale.setDefault(new Locale("it", "IT"));
//        Receipt.Print(purchases);
    }
}