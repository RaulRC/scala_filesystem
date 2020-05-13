package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.State

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-13
 */

class Cat(filename: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd
    val dirEntry = wd.findEntry(filename)
    if (dirEntry == null || !dirEntry.isFile) state.setMessage(filename + ": no such file")
    else
      state.setMessage(dirEntry.asFile.contents)
  }
}
