<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="<s:url value="/style/principal.css" />">

<html>
<head><title>
	<s:text name="title.vote" /> 
</title></head>

<body>

<jsp:include page="include.jsp" />

<s:form action="vote">
	<div class="linha" >
		<div class="coluna" style="width: 450px" >
			<fieldset>
				<legend>
					<s:text name="select.mascot" />
				</legend>
				<div class="linha" >
					<div class="colunaNome" style="width: 110px">
						<span class="title2">
							<input type="radio" name="masc" value="0" checked="checked"> <s:text name="name.mascot1" />
						</span>
					</div>
					<div class="colunaTxt">
						<span class="subtitle2">
							<s:text name="txt.mascot1" />
						</span>
					</div>					
				</div>
				<div class="linha" >
					<div class="colunaNome">
						<span class="title2">
							<input type="radio" name="masc" value="1"> <s:text name="name.mascot2" />
						</span>	
					</div>
					<div class="colunaTxt">
						<span class="subtitle2">
							<s:text name="txt.mascot2" />
						</span>	
					</div>		
				</div>
				<div class="linha" style="height: 60px">
					<div class="colunaNome">
						<span class="title2">
							<input type="radio" name="masc" value="2"> <s:text name="name.mascot3" />
						</span>	
					</div>
					<div class="colunaTxt">
						<span class="subtitle2">
							<s:text name="txt.mascot3" />
						</span>	
					</div>		
				</div>				
			</fieldset>
		</div>
		<div class="coluna" style="width: 330px" >
			<div class="linha" style="height: 30px;">
				<s:text name="code" />
			</div>
			<div class="linha" style="line-height: 200px">
				<img src="jcaptcha.jpg" /> <input type="text" name="jcaptcha" value="" />
			</div>
			<div class="linha" >
				<input type="submit" value="<s:text name="vote" />" style="width: 200px">
			</div>								
		</div>
	</div>
</s:form>

</body>
</html>