# Questions and Answers
1. 静态导入是做什么的,有什么好处?
答:[The static import declaration is analogous to the normal import declaration. Where the normal import declaration imports classes from packages, allowing them to be used without package qualification, the static import declaration imports static members from classes, allowing them to be used without class qualification.](http://docs.oracle.com/javase/1.5.0/docs/guide/language/static-import.html) 
2. 带头结点的单链表转换为不带头结点的单链表后，头结点还指向了新单链接的第一个元素，它会被垃圾回收吗？easy.NO21.ListNode.class
答：
3. 什么是链表的头插法，什么是链表的尾插法？
答：就是建立单链表的两种方式，头插法每次都把读取的数据插到头结节后，所以导致了链表顺序与输入数据的顺序是相反的，而尾插法每次都报读取的数据插到链表尾部，这样链表顺序与输入数据的顺序相同，但是需要多用一个尾指针。