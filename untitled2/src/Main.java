import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("^(([a-zA-Z0-9\\-]*[a-zA-Z0-9])?\\.)+[a-zA-Z]+$");
        Pattern pattern2 = Pattern.compile("([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");



        Pattern pattern3 = Pattern.compile("((https|ftp|http)?:\\/\\/)?([\\w-]{1,63}\\.[\\w-]{1,32})[^\\s\\@]*");
        String str = "Вот моё предложение zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz.ru. llanfairpwllgwyngyllgogerychwyrndrobwyll-llantysiliogogogoch.info Вот еще одно site.ru. http://website-lab.ru/article/regexp/shpargalka_po_regulyarnyim_vyirajeniyam/ И тут https://habr.com/ru/post/123845/. Я спамер, заходите на www.faqqqqq.ws";
        System.out.println(pattern3.matcher(str).replaceAll("[Ссылка удалена]"));



        String str2 = "examples@maps.yandex.ru";
        Pattern patternHighLevel = Pattern.compile("(?<=@)[^.]+(?=\\.)");
        Pattern patternLowLevel = Pattern.compile("[a-z0-9-_.]+[@]([a-z]+)([.]([a-z]+))+", Pattern.CASE_INSENSITIVE);

    }
}
