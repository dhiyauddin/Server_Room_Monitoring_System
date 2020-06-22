<!DOCTYPE html>
<html lang="en">

<head>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	String loginUser = (String) request.getSession().getAttribute("loginUser");

	if (loginUser == null) {
		try {
			response.sendRedirect("/Server_Room_Monitoring");
		} catch (Exception e) {
			out.print("error");
		}
	} else {
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Dashboard</title>

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="#">
				<div class="sidebar-brand-icon ">
					<img class="img-profile rounded-circle"
						src="resources/logo_quatriz.jpeg">
				</div>
				<div class="sidebar-brand-text mx-3">Data Monitoring</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="dashboard">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Process</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Process:</h6>
						<a class="collapse-item" href="rooms">Rooms</a> <a
							class="collapse-item" href="servers">Servers</a> <a
							class="collapse-item" href="devices">Sensor Devices</a> <a
							class="collapse-item" href="reports">Reports</a> <a
							class="collapse-item" href="dataEntry">Data Entry</a><a
							class="collapse-item" href="help">Help</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>


						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${loginUser}</span>

						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">

								<a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="logout"> <i
									class="fa fa-sign-out fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>

							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Servers</h1>
					</div>

					<!-- Content Row -->
					<div class="row">
						<c:forEach items="${devicesStatusData}" var="item">
							<!-- Devices 1 -->
							<div class="col-xl-3 col-md-6 mb-4">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="text-xs font-weight-bold text-primary text-uppercase mb-1">
													<a href="#">Device Id : ${item.deviceId}</a>
												</div>
											</div>
											<div class="col-auto">
												<i class="fas fa-upload fa-2x text-gray-300"></i>
											</div>
										</div>
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="text-xs font-weight-bold text-primary text-uppercase mb-1">
													Temperature <br> ${item.temperature} °C
												</div>
											</div>
											<div class="col-auto">
												Humidity <br> ${item.humidity} %
											</div>
										</div>
										<div class="row no-gutters align-items-center">
											<div class="col-mr-2">
												Battery <br> ${item.battery} %
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<!-- Content Row -->
					<div class="row">
						<!-- Searching Device -->
						<div class="col-xl-12 col-md-12 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-6">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												<!-- Search form -->
												<div>
													<h6>Searching Servers :</h6>
												</div>
												<form
													class="form-inline d-flex justify-content-center md-form form-sm active-pink active-pink-2 mt-2"
													action="serversFind" method="get">
													<i class="fas fa-search" aria-hidden="true"></i> <input
														class="form-control form-control-sm ml-3 w-75" type="text"
														placeholder="Search" aria-label="Search" id="search"
														name="serverId"> <input type="submit"
														value="Search" />
												</form>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-server fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>

					<!-- Content Row -->
					<div>
						<div>
							<h6>Listing Servers :</h6>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Server Id</th>
									<th scope="col">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${serversData}" var="item">
									<tr>
										<td><a href="devicesStatus?serverId=${item.serverId}">${item.serverId}</a></td>
										<td>${item.description}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<!-- Content Row -->



				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



	<!-- Bootstrap core JavaScript-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/js/sb-admin-2.min.js"></script>
</body>

</html>

<%
	}
%>
