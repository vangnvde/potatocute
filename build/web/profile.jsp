<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp"></jsp:include>
    <!-- Header End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    
                    <div class="row">
                        <div class="pc-form-container">
                             <div class="section-title">
                                <h4>${pageTitle}</h4>
                            </div>   
                        
                            <c:if test="${updateStatus}">
                                <p>Cập nhật thành công. Quay về <a href='home'>Trang chủ</a></p>
                            </c:if>

                            <form class="pc-form" action="profileupdate" method="post">
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="idUserDis">ID</label>
                                    <input type="text" name="idUserDis" value="${detailUser.id}" class="pc-form-text-field" disabled />
                                    <input type="hidden" name="id" value="${detailUser.id}" class="pc-form-text-field" />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="username">Username</label>
                                    <input type="text" name="username" value="${detailUser.username}" class="pc-form-text-field" disabled />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="fullname">Fullname</label>
                                    <input type="text" name="fullname" value="${detailUser.fullname}" class="pc-form-text-field" required />
                                </div>
                                <br><br>
                                <button type="submit" class="site-btn">Cập nhật</button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        <!-- Product Section End -->

        
        <!-- Footer Section Begin -->
<jsp:include page="Footer.jsp"></jsp:include>



