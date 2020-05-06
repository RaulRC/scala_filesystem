package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.State
import org.rrc.scala.oop.org.rrc.scala.oop.files.DirEntry

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-06
 */

class Ls extends Command {

  def createNiceOutput(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "]" + "\n"  + createNiceOutput(contents.tail)
    }
  }

  override def apply(state: State): State = {
    val contents  = state.wd.contents
    val niceOutput = createNiceOutput(contents)
    state.setMessage(niceOutput)
  }

}
