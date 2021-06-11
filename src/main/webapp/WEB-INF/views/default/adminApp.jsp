
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.addHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page='<%="../common/vd_header.jsp"%>' />
<div class="header-mobile-wrapper">
	<div class="app-header__logo">
		<a href="#" data-toggle="tooltip" data-placement="bottom"
			title="Smart Box Admin" class="logo-src"></a>
		<button type="button"
			class="hamburger hamburger--elastic mobile-toggle-sidebar-nav">
			<span class="hamburger-box"> <span class="hamburger-inner"></span>
			</span>
		</button>
		<div class="app-header__menu">
			<span>
				<button type="button"
					class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
					<span class="btn-icon-wrapper"> <i
						class="fa fa-ellipsis-v fa-w-6"></i>
					</span>
				</button>
			</span>
		</div>
	</div>
</div>
<div class="app-inner-layout app-inner-layout-page">
	<jsp:include page='<%="../common/vd_top_tabmenu.jsp"%>' />
	<div class="app-inner-layout__wrapper">
		<div class="app-inner-layout__content">
			<div class="container-fluid">
				<form action="" method="post">
					<div class="row">
						<div class="col-sm-12 col-lg-12">
							<h5>약관관리 > 관리자APP</h5>
						</div>
						<div class="col-sm-12 col-lg-6">
							<div class="mb-3 card">
								<div class="card-header-tab card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">
										이용약관</div>
								</div>
								<div class="p-2 card-body">
									<textarea rows="1" class="form-control autosize-input" name=""
										style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-lg-6">
							<div class="mb-3 card">
								<div class="card-header-tab card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">
										개인정보 처리방침</div>
								</div>
								<div class="p-2 card-body">
									<textarea rows="1" class="form-control autosize-input" name=""
										style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-lg-6">
							<div class="mb-3 card">
								<div class="card-header-tab card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">
										가입안내</div>
								</div>

								<div class="p-2 card-body">
									<textarea rows="1" class="form-control autosize-input" name=""
										style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-lg-6">
							<div class="mb-3 card">
								<div class="card-header-tab card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">
										탈퇴안내</div>
								</div>
								<div class="p-2 card-body">
									<textarea rows="1" class="form-control autosize-input" name=""
										style="max-height: 260px; height: 260px; margin-top: 0px; margin-bottom: 0px;"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<!--튜토리얼 이미지 업로드-->
						<div class="col-sm-12 col-lg-12">
							<div class="mb-12 card">
								<div class="card-header-tab card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">
										튜토리얼</div>
								</div>
								<div class="p-2 card-body">
									<div class="row">
										<div class="col-lg-7">
											<div class="img-group">
												<div style="display: inline-block;">
													<img style="width: 60px; height: 60px" alt="이미지1"
														src="/bootstrab/img/undraw_profile_1.svg" />
												</div>
												<div style="display: inline-block;">
													<img style="width: 60px; height: 60px" alt="이미지2"
														src="/bootstrab/img/undraw_profile_2.svg" />
												</div>
												<div style="display: inline-block;">
													<img style="width: 60px; height: 60px" alt="이미지3"
														src="/bootstrab/img/undraw_profile_3.svg" />
												</div>
												<div style="display: inline-block;">
													<img style="width: 60px; height: 60px" alt="이미지4"
														src="/bootstrab/img/undraw_profile_1.svg" />
												</div>
												<div style="display: inline-block;">
													<img style="width: 60px; height: 60px" alt="이미지5"
														src="/bootstrab/img/undraw_profile_2.svg" />
												</div>
											</div>
										</div>
										<div class="col-lg-5">
											<div class="file-upload-group">
												<div>
													<label>이미지1</label><input name="" type="file"
														accept="image/*" />
												</div>
												<div>
													<label>이미지2</label><input name="" type="file"
														accept="image/*" />
												</div>
												<div>
													<label>이미지3</label><input name="" type="file"
														accept="image/*" />
												</div>
												<div>
													<label>이미지4</label><input name="" type="file"
														accept="image/*" />
												</div>
												<div>
													<label>이미지5</label><input name="" type="file"
														accept="image/*" />
												</div>
												<div>
													<button style="width: 100px">저장</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page='<%="../common/vd_footer.jsp"%>' />
