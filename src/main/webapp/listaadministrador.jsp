<%@page import="java.util.List"%>
<%@page import="br.com.direcaocerta.entidades.Administrador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
   <title>Direção Certa - Caruaru</title>

    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Carregando Fontes -->
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:500' rel='stylesheet' type='text/css'>

    <!--Load styles -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/magnific-popup.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/cadastro.css">

<script type="text/javascript">
	function confirmaExclusao(id){
		if(window.confirm('tem certeza que deseja excluir?')){
			location.href="administradorcontroller.do?acao=exc&id_administrador="+id;
			
		}
	}
</script>
</head>
<body>
    <header>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
    <!-- Marca e alternância se agrupados para melhor visualização móvel -->
    <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#"><img src="img/logo.png" alt="Logomarca da Empresa" /></a>
    </div>
    <div class="collapse navbar-collapse navbar-right" id="navbar-collapse">

    <div id = "bandeiras">
    <a href="index.html"><img src="img/bandeiras/Brazil-icon.png"></a>
    <a href="index.html"> <img src="img/bandeiras/United-Kingdom-icon.png"></a>
    <a href="index.html"><img src="img/bandeiras/Spain-icon.png"></a>
    </div>

    <div id = "navegação">
    <ul class="nav navbar-nav">

    <li><a data-scroll href="index.html#home">Início</a></li>
    <li><a href="pontosturisticos.html">Pontos Turisticos</a></li>
    <li><a data-scroll href="index.html#services">Serviços</a></li>
    <li><a data-scroll href="index.html#about">Novidades</a></li>
    <li><a data-scroll href="index.html#contact">Contatos</a></li>

    </ul>
    </div>
    </div>
    </div>
    </nav>
    </header>

    

    <%
		List<Administrador> lista = (List<Administrador>)request.getAttribute("lista");
	%>
	    
    <div align = "center">
    <br><br><br><br><br><br>
    <img src="img/paineldoadministrador.jpg"/>
    <br>
    </div>
    
	<table align = "center" border=3>
	<tr>
		<th>Id do Administrador</th>
		<th>Nome do Administrador</th>
		<th>Login do Administrador</th>
		<th>Cpf do Administrador</th>
		<th>Excluir</th>
		<br>
		<th><a href="formalteraradministrador.html">Alterar</a></th></tr>
	
	<% for(Administrador a : lista){%>
			
		<tr  align="center" bottom="middle">	
			<td><%out.print(a.getId_administrador());%> 
			<td><%= a.getNome_administrador()%>
			<td><%= a.getLogin_administrador()%>
			<td><%= a.getCpf_administrador()%>
			<td><a href="javascript:confirmaExclusao(<%=a.getId_administrador()%>)">
			 <img src="img/delete.png"/>
			 </a></td>
		</tr>	
		<%} %>
	</table>
	<div align="right">
		<br><br>
		<a href="empresacontroller.do?acao=lis" class="btn btn-lg btn-primary button--ujarak">Ver Empresas</a>
		<br><br>
		<a href="mapacontroller.do?acao=lis" class="btn btn-lg btn-primary button--ujarak">Ver Mapas</a>
	</div>
    
    
    <br><br><br><br>



    <!-- End bagaça -->




    <div class="address">
    <div class="row">
    <div class="col-md-4 text-center wow zoomIn">
    <i class="fa fa-phone circled"></i>
    <span>69 - 6666 6666</span>
    </div>
    <div class="col-md-4 text-center wow zoomIn" data-wow-delay="0.2s">
    <i class="fa fa-envelope circled"></i>
    <span>sistemax@hotmail.com</span>
    </div>
    <div class="col-md-4 text-center wow zoomIn" data-wow-delay="0.4s">
    <i class="fa fa-globe circled"></i>
    <span>Fafica</span>
    <span>Caruaru</span>
    </div>
    </div>
    </div>
    </div>
    </section>
    <!-- End contact section -->
    <!-- Start footer section -->
    <footer>
    <div class="container">
    <p class="copyright">
    &copy; 2015 All rights reserved - Sistemax

    <p class="acesso">

    <a href="login.html"><img src="img/App-login-manager-icon.png"/> </a>
    <a href="cadadm.html"><img src="img/Icones/adm.png"/></a>
    <a href="cadempon.html"><img src="img/Icones/1444785052_aiga_bus_on_grn_circle.png"/></a>
    </p>

    </p>

    <ul class="social">
    <li class="wow bounceIn"><a href="http://google.com" target="_blank"><i class="fa fa-facebook"></i></a></li>
    <li class="wow bounceIn" data-wow-delay="0.1s"><a href="http://google.com" target="_blank"><i class="fa fa-twitter"></i></a></li>
    <li class="wow bounceIn" data-wow-delay="0.5s"><a href="http://google.com" target="_blank"><i class="fa fa-google"></i></a></li>

    </ul>




    <a href="index.html#home" data-scroll class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    </div>
    </footer>
    <!-- End footer section -->
    <!-- End footer section -->

    <!-- Load jQuery -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

    <!-- Load Booststrap -->
    <script type="text/javascript" src="js/bootstrap.js"></script>

    <!-- Load custom js plugins -->
    <script type="text/javascript" src="js/jquery.mixitup.js"></script>
    <script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="js/wow.js"></script>
    <script type="text/javascript" src="js/smooth-scroll.js"></script>

    <!-- Load custom js for theme -->
    <script type="text/javascript" src="js/app.js"></script>

    <!-- End bagaça -->




    <div class="address">
    <div class="row">
    <div class="col-md-4 text-center wow zoomIn">
    <i class="fa fa-phone circled"></i>
    <span>69 - 6666 6666</span>
    </div>
    <div class="col-md-4 text-center wow zoomIn" data-wow-delay="0.2s">
    <i class="fa fa-envelope circled"></i>
    <span>sistemax@hotmail.com</span>
    </div>
    <div class="col-md-4 text-center wow zoomIn" data-wow-delay="0.4s">
    <i class="fa fa-globe circled"></i>
    <span>Fafica</span>
    <span>Caruaru</span>
    </div>
    </div>
    </div>
    </div>
    </section>
    <!-- End contact section -->
    <!-- Start footer section -->
    <footer>
    <div class="container">
    <p class="copyright">
    &copy; 2015 All rights reserved - Sistemax

    <p class="acesso">

    <a href="login.html"><img src="img/App-login-manager-icon.png"/> </a>
    <a href="cadadm.html"><img src="img/Icones/adm.png"/></a>
    <a href="cadempon.html"><img src="img/Icones/1444785052_aiga_bus_on_grn_circle.png"/></a>
    </p>

    </p>

    <ul class="social">
    <li class="wow bounceIn"><a href="http://google.com" target="_blank"><i class="fa fa-facebook"></i></a></li>
    <li class="wow bounceIn" data-wow-delay="0.1s"><a href="http://google.com" target="_blank"><i class="fa fa-twitter"></i></a></li>
    <li class="wow bounceIn" data-wow-delay="0.5s"><a href="http://google.com" target="_blank"><i class="fa fa-google"></i></a></li>

    </ul>




    <a href="index.html#home" data-scroll class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    </div>
    </footer>
    <!-- End footer section -->
    <!-- End footer section -->

    <!-- Load jQuery -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

    <!-- Load Booststrap -->
    <script type="text/javascript" src="js/bootstrap.js"></script>

    <!-- Load custom js plugins -->
    <script type="text/javascript" src="js/jquery.mixitup.js"></script>
    <script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="js/wow.js"></script>
    <script type="text/javascript" src="js/smooth-scroll.js"></script>

    <!-- Load custom js for theme -->
    <script type="text/javascript" src="js/app.js"></script>
    </body>
    </html>







