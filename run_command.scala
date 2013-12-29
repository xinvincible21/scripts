#!/usr/bin/env scala

import sys.process.{ ProcessLogger, Process }
import java.io.File

object Command {
  def runSeq(in: Seq[String]): (List[String], List[String], Int) = {
    val qb = Process(in)
    var out = List[String]()
    var err = List[String]()

    val exit = qb ! ProcessLogger((s) ⇒ out ::= s, (s) ⇒ err ::= s)

    (out.reverse, err.reverse, exit)
  }
  def main(args: Array[String]) {

      val cmd = Seq("ps", "waux")

      val (out, err, exit) = Command.runSeq(cmd)
      println("cmd -> " + cmd)
      println("out -> ")
      out.foreach(println(_))
      println("err -> ")
      err.foreach(println(_))
      println("exit -> " + exit)
  }
}

Command.main(args)
