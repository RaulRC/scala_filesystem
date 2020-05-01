package org.rrc.scala.oop.commands

import org.rrc.scala.oop.filesystem.State

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

class UnknownCommand extends Command{
  override def apply(state: State): State =
    state.setMessage("Command not found!")

}
