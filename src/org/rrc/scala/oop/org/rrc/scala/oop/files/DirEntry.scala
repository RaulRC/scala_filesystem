package org.rrc.scala.oop.org.rrc.scala.oop.files

import org.rrc.scala.oop.filesystem.File

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-01
 */

abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = parentPath + Directory.SEPARATOR + name

  def asDirectory: Directory = ???

  def getType: String = ???

  def asFile: File = ???

}
