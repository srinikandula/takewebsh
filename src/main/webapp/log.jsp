<%@ page import="java.util.*"%>
<%@ page import="org.apache.logging.log4j.*"%>
<%@ page import="org.apache.logging.log4j.core.Logger"%>
<%@ page import="org.apache.logging.log4j.core.*"%>
<%@ page import="org.slf4j.LoggerFactory"%>
<%@ page import="org.apache.logging.log4j.core.config.*"%>

<!DOCTYPE html>
<!--
version: 1
Requires: com.staples.Util [1.1.5,)
->
<%// always ensure the root logger is initilized
    LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);

    String msg = null;
    String err = null;
    try {
        String action = request.getParameter("action");
        if ("getlogger".equals(action)) {
            LoggerFactory.getLogger(request.getParameter("name"));
        } else if ("set".equals(action)) {
            LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            Configuration conf = ctx.getConfiguration();
            LoggerConfig named = conf.getLoggerConfig(request.getParameter("name"));
            named.setLevel(Level.valueOf(request.getParameter("level")));
            ctx.updateLoggers(conf);
        } else if ("debug".equals(action)) {
            LoggerFactory.getLogger(request.getParameter("name")).debug("hello world!");
        } else if ("info".equals(action)) {
            LoggerFactory.getLogger(request.getParameter("name")).info("hello world!");
        } else if ("warn".equals(action)) {
            LoggerFactory.getLogger(request.getParameter("name")).warn("hello world!");
        } else if ("error".equals(action)) {
            LoggerFactory.getLogger(request.getParameter("name")).error("hello world!");
        }
    } catch (Throwable t) {
        err = t.getMessage();
    }%>
<html>
<head>
<title>Logging Administration</title>

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

<%
    if (msg != null) {
%>
<div class="alert alert-success" role="alert"><%=msg%></div>
<hr />
<%
    }

    if (err != null) {
%>
<div class="alert alert-danger" role="alert"><%=err%></div>
<hr />
<%
    }
%>

<h3>Get Logger</h3>
<form class="form-inline">
    <div class="form-group">
        <input name="action" value="getlogger" type="hidden" /><input
            class="form-control" type="text" name="name" /><input
            class="btn btn-primary btn-s" type="submit"
            value="LoggerFactory.getLogger(name)" />
    </div>
</form>

<h3>Loggers</h3>
<table class="table table-condensed table-striped table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Level</th>
        <th>Test</th>
    </tr>
    </thead>
    <tbody>
    <%
        LoggerContext logContext = (LoggerContext) LogManager.getContext(false);
        Collection<Logger> loggers = logContext.getLoggers();
        List<String> loggerNames = new ArrayList<String>(loggers.size());
        for (Logger logger : loggers) {
            loggerNames.add(logger.getName());
        }
        Collections.sort(loggerNames);
        for (String name : loggerNames) {
            Level level = logContext.getLogger(name).getLevel();
    %>
    <tr>
        <td><%=name%></td>
        <td><form>
            <input type="hidden" name="action" value="set" /> <input
                type="hidden" name="name" value="<%=name%>" /><select
                name="level" onchange="this.form.submit()">
            <%
                for (String l : new String[] { "DEBUG", "INFO", "WARN", "ERROR" }) {
                    out.println("<option " + (l.equals(level.name()) ? "selected" : "") + " >" + l + "</option>");
                }
            %>
        </select>
        </form></td>
        <td><table>
            <tr>
                <td><form class="form-inline">
                    <input class="form-control" type="hidden" name="action"
                           value="debug" /><input class="form-control" type="hidden"
                                                  name="name" value="<%=name%>" /><input
                        class="btn btn-primary btn-sm" type="submit" name="level"
                        value="DEBUG" />
                </form></td>
                <td>
                    <form class="form-inline">
                        <input class="form-control" type="hidden" name="action"
                               value="info" /><input class="form-control" type="hidden"
                                                     name="name" value="<%=name%>" /><input
                            class="btn btn-info btn-sm" type="submit" name="level"
                            value="INFO" />
                    </form>
                </td>
                <td>
                    <form class="form-inline">
                        <input class="form-control" type="hidden" name="action"
                               value="warn" /><input class="form-control" type="hidden"
                                                     name="name" value="<%=name%>" /><input
                            class="btn btn-warning btn-sm" type="submit" name="level"
                            value="WARN" />
                    </form>
                </td>
                <td>
                    <form class="form-inline">
                        <input class="form-control" type="hidden" name="action"
                               value="error" /><input class="form-control" type="hidden"
                                                      name="name" value="<%=name%>" /><input
                            class="btn btn-danger btn-sm" type="submit" name="level"
                            value="ERROR" />
                    </form>
                </td>
            </tr>
        </table></td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>
</body>
</html>