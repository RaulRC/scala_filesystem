package org.rrc.scala.oop.filesystem

import org.rrc.scala.oop.org.rrc.scala.oop.files.Directory

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

class State(val root: Directory, val wd: Directory, val output: String) {
  def show: Unit = {
    println(output)
    print(State.SHELL_TOKEN)
  }

  def setMessage(message: String): State =
    State.apply(root, wd, message)

}

object State {
  val SHELL_TOKEN = "$ "

  def apply(root: Directory, wd: Directory, output: String = ""): State =
    new State(root, wd, output)
}
