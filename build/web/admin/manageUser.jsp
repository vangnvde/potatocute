<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">

            <div style="align-items: center ">
                <div class="pc-table-container">
                    <div class="section-title">
                        <h4>MANAGE USER</h4>
                    </div>  
                    <br>    
                    <table class="table table-striped table-dark" style="border-radius: 10px">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <td scope="col">Username</td>
                                <td scope="col">Fullname</td>
                                <td scope="col">Expert</td>
                                <td scope="col">Admin</td>
                                <td scope="col">Option</td>
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listAllUser}" var="o">
                            <tr>
                                <th scope="col">${o.id}</th>
                                <td>${o.username}</td>
                                <td>${o.fullname}</td>
                                <td>${o.isExpert}</td>
                                <td>${o.isAdmin}</td>
                                <td><a href="updateuserload?userID=${o.id}"><img style="width: 25px" src="img/edit.png"/></a>
                                    <a href="deleteuser?userID=${o.id}"><img style="width: 25px" src="img/remove.png"/></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


