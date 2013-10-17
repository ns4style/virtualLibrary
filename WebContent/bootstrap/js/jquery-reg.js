$(document)
		.ready(
				function() {

					$("input[name*='email']").bind("change", emailCheck);
					$("input[name*='fname']").bind("change", fnameCheck);
					$("input[name*='lname']").bind("change", lnameCheck);
					$("input[name*='pass']").bind("change", passCheck);
					$("input[name*='descr']").bind("change", descrCheck);
					$("button[name*='reg']").bind("click", register);
					$('#register').on('hidden', hideModal);
					var flag1 = false;
					var flag2 = false;
					var flag3 = false;
					var flag4 = false;
					var flag5 = false;
					var flagReg = false;

					function emailCheck(e) {
						flag1 = false;
						$("#checkemail").remove();
						var newElem;
						var reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,6})+$/;
						var value = $("[name*='email']").val();
						if (reg.test(value)) {
							newElem = $('<p id="checkemail" class="label label-success">&#10003</p>');
							$("div#email").append(newElem);
							$.post("index?action=prereg&email=" + value,
									ajaxCheck);
						} else {
							newElem = $('<p id="checkemail" class="label label-important">x</p>');
							$("div#email").append(newElem);
						}
					}
					;

					function fnameCheck(e) {
						flag2 = false;
						$("#checkfname").remove();
						var newElem;
						var reg = /^[_a-zA-Z0-9]+$/;
						var value = $("[name*='fname']").val();
						if (reg.test(value)) {
							newElem = $('<p id="checkfname" class="label label-success">&#10003</p>');
							flag2 = true;
						} else
							newElem = $('<p id="checkfname" class="label label-important">Use only letters and numbers</p>');
						$("div#fname").append(newElem);
					}
					;

					function lnameCheck(e) {
						flag3 = false;
						$("#checklname").remove();
						var newElem;
						var reg = /^[_a-zA-Z0-9]+$/;
						var value = $("[name*='lname']").val();
						if (reg.test(value)) {
							newElem = $('<p id="checklname" class="label label-success">&#10003</p>');
							flag3 = true;
						} else
							newElem = $('<p id="checklname" class="label label-important">Use only letters and numbers</p>');
						$("div#lname").append(newElem);
					}
					;

					function passCheck(e) {
						flag4 = false;
						$("#checkpass").remove();
						var newElem;
						var reg = /^[_a-zA-Z0-9]+$/;
						var value = $("[name*='pass']").val();
						if (reg.test(value)) {
							newElem = $('<p id="checkpass" class="label label-success">&#10003</p>');
							flag4 = true;
						} else
							newElem = $('<p id="checkpass" class="label label-important">Use only letters and numbers</p>');
						$("div#pass").append(newElem);
					}
					;

					function descrCheck(e) {
						flag5 = false;
						$("#checkdescr").remove();
						var newElem;
						var reg = /^[_a-zA-Z0-9]+$/;
						var value = $("[name*='descr']").val();
						if (reg.test(value)) {
							newElem = $('<p id="checkdescr" class="label label-success">&#10003</p>');
							flag5 = true;
						} else
							newElem = $('<p id="checkdescr" class="label label-important">Use only letters and numbers</p>');
						$("div#descr").append(newElem);
					}
					;

					function hideModal(e) {
						$("input[name*='email']").val("");
						$("input[name*='fname']").val("");
						$("input[name*='lname']").val("");
						$("input[name*='pass']").val("");
						$("input[name*='descr']").val("");
						$("#checkemail").remove();
						$("#checkfname").remove();
						$("#checklname").remove();
						$("#checkpass").remove();
						$("#checkdescr").remove();
						flag1 = false;
						flag2 = false;
						flag3 = false;
						flag4 = false;
						flag5 = false;
					}
					;

					function ajaxCheck(data) {
						if (data == "true") {
							$("#checkemail").remove();
							newElem = $('<p id="checkemail" class="label label-important">This email already used</p>');
							$("div#email").append(newElem);
						} else
							flag1 = true;
						if (flagReg) {
							var e;
							fnameCheck(e);
							lnameCheck(e);
							passCheck(e);
							descrCheck(e);
							flagReg = false;
							if ((flag1) && (flag2) && (flag3) && (flag4)
									&& (flag5)) {
								$.post("index?action=reg&email="
										+ $("[name*='email']").val()
										+ "&fname="
										+ $("[name*='fname']").val()
										+ "&lname="
										+ $("[name*='lname']").val() + "&pass="
										+ $.md5($("[name*='pass']").val())
										+ "&descr="
										+ $("[name*='descr']").val(), ajaxReg);
							}
						}

					}
					;

					function ajaxReg(data) {
						$('#register').modal('hide')
						if (data == "true")
							$('#regComplete').modal('show')
						else
							$('#regFailed').modal('show')
					}

					function register(e) {
						var e;
						flagReg = true;
						emailCheck(e);
					}
					;
				});