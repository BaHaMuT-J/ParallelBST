import scala.concurrent.Await
import scala.concurrent.duration.Duration

object TestBST extends App {
//  val t = new BST.ParBST[Int](10)
//  val nt = t ++ {1 to 10000}.toList
//  println(t)
//  println(nt)
//  t.insertAllPar({1 to 10000}.toList)
//  println(t)

  val a = new BST.ParBST[Int](10)
  a.insertAllPar({1 to 5_000}.toList)
//  val b = new BST.ParBST[Int](10)
//  b.insertAllPar({50001 to 100000}.toList)

  val levelMap1 = a.levelTraverseSeq
  println(s"levelMap1 finish")
  val levelMap2 = a.levelTraverseThreadSync
  println(s"levelMap2 finish")

  var s = 0
  for ((d, vec_tree) <- levelMap1) {
    if vec_tree.toSet != (levelMap2(d).toSet) then println(s"vec_tree1 = ${vec_tree}, vec_tree2 = ${levelMap2(d)}")
    s = s + vec_tree.size
  }
  println(s"s1 = $s")
  s = 0
  for ((d, vec_tree) <- levelMap2) {
    s = s + vec_tree.size
  }
  println(s"s2 = $s")


//  val d = a.findLevelSeq(500)
//  println(d)
//  val level1 = a.levelSeq(d.getOrElse(1))
//  println(level1)
//  val level2 = a.levelFuture(d.getOrElse(1))
//  println(level2)
//
//  println(level1.toSet == level2.toSet)

//  println(b)
//  println(a.combineSeq(b))
//  println(a.combinePar(b))
}
