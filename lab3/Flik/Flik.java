/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        //由于Integer变量实际上是对一个Integer对象的引用，
        //所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象，其内存地址不同）。

        //java对于-128到127之间的数，会进行缓存，Integer i = 127时，
        // 会将127进行缓存，下次再写Integer j = 127时，就会直接从缓存中取，就不会new了
        return a == b;
    }
}
