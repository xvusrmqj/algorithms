# Servlet & JSP
1. 多个用户分别同时访问同一个URL，这时，Servlet对象是有多个还是只有一个？
答：一个

4. http请求的一个流程.
	答:
	4.1 解析请求路径http://localhost:8080/JavaWebInterview/hello.view得到服务器地址, 工程地址(contextPath),Servlet地址(ServerPath)，参数(pathInfo)。
	4.1 根据服务器地址找到HTTP服务器。
		4.1.1 HTTP服务器转交请求给容器,容器会创建代表当次请求的HttpServletRequest对象,并设置相关信息. 同时创建HttpServletResponse对象,做为稍后响应的JAVA对象。
	4.2 根据服务器中的工程找到工程【如果没有工程呢？比如www.baidu.com】
	4.3 根据web.xml和URL匹配找到Servlet.
		4.3.1 匹配方式: 从最严格的Servlet中找.
			* 完全匹配:/guest/test.view
			* 路径映射:`/guest/*`
			* 扩展映射: *.view
			* 预设Servlet: 当找不到匹配时,使用预设
		4.3.2 找出处理该请求的Service方法。Service方法中会调用对应用doXXX()方法.
	4.4 在Servlet中找到得到请求参数.
	4.5 在Servlet中响应.由容器将响应转为HTTP响应。
	4.6 容器将HttpServletRequest、HttpServletResponse对象销毁，该次请求响应结束。

5. JSP的九大隐式对象和四大域对象
	答:
	隐式对象			Servlet中的对象			域对象
	pageContext		pageContext				  Y
	request			HttpServletRequest		  Y
	session			HttpSession 			  Y
	application		ServletContext			  Y
	config			ServletConfig
	out				JspWrite
	response		HttpServletResponse
	exception		Throwable
	page			this
	注： 隐式对象只能 在<%与%>之间使用, 或<%=与%>之间使用. 不能在<%!与%>之间使用, 因为转译后为Servlet中的_jspService()中的局部变量.

6. JSP中如何使用JAVA代码？
	6.1  声明				<%!  %> 	转译为Servlet中类成员或方法
	6.2 Scriptlet		<%   %>		转译为Servlet中_jspService()方法中内容
	6.3 Expression		<%=  %>		表达式结果直接输出

6. Servlet的域对象(都有setAttribute,getAttribute和removeAttribute方法)
	答:	HttpServletRequest:请求域
		HttpSession:会话域
		ServletContext:应用域

7. Session的生命周期? Cookie的生命周期？ Servlet的生命周期? JSP的生命周期？
	答：
	1. Cookie			可以给Cookie设置存活期限.
	2. Session			getSession生效, invalidate()或关闭浏览器失效.
	3. Servlet
		生效: 1. 容器启动时会加载设置<loadon-startup>的Servlet. 2. 客户首次向Servlet发请求时加载.
		销毁: WEB容器调用destroy方法时销毁. 容器关闭时销毁.



8. Cookie和Session的区别和联系？
	答： 由于HTTP是无状态的通信协议。服务器不会记录两次请求之间的关系，然而有些功能必须要多次请求来完成，例如购物车。 这种记得两次请求之间的关系的方式就称为会话管理。由浏览器主动告知必要,是实现 WEB应用会话管理的基本原理.
	实现会话管理的基本方法有：隐藏域、Cookie、URL重写。
	8.1  隐藏域：		<input type= 'hidden' name='xxx' ...>
		缺点: 1. 关掉网页, 会遗失之前请求信息.
			  2. 查看源代码,就可以看到隐藏域 的值,不适合隐密性较高的数据.
	8.2 Cookie:		浏览器中存储信息的一种方式.
	8.3	URL重写：	GET请求参数的应用
		缺点： 1. 必须用GET方法提交
			  2. 长度有限
	注： 这三种方式，都必须自行处理对浏览器的响应，决定哪些信息必须送至浏览器，以便在之后的请求中一并发送相关信息，供WEB应用程序辨识请求童年关联。
	Session可以将会话期间必须共享的数据，保存的HttpSession中成为属性。
	Session创建:
		第一次运行request.getSession()时会创建Session对象. 每个对象都有一个Session ID . 默认会使用Cookie存放在浏览器中. Session Id 会随请求一并发送给Web服务器中. Web容器会根据Session ID找出对应的HttpSession对象. 这样就可以取得各浏览器个别的会话数据.
	Session销毁:
	1. 存储的Session ID的Cookie默认为浏览器关闭就失效.所以在关闭浏览器之前，都是同一个Session。关闭浏览器后,再调用getSession()就会产生新的Session.
	2. invalidate()方法可以让当前的Session失效.
	3. 可以执行HttpSession的setMaxInactiveInterval()方法,设定浏览器多久没有请求应用程序的话,HttpSession自动失效.
	注1: HttpSession非线程安全,设定时共享存取的问题)
	注2: Cookie默认关闭浏览器就失效, 仅用于存储Session ID。其它关闭浏览器后仍希望保存的信息，仍必须自行操作Cookie来完成。

9. 为什么说HTTP是无状态的通信协议？那些协议是有状态的通信协议？TCP是吗？UDP是吗？IP是吗？
	答：
9. 什么是HTTP强连接，什么上HTTP弱连接？
	答：
10. Web容器要求Web应用的目录结构
	|---工程名
		 |---WEB-INF：是封闭的，客户端无法访问到。
		 	  |---web.xml:web描述文件
		 	  |---lib: jar文件
		 	  |---classes: 编译后的class文件
		 |---其它
11. Web容器做了什么?
	* 请求信息的收集.
	* 响应信息的转换. (转换为HTTP响应)
	* HttpServletRequest,HttpServletResponse对象的创建对回收.
	* 其它对象生命周期的管理.

# SSH
## Struts2
1.分别介绍一下Struts2、Spring、Hibernate.
答： Struts2是一个Web应用框架。Struts2的配置文件struts.xml
2. 什么是值栈?
3. Struts2的好处?

## Spring
1.
## Hibernate

# 其它
3. 如何设计一个高并发的系统
 答：
 		① 数据库的优化，包括合理的事务隔离级别、SQL语句优化、索引的优化
 		② 使用缓存，尽量减少数据库 IO
 		③ 分布式数据库、分布式缓存
 		④ 服务器的负载均衡
