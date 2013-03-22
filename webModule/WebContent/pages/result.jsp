<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="<s:url value="/style/principal.css" />">

<html>
<head><title>
	<s:text name="title.vote" /> 
</title></head>

<body>

<jsp:include page="include.jsp" />

<s:form>
	<div class="linha" >
		<div class="coluna" style="width: 450px" >
			<fieldset>
				<legend>
					<s:text name="txt.result.vote" />
				</legend>
				<div class="colunaNome" style="width: 110px">
					<span>
						<s:text name="name.mascot1" />
						<s:text name="votes[0]" />%
					</span>
				</div>				
				<div class="colunaNome">
					<span>
						<s:text name="name.mascot2" />
						<s:text name="votes[1]" />%
					</span>	
				</div>
				<div class="colunaNome">
					<span>
						<s:text name="name.mascot3" />
						<s:text name="votes[2]" />%
					</span>	
				</div>
				<div class="colunaNome">
					<span>
						&nbsp;
					</span>	
				</div>									
			</fieldset>
		</div>
	</div>
</s:form>

</body>
</html>