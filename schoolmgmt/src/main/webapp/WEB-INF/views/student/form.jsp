<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Student </title>
<tags:style />
</head>
<body>
	<tags:header />

	<!-- Classic tabs -->
<div class="classic-tabs">

  <ul class="nav tabs-cyan" id="myClassicTab" role="tablist">
    <li class="nav-item">
      <a class="nav-link  waves-light active show" id="profile-tab-classic" data-toggle="tab" href="#student-classic"
        role="tab" aria-controls="profile-classic" aria-selected="true">Student</a>
    </li>
    <li class="nav-item">
      <a class="nav-link waves-light" id="follow-tab-classic" data-toggle="tab" href="#father-classic" role="tab"
        aria-controls="follow-classic" aria-selected="false">Follow</a>
    </li>
    <li class="nav-item">
      <a class="nav-link waves-light" id="contact-tab-classic" data-toggle="tab" href="#contact-classic" role="tab"
        aria-controls="contact-classic" aria-selected="false">Contact</a>
    </li>
    <li class="nav-item">
      <a class="nav-link waves-light" id="awesome-tab-classic" data-toggle="tab" href="#awesome-classic" role="tab"
        aria-controls="awesome-classic" aria-selected="false">Be awesome</a>
    </li>
  </ul>
  <div class="tab-content border-right border-bottom border-left rounded-bottom" id="myClassicTabContent">
    <div class="tab-pane fade active show" id="student-classic" role="tabpanel" aria-labelledby="profile-tab-classic">
      <!-- STUDENT FORM -->
    </div>
    <div class="tab-pane fade" id="father-classic" role="tabpanel" aria-labelledby="follow-tab-classic">
      <!-- FATHER FORM -->
    </div>
    <div class="tab-pane fade" id="contact-classic" role="tabpanel" aria-labelledby="contact-tab-classic">
      <!-- MOTHER FORM -->
    </div>
    <div class="tab-pane fade" id="awesome-classic" role="tabpanel" aria-labelledby="awesome-tab-classic">
      <!-- LOCALGUARDIAN FORM -->
    </div>
  </div>

</div>
<!-- Classic tabs -->
	<tags:response/>
	<tags:footer />
	<tags:script />
	
</body>
</html>