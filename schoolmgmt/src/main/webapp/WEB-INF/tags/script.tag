 <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="/js/mdb.min.js"></script>
  <script type="text/javascript" src="/js/addons/datatables.min.js"></script>
    <script type="text/javascript">
 // Material Select Initialization
    $(document).ready(function() {
    $(".mdb-select").material_select();
    });
	</script>
  <script>
    // SideNav Button Initialization
$(".button-collapse").sideNav();
var el = document.querySelector('.custom-scrollbar');
Ps.initialize(el);

// Show sideNav
$('.button-collapse').sideNav('show');
// Hide sideNav
$('.button-collapse').sideNav('hide');
$('#response').on('hidden.bs.modal', function () {
	location.reload(true);
	});
  </script>