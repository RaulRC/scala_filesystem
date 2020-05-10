package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.{File, State}
import org.rrc.scala.oop.org.rrc.scala.oop.files.DirEntry

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-10
 */

class Touch(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
