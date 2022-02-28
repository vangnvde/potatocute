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
                        
                            <c:if test='${message == "1"}'>
                                <p>Cập nhật thành công. Quay về <a href='home'>Trang chủ</a></p>
                            </c:if>

                            <form class="pc-form" action="changepasswordupdate" method="post">                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="password">Mật khẩu mới</label>
                                    <input type="password" name="newPassword" value="${param.newPassword}" class="pc-form-text-field" required />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="fullname">Xác nhận</label>
                                    <input type="password" name="passwordConfirm" value="${param.passwordConfirm}" class="pc-form-text-field" required />
                                    <c:if test='${ message.equals("-1") }'>
                                        <p>Mật khẩu xác nhận không chính xác.</p>
                                    </c:if>
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



