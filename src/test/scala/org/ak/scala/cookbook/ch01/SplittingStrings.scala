package org.ak.scala.cookbook.ch01

import org.scalatest.{Matchers, FlatSpec}

/**
 * @author antonk
 * @since  7/23/14 - 12:21 PM
 */
class SplittingStrings extends FlatSpec with Matchers {
  "String" should "be split on field separator (java style)" in {
    val str = "one, two, three"
    val arrOne = str.split(",")

    arrOne should have size 3
    arrOne should contain inOrderOnly ("one", " two", " three")


    val arrTwo = str.split("\\s+")
    arrTwo should have size 3
    arrTwo should contain inOrderOnly ("one,", "two,", "three")
  }


  it should "be split and result should have map, filter and other functions" in {
    val strOne = "one, two, three"
    val arrOne = strOne.split(",").map(_.trim)

    arrOne should have size 3
    arrOne should contain inOrderOnly ("one", "two", "three")


    val strTwo = "1, 2, 3"
    val arrTwo = strTwo.split(",")
                       .map(_.trim)
                       .map(_.toInt)
                       .filter(_ % 2 != 0)

    arrTwo should have size 2
    arrTwo should contain inOrderOnly (1, 3)
  }



  it should "be split with additional scala methods" in {
    val str = "one, and two, and three"
    val arrOne = str.split(',') // using one character separator

    arrOne should have size 3
    arrOne should contain only ("one", " and two", " and three")

    val arrTwo = str.split(Array(',', ' ')) // using characters array as separator
                    .filterNot(_.isEmpty)

    arrTwo should have size 5
    arrTwo should contain theSameElementsInOrderAs  Array("one", "and", "two", "and", "three")
  }



  it should "be split into two Strings with splitAt(n: Int) method" in {
    val str = "Hello, World"
    val (head, tail) = str.splitAt(6)

    head shouldEqual "Hello,"
    tail shouldEqual " World"
  }
}
