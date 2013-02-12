<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
    <head>
        <title><fmt:message key="titre2"/></title>
    </head>
    <body>
        <h1><fmt:message key="entete"/> ${model.p.getNom()} ${model.p.getPrenom()}</h1>
        <a href="<c:url value="/confirmation.htm?l=fr"/>">Francais</a><br> 
        <a href="<c:url value="/confirmation.htm?l=an"/>">English</a><br> 
    </body>
</html>
