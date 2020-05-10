package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.State
import org.rrc.scala.oop.org.rrc.scala.oop.files.{DirEntry, Directory}

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-06
 */

class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
