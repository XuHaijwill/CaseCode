<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>Hello World!</h2>
	
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br><br>	
	<a href="springmvc/testPathVariable/1">Test PathVariable</a>
	<br><br>
	<a href="springmvc/testAntPath/mnxyz/abc">Test AntPath</a>
	<br><br>
	<a href="springmvc/testParamsAndHeaders?username=atguigu&age=20">Test ParamsAndHeaders</a>
	<br><br>
	<form action="springmvc/testMethod" method="POST">
		<input type="submit" value="submit"/>
	</form>
	<br><br>
	<a href="springmvc/testMethod">Test Method</a>
	<br>
	<br>
	<a href="springmvc/testRequestMapping">跳转20190520-1</a>
	<br>
	<br>
	<a href="helloworld">Hello World</a>
</body>
</html>