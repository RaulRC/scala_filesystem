package org.rrc.scala.oop.filesystem

import org.rrc.scala.oop.org.rrc.scala.oop.files.{DirEntry, Directory}

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-10
 */

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name){

  override def asDirectory: Directory =
    throw new FilesystemException("A file cannot be converted to a directory")

  override def getType: String = "File"

  override def asFile: File = this

}

object File {
  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}