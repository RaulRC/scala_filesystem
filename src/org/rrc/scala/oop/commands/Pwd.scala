package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.State

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-10
 */

class Pwd extends Command{
  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
