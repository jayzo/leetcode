package com.zuojie.coupang;

import lombok.Data;
import lombok.val;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Title: Implement a Simple In-Memory File System
Background
You need to simulate a simple file system in memory, supporting directory and file creation, file content writing and reading, and nested directory management. All data should be stored in memory, not on disk. You can only support text file, don't need to support binary file.
Requirements
1. Class Design
Implement an InMemoryFileSystem class that provides basic file system functionalities, including creating directories and files, writing and reading file contents, and listing the directory structure.
2. Basic Functionalities:
Create Directory: Create a directory at a specified path, supporting nested directories.
Create File: Create a file in a specified directory. It can be an empty file or contain initial content at creation.
Write File Content: Write content to a file, supporting content overwrite.
Read File Content: Read the content of a specified file.
List Directory Contents: List all files and subdirectories within a specified directory.
3. Path Management
The file system uses paths to represent the location of files and directories, e.g., /home/user/docs.
Paths are organized hierarchically, separated by slashes /.
4. Error Handling
If an attempt is made to create an already existing file or directory, an exception should be thrown.
If a path does not exist or if an invalid path is accessed, an exception should be thrown.
Program Input and Output
Users will interact with the file system by issuing a series of commands. For example:
// Create directory
fileSystem.mkdir("/home/user/docs");
// Create a file and write content
fileSystem.createFile("/home/user/docs/file1.txt", "Hello, world!");
// Read file content
String content = fileSystem.readFile("/home/user/docs/file1.txt"); // Output: "Hello, world!"
// List directory contents
List<String> contents = fileSystem.listDirectory("/home/user"); // Output: ["docs"]
// Write file content
fileSystem.writeFile("/home/user/docs/file1.txt", "Updated content");
// Read file content again
content = fileSystem.readFile("/home/user/docs/file1.txt"); // Output: "Updated content"

Bonus Points
1. Delete File or Directory
2. Move, Rename File or Directory
3. Use JUnit or other testing frameworks to write unit tests to ensure all parts of the program function correctly.
*/
public class InMemoryFileSystem {
    public static void main(String[] args) {
        System.out.println("aaa");
        InMemoryFileSystem inMemoryFileSystem = new InMemoryFileSystem();
    }

    private FileNode root;

    public InMemoryFileSystem() {
        mkdir("/");
        root = new FileNode();
        root.setType(0);
        root.setLeafNodeMap(new HashMap<>(16));
        root.setParentNode(null);
    }
    /**
     * 一个路径or文件节点
     */
    @Data
    static class FileNode {
        /**
         * 类型 0: 目录, 1: 文件
         */
        private Integer type;

        /**
         * type == 1时, 保存文件内容
         */
        private String content;

        /**
         * 当前目录节点的子目录/文件, key为 文件/目录的名字, value为对应的fileNode对象
         */
        private Map<String, FileNode> leafNodeMap;

        /**
         * 当前目录节点的上级目录
         */
        private FileNode parentNode;
    }

    public static final String SEP = "/";

    private Boolean checkPath(String path) {
        if (path.isBlank()) {
            return false;
        }
        if (!path.startsWith(SEP)) {
            return false;
        }
        return true;
    }

    public Boolean mkdir(String path) {
        if (!checkPath(path)) {
            throw new RuntimeException("path is invalid");
        }

        String[] pathList = path.split(SEP);
        FileNode curr = root;
        FileNode last;
        for (String p: pathList) {
            last = curr;
            FileNode f;
            if (!curr.getLeafNodeMap().containsKey(p)) {
                f = new FileNode();
                f.setType(0);
                // curr追加子目录
                curr.getLeafNodeMap().put(p, f);
            } else if (curr.getLeafNodeMap().get(p).getType() == 1) {
                throw new RuntimeException("path is invalid, "+ p + " is not path type");
            } else {
                f = curr.getLeafNodeMap().get(p);
            }
            // curr变更
            curr = f;
            // curr
            curr.setParentNode(last);
        }
        return true;
    }

    public Boolean createFile(String path, String content) {
        if (!checkPath(path)) {
            throw new RuntimeException("path is invalid");
        }
        String[] pathList = path.split(SEP);
        FileNode curr = root;
        FileNode last;
        int idx = 0;
        for (String p: pathList) {
            last = curr;
            FileNode f;
            if (!curr.getLeafNodeMap().containsKey(p)) {
                f = new FileNode();
                f.setType(0);
                // curr追加子目录
                curr.getLeafNodeMap().put(p, f);
            } else if (curr.getLeafNodeMap().get(p).getType() == 1) {
                throw new RuntimeException("path is invalid, "+ p + " is not path type");
            } else {
                f = curr.getLeafNodeMap().get(p);
            }
            // curr变更
            curr = f;
            // curr
            curr.setParentNode(last);
            if (idx == pathList.length - 1) {
                f.setContent(f.getContent().isBlank() ? content : f.getContent() + content);
            }
            idx++;
        }
        return true;
    }

    public String readFile(String path) {
        return "";
    }

    public List<String> listDirectory(String path) {
        return Arrays.asList("");
    }

    public Boolean writeFile(String path, String content) {
        return true;
    }
}
