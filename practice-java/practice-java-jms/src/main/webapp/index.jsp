<html>
	<head>
	    <title>JMS Practice</title>
	</head>
	<body>
	    <div> 
		    <form action="<%= request.getContextPath() %>/jms-producer" method="post">
		    	<input type="text" name="requestMessage"/>
		    	<input type="submit" value="Produce"/>
		    </form>
		    <form action="<%= request.getContextPath() %>/jms-consumer" method="post">
		    	<input type="submit" value="Consume"/>
		    </form>
		    Result: <%= request.getAttribute("result") %>
		</div>
	</body>
</html>
