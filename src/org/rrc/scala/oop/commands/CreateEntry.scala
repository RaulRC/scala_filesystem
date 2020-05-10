package org.rrc.scala.oop.commands
import org.rrc.scala.oop.filesystem.State
import org.rrc.scala.oop.org.rrc.scala.oop.files.{DirEntry, Directory}

/*
 * @project scala_filesystem
 * @author raul.reguillo on 2020-05-10
 */

abstract class CreateEntry(entryName: String) extends Command{


  def doCreateEntry(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    val wd = state.wd

    val fullPath = wd.path

    //1. all the directories in the full path
    val allDirsInPath = wd.getAllFoldersInPath

    //2. create new directory entry in the wd
    val newEntry: DirEntry = createSpecificEntry(state)

    //3. update the whole directory structure starting from the root
    // (the directory structure is INMUTABLE)
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)

    //4. find new working directory INSTANCE given wd's full path in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)

  }

  def createSpecificEntry(state: State): DirEntry

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(entryName)){
      state.setMessage("Entry " + entryName + " already exists!")
    } else if (entryName.contains(Directory.SEPARATOR)) {
      // mkdir -p something/somethingElse // not supported
      state.setMessage(entryName + " mus not contain separators")
    }else if (isIllegalName(entryName)){
      state.setMessage(entryName + ": illegal entry name")
    } else {
      doCreateEntry(state, entryName)
    }
  }

  def isIllegalName(str: String): Boolean = {
    entryName.contains(".")
  }
}
