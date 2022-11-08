public interface MyInterface {

    default void GetWithoutMyLovelyProfiler(String text){
        System.out.println( "Ты запустил " + text );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Ты завершил " + text );
        System.out.println( "Время работы сотавило: " );
    }

    @MyLovelyProfiler
    default void GetWithMyLovelyProfiler(String text){
        System.out.println( "Ты запустил " +  text );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Ты завершил " + text );
        System.out.println( "Время работы сотавило: " );
    }
}
