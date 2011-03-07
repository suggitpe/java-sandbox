<%@ include file="/WEB-INF/jsp/include/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/include/header.jsp" %>

<c:choose>
    <c:when test="${contact.new}"><c:set var="method" value="post"/></c:when>
    <c:otherwise><c:set var="method" value="put"/></c:otherwise>
</c:choose>

<h2><c:if test="${contact.new}">New </c:if>Counterparty contact:</h2>


<form:form modelAttribute="contact" method="${method}">
    <table>
        <tr>
            <th>
                First Name: <form:errors path="contactFirstName" ccsClass="errors"/>
                <br/>
                <form:input path="contactFirstName" size="30" maxlength="80"/>
            </th>
        </tr>
        <tr>
            <th>
                Family Name: <form:errors path="contactLastName" ccsClass="errors"/>
                <br/>
                <form:input path="contactLastName" size="30" maxlength="80"/>
            </th>
        </tr>
        <tr>
            <th>
                Address: <form:errors path="contactAddress" ccsClass="errors"/>
                <br/>
                <form:input path="contactAddress" size="30" maxlength="80"/>
            </th>
        </tr>
        <tr>
            <th>
                Postcode: <form:errors path="contactPostcode" ccsClass="errors"/>
                <br/>
                <form:input path="contactPostcode" size="30" maxlength="80"/>
            </th>
        </tr>
        <tr>
            <th>
                Telephone: <form:errors path="contactTelephone" ccsClass="errors"/>
                <br/>
                <form:input path="contactTelephone" size="30" maxlength="80"/>
            </th>
        </tr>
        <tr>
            <td>
                <c:choose>
                    <c:when test="${contact.new}">
                        <p class="submit"><input type="submit" value="Add Contact"/></p>
                    </c:when>
                    <c:otherwise>
                        <p class="submit"><input type="submit" value="Update Contact"/></p>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>


<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>