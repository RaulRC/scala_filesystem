package org.rrc.scala.oop.commands

import org.rrc.scala.oop.filesystem.State

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

trait Command {
  def apply(state: State): State


}

object Command {
  val MKDIR = "mkdir"
  val LS = "ls"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Command =new Command {
    override def apply(state: State): State =
      state.setMessage(name + ": incomplete command!")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    } else if (LS.equals(tokens(0))) {
      new Ls
    }
    else new UnknownCommand
  }

}