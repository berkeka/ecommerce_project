<html>
<%@ include file="navbar.jsp"%>
<%
String error = (String) request.getAttribute("error");
%>
<c:if test="${error != null}">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<%=error%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</c:if>
<div class="container-fluid">
	<div class="row d-flex justify-content-center">
		<div class="col-sm-12">
			<div class="card mx-auto">
				<p class="heading">PAYMENT DETAILS</p>
				<form class="card-details"
					action="${pageContext.request.contextPath}/Payment" method="POST">
					<div class="form-group mb-0">
						<p class="text-warning mb-0">Card Number</p>
						<input type="text" name="card-num"
							placeholder="1234 5678 9012 3457" size="17" id="cno"
							minlength="19" maxlength="19"> <img
							src="https://img.icons8.com/color/48/000000/visa.png"
							width="64px" height="60px" />
					</div>
					<div class="form-group">
						<p class="text-warning mb-0">Cardholder's Name</p>
						<input type="text" name="name" placeholder="Name" size="17">
					</div>
					<div class="form-group pt-2">
						<div class="row d-flex">
							<div class="col-sm-4">
								<p class="text-warning mb-0">Expiration</p>
								<input type="text" name="exp" placeholder="MM/YYYY" size="7"
									id="exp" minlength="7" maxlength="7">
							</div>
							<div class="col-sm-3">
								<p class="text-warning mb-0">Cvc</p>
								<input type="password" name="cvv"
									placeholder="&#9679;&#9679;&#9679;" size="1" minlength="3"
									maxlength="3">
							</div>
							<div class="col-sm-5 pt-0">
								<button type="submit" class="btn btn-primary">Checkout</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

body {
	background: linear-gradient(to right, rgba(235, 224, 232, 1) 52%,
		rgba(254, 191, 1, 1) 53%, rgba(254, 191, 1, 1) 100%);
	font-family: 'Roboto', sans-serif
}

.card {
	border: none;
	max-width: 450px;
	border-radius: 15px;
	margin: 150px 0 150px;
	padding: 35px;
	padding-bottom: 20px !important
}

.heading {
	color: #C1C1C1;
	font-size: 14px;
	font-weight: 500
}

img {
	transform: translate(160px, -10px)
}

img:hover {
	cursor: pointer
}

.text-warning {
	font-size: 12px;
	font-weight: 500;
	color: #edb537 !important
}

#cno {
	transform: translateY(-10px)
}

input {
	border-bottom: 1.5px solid #E8E5D2 !important;
	font-weight: bold;
	border-radius: 0;
	border: 0
}

.form-group input:focus {
	border: 0;
	outline: 0
}

.col-sm-5 {
	padding-left: 90px
}

.btn:focus {
	box-shadow: none
}
</style>
</html>