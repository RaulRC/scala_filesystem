package org.rrc.scala.oop.org.rrc.scala.oop.files

import org.rrc.scala.oop.filesystem.File

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = {
    val separatorIfNecessary =
      if (Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR
    parentPath + separatorIfNecessary + name
  }

  def asDirectory: Directory = ???

  def getType: String = ???

  def asFile: File = ???

  def isDirectory: Boolean

  def isFile: Boolean

}
