<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">

            <div style="align-items: center">
                <div class="pc-table-container">  
                    <div class="section-title">
                        <h4>MANAGE FILM</h4>
                    </div>                                                                 
                    <br>
                    <table class="table table-striped table-dark" style="border-radius: 10px">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <td scope="col">Name</td>
                                <td scope="col">Time</td>
                                <td scope="col">Year</td>
                                <td scope="col">Type</td>
                                <td scope="col">Director</td>
                                <td scope="col">Distributor</td>
                                <td scope="col">Option</td>
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listAllFilms}" var="o">
                            <tr>
                                <th scope="col">${o.id}</th>
                                <td>${o.nameFilm}</td>
                                <td>${o.time}</td>
                                <td>${o.year}</td>
                                <td>${o.type}</td>
                                <td>${o.director}</td>
                                <td>${o.distributor}</td>
                                <td><a href="updatefilmload?filmID=${o.id}"><img style="width: 25px" src="img/edit.png"/></a>
                                    <a href="deletefilm?filmID=${o.id}"><img style="width: 25px" src="img/remove.png"/></a></td>                           </tr>
                                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="addfilmload"  class="site-btn" ><span>Add Film</span></a>

        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


