<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../Header.jsp"></jsp:include>
    <!-- Header End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    
                    <div class="row">
                        <div class="pc-form-container">
                             <div class="section-title">
                                <h4>UPDATE USER</h4>
                            </div>   
                        
                            <c:if test="${updateStatus}">
                                <p>Update Successful. Go back <a href='manageuser'>Manage Page</a></p>
                            </c:if>
                                
                            <c:if test="${validator.hasError()}">
                                <p>There are some error. Please check again.</p>
                            </c:if>

                            <form class="pc-form" action="updateuser" method="post">
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="idUserDis">ID</label>
                                    <input type="text" name="idUserDis" value="${detailUser.id}" class="pc-form-text-field" disabled />
                                    <input type="hidden" name="id" value="${detailUser.id}" class="pc-form-text-field" />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="username">Username</label>
                                    <input type="text" name="username" value="${detailUser.username}" class="pc-form-text-field" required />
                                    <c:if test="${not empty validator.getUsernameError()}">
                                        <p>${validator.getUsernameError()}</p>
                                    </c:if>
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="fullname">Fullname</label>
                                    <input type="text" name="fullname" value="${detailUser.fullname}" class="pc-form-text-field" required />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="isExpert">Expert</label>
                                    <input type="radio" name="isExpert" value="1" class="pc-form-radio" <c:if test="${ detailUser.isExpert == true }">checked</c:if> /><a class="text-white">Yes</a>
                                    <input type="radio" name="isExpert" value="0" class="pc-form-radio" <c:if test="${detailUser.isExpert == false}">checked</c:if> /><a class="text-white">No</a>
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="isExpert">Admin</label>
                                    <input type="radio" name="isAdmin" value="1" class="pc-form-radio" <c:if test="${ detailUser.isAdmin == true }">checked</c:if> /><a class="text-white">Yes</a>
                                    <input type="radio" name="isAdmin" value="0" class="pc-form-radio" <c:if test="${detailUser.isAdmin == false}">checked</c:if> /><a class="text-white">No</a>
                                </div>
                                <br><br>
                                <button type="submit" class="site-btn">Update</button>
                            </form>
                        </div>
                    </div>
                    <a href="manageuser">Manage User</a>
                </div>
            </section>
        <!-- Product Section End -->

        
        <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


