# Github Flavored Markdown的使用说明


Github用的[GFM][1]，风格很漂亮，简洁美观大方。 GFM对标准[Markdown][2]做了一些修改。
## 斜体
标准MD使用在词组两边添加下划线来实现斜体，例如_text_。但是这样对计算机世界来说并不合适，我们也许经常需要提到多个下划线组成的词组，例如 do_some_thing。
## 自动URL链接
一个小优化，如果你直接在GFM中写一个URL链接文本，那么也会自动生成URL，同时文字也显示为该链接本身。例如，https://github.com
### 代码段和代码高亮
在三个反引号后面加上编程语言的名字，另起一行开始写代码，最后一行再加上三个反引号。
```Java
public static void main(String[]args){} //Java
```
## 任务列表
GFM支持把列表变成带勾选框的任务列表，只需要修改列表前序号的格式为- [ ]或者- [x]。看起来效果就像下面这样的：
- [ ] abc #40
- [x] def [this](./JunitExplainations.java) 
- [ ] ghi

## 表格

表头1  | 表头2
:--------- | --------:
hello  | hello
表格单元  | 表格单元 
## 文字高亮
文字高亮功能能使行内部分文字高亮，使用一对反引号。
`linux` `网络编程` `socket` `epoll` 

##表情
Github的Markdown语法支持添加emoji表情，输入不同的符号码（两个冒号包围的字符）可以显示出不同的表情。

比如`:blush`:，可以显示:blush:。

[1]: https://help.github.com/categories/writing-on-github/
[2]: http://daringfireball.net/projects/markdown/syntax
参考：
1. http://www.jianshu.com/p/cfPxyr  
2. https://github.com/guodongxiaren/README