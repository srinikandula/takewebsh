<%@ page import="com.staples.util.Util"%>
<%@ page import="java.net.URL"%>
<%@ page import="com.staples.util.Util.ManifestWrapper"%>
<%@ page import="java.util.jar.Manifest"%>
<%@ page import="java.io.ByteArrayOutputStream"%>
<!DOCTYPE html>
<!--
version: 4
Requires: com.staples.Util [1.1.5,)
->
<%
    String action = request.getParameter("action");
%>
<html>
<head>
<title>Info</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" />

<!-- Latest compiled and minified JavaScript -->
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</head>
<body>
<pre class="alert alert-success"><%@include
        file="META-INF/MANIFEST.MF"%></pre>
<%
    for (ManifestWrapper m : Util.getManifests(".*")) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        m.getManifest().write(b);
        b.close();
        out.write("<pre>" + m.getPath() + "\n\n" + b.toString() + "</pre><center><a href='#top'>back to top</a></center>");
    }
%>
</body>
</html>