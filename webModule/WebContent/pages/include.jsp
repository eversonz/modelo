<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="linha">
	<div class="coluna" style="width: 120px" >
		<img src="/webModule/img/mascot.jpg" />
	</div>
	<div class="coluna">
		<div class="linha"> &nbsp; </div>
		<div class="linha">
			<div class="coluna, title" style="width: 300px">
				<s:text name="worldcup.2014" />
			</div>
			<div class="coluna, subtitle">
				<s:text name="poll" />
			</div>			
		</div>
	</div>
</div>

<div class="linha" style="line-height: 100px;"> 
	&nbsp;
</div>

<span class="error">
	<s:actionerror/> 
	<s:fielderror/>
</span>
<span class="success">
	<s:actionmessage/>
</span>
<br/> 

