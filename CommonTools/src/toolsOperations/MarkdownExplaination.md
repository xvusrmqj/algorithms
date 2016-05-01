# Github Flavored Markdown的使用说明
引用：http://www.jianshu.com/p/cfPxyr

Github用的[GFM][1]，风格很漂亮，简洁美观大方。 GFM对标准[Markdown][2]做了少了修改，例如如下的内容。

## 换行
标准MD要在一行的最后加两个空格符才表示换行，否则是不换行的。但是GFM则没有此要求。
	第一行（最后无两个空格）
	第二行
## 斜体
标准MD使用在词组两边添加下划线来实现斜体，例如_text_。但是这样对计算机世界来说并不合适，我们也许经常需要提到多个下划线组成的词组，例如 do_some_thing。
## 自动URL链接
一个小优化，如果你直接在GFM中写一个URL链接文本，那么也会自动生成URL，同时文字也显示为该链接本身。例如，https://github.com
### 代码段和代码高亮
如果代码段每行前使用4个空格对齐，标准MD就会识别为代码段，GFM也支持这样的语法，同时GFM还设计了一种优化的语法，就是在代码段的头尾行使用<code>```</code>，这样你就不需要考虑代码前的对齐了。你还可以加上语言标识，这样就可以支持代码语法高亮，例如：
```
require 'redcarpet'
markdown = Redcarpet.new("Hello World!")
puts markdown.to_html
```
## 任务列表
GFM支持把列表变成带勾选框的任务列表，只需要修改列表前序号的格式为- [ ]或者- [1]。看起来效果就像下面这样的：
- [ ] abc #40
- [2] abc #40
- [x] def this link
- [1] ghi

[1]: https://help.github.com/categories/writing-on-github/
[2]: http://daringfireball.net/projects/markdown/syntax