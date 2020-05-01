package org.rrc.scala.oop.filesystem

import java.util.Scanner

import org.rrc.scala.oop.commands.Command
import org.rrc.scala.oop.org.rrc.scala.oop.files.Directory

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
