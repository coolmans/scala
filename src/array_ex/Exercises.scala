package array_ex

/**
 * @author И. Б.
 * @date 07.04.2022
 *       Скала для нетерпеливых 2 изд. глава 3, Упражнения
 * */
object Exercises extends App {
  /** Задание 1 */

  import scala.collection.mutable.ArrayBuffer

  val a = ArrayBuffer[Int]()
  val n = 10
  for (i <- 0 until n)
    a += i
    println(a(i))


  println()

  /** Задание 2 */
  var reverseAvsB = Array(1, 2, 3, 4, 5, 6)
  var buffer: Int = 0;
  for (i <- 0 to reverseAvsB.length - 2 by 2) yield {
    buffer = reverseAvsB(i + 1)
    reverseAvsB(i + 1) = reverseAvsB(i)
    reverseAvsB(i) = buffer
  }
  for (i <- reverseAvsB) println(i)


  println()

  /** Задание 3 */
  var newArray = Array[Int]()
  newArray = reverseAvsB
  for (i <- newArray) println(i)

  println()

  /** Задание 4 */

  import scala.util.chaining._

  var array4 = Array(-1, 2, 3, 0, 5, 6)
  //val newArray4 = Array((array4.partition(_ > 0)._1 ++ array4.partition(_ <= 0)._1).toList).flatten // вариант 1, как упростить?
  //for (i <- newArray4) println(i)
  val newArray4 = Array(array4.partition(_ > 0).pipe(t => t._1 ++ t._2).toList) // вариант 2 с импортом
  for (i <- newArray4) println(i.mkString(" "))

  println()

  /** Задание 5
   * найти среднее арифметическое всех элементов массива Array[Double]
   * */
  // каюсь пример из джавы взял в интернете и переделал под scala ) https://ru.stackoverflow.com/questions/436370/%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D0%B9%D1%82%D0%B8-%D1%81%D1%80%D0%B5%D0%B4%D0%BD%D0%B5%D0%B5-%D0%B0%D1%80%D0%B8%D1%84%D0%BC%D0%B5%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%B2%D1%81%D0%B5%D1%85-%D1%8D%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%B0
  val arrayDouble = Array[Double](2.4, 34, 65, 2, 1, 6, 8, 4.5)
  //val arrayDouble = Array[Double](1,2,3,4,5,6,7,8,9,10)
  var average: Double = 0;
  if (arrayDouble.length > 0) {
    var sum: Double = 0;
    for (j <- 0 to arrayDouble.length - 1) {
      sum += arrayDouble(j)
    }
    average = sum / arrayDouble.length
  }
  println(average)
  println()
  //println(arrayDouble.sum / arrayDouble.length) // короткий способ ?
  println()

  /** Задание 6 */
  val array6 = Array[Int](2, 1, 3, 4, 5, 6, 7, 8, 9)
  val array6Buffer = ArrayBuffer[Int](2, 1, 3, 4, 5, 6, 7, 8, 9)
  println(array6.sorted.reverse.toList.mkString(" "))
  println(array6Buffer.sorted.reverse.toList.mkString(" "))

  println()

  /** Задание 7 */
  val array7 = Array[Int](2, 1, 3, 2, 5, 6, 2, 8, 9)
  println(array7.toSet.mkString(" "))

  println()

  /** Задание 8 */
  val array6Buffer8 = ArrayBuffer[Int](1, -666, 2, 3, -4, 5, 6, -7, 8, 9)
  val array6Buffer8Index = (for (i <- array6Buffer8 if (i < 0)) yield array6Buffer8.indexOf(i)).tail.reverse //получил индексы отрицательных значений, отбросил голову (head) и взял тело tail
  for (i <- array6Buffer8Index) array6Buffer8.remove(i) //remove(6)  использует значение интекса который указали для удаления
  println(array6Buffer8Index) // индексы для удаления
  println(array6Buffer8) //выводим новый измененный массив

  println()

  /** Задание 9 */

  /*Улучшите решение из предыдущего упражнения. Соберите ин-
    дексы элементов, подлежащих перемещению и позиции, ку-
    да они должны быть помещены. Переместите их и укоротите
    буфер. Не копируйте элементов, находящихся перед первым
  нежелательным элементом.*/

  /** Задание 10 */
  val timeZone = java.util.TimeZone.getAvailableIDs.filter(x => x.contains("America"))
  val finish: Array[String] = for (i <- timeZone) yield i.replaceAll("America/", "")
  val sortArray = finish.sorted
  for (i <- sortArray) println(i)

  /** Задание 11 */
  import java.awt.datatransfer._
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  getNativesForFlavor(DataFlavor.imageFlavor)

}