<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titre1"/></title>
    </head>
    <body>
        <h1><fmt:message key="entete"/></h1>
        <form method="post" name="f2">
            <fmt:message key="Alogin"/>   <input type="text" name="login" maxlength="20"/>
            <font color="red"><fmt:message key="${model.Clogin}"/><fmt:message key="${model.login}"/><fmt:message key="${model.loginV}"/></font><br>
            <fmt:message key="Apassword"/><input type="text" name="password" maxlength="20"/>
            <font color="red"><fmt:message key="${model.Cpass}"/><fmt:message key="${model.pass}"/><fmt:message key="${model.passV}"/></font><br>
            <input type="submit" value="<fmt:message key="connecter"/>" name="login"/>
            <c:out value="${model.error}"/>
        </form>

        <form method="post" name="f1">
            <fmt:message key="Anom"/>   <input type="text" name="nom" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.nomV}"/><fmt:message key="${mymodel.nom}"/></font><br>
            <fmt:message key="Aprenom"/><input type="text" name="prenom" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.prenom}"/><fmt:message key="${mymodel.prenomV}"/></font><br>
            <fmt:message key="Acin"/>   <input type="text" name="cin" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.cin}"/><fmt:message key="${mymodel.cinV}"/></font><br>
            <fmt:message key="Acb"/><input type="text" name="cb" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.cb}"/><fmt:message key="${mymodel.cbV}"/></font><br>
            <fmt:message key="Aemail"/>   <input type="text" name="email" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.email}"/><fmt:message key="${mymodel.emailV}"/></font><br>
            <fmt:message key="Atel"/><input type="text" name="tel" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.tel}"/><fmt:message key="${mymodel.telV}"/></font><br>
            <fmt:message key="Alogin"/><input type="text" name="login" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.login}"/><fmt:message key="${mymodel.loginV}"/></font><br>
            <fmt:message key="Apassword"/>   <input type="text" name="password" maxlength="20"/>
            <font color="red"><fmt:message key="${mymodel.password}"/><fmt:message key="${mymodel.passwordV}"/></font><br>
            <input type="submit" value="<fmt:message key="inscrire"/>" name="inscription"/>
        </form>
        <a href="<c:url value="/inscri.htm"/>">S'inscrire</a><br>
        <a href="<c:url value="/hello.htm?langue=fr"/>">Francais</a><br> 
        <a href="<c:url value="/hello.htm?langue=an"/>">English</a><br> 
    </body>
</html>
