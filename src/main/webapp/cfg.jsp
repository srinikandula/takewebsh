<%@ page import="java.util.*"%>
<%@ page import="com.staples.util.Util"%>
<%@ page import="com.staples.util.CFG"%>
<%@ page import="com.staples.util.CFG.*"%>
<!DOCTYPE html>
<!--
version: 5
Requires: com.staples.Util [1.1.5,)
->
<%String msg = null;
    String err = null;
    try {
        String action = request.getParameter("action");
        if (action != null) {
            if ("get".equals(action)) {
                CFG cfg = CFG.getInstance(request.getParameter("ctx"));
                String key = request.getParameter("key");
                String value = cfg.getString(key);
                String location = cfg.getLocation(key);
                msg = "["+key+"]=["+value+"] ("+location+")";
                if (location.contains("null")) {
                    msg +=" GLOBAL";
                }
            }
            else if ("getinstance".equals(action)) {
                CFG.getInstance(request.getParameter("ctx"));
            }
            else if (action.contains("reload")) {
                String ctx = request.getParameter("ctx");
                if (ctx != null) {
                    CFG.getInstance(ctx).reload();
                    msg = "Reloaded ctx:[" + ctx + "]";
                } else {
                    CFG.reloadEverything();
                    msg = "Reloaded all configurations";
                }
            }

            // DB & full reload
            else if ("add".equals(action)) {
                CFG.insert(request.getParameter("ctx"), request.getParameter("key"), request.getParameter("value"));
                msg = "Successfully added configuration";
            } else if ("update".equals(action)) {
                CFG.update(Long.parseLong(request.getParameter("dbId")), request.getParameter("value"));
                msg = "Successfully updated configuration";
            } else if ("delete".equals(action)) {
                CFG.delete(Long.parseLong(request.getParameter("dbId")));
                msg = "Successfully deleted configuration";
            }

            // ctx specific
            else if ("set".equals(action)) {
                CFG.getConfigsMap().get(request.getParameter("ctx")).set(request.getParameter("key"), request.getParameter("value"));
                msg = "Successfully set configuration";
            } else if ("remove".equals(action)) {
                CFG.getConfigsMap().get(request.getParameter("ctx")).remove(request.getParameter("key"));
                msg = "Successfully removed configuration";
            }

            // default
            else {
                msg = "Unknown action:[" + action + "]!";
            }
        }

    } catch (Throwable t) {
        err = t.getMessage();
    }%>

<html>
<head>
<title>Configuration Administration</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    function appendValue(a, id) {
        a.href = a.href + '&value=' + document.getElementById(id).value;
    }
</script>
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
<a class="btn btn-warning btn-xs"
   href="<%=request.getContextPath()%>/cfg.jsp?action=reload">Reload
    All Configurations</a>

<h3>Get Configuration</h3>
<form class="form-inline">
    <input name="action" value="get" type="hidden" /> <select
        class="form-control" name="ctx">
    <%
        List keys = new ArrayList(CFG.getConfigsMap().keySet());
        Collections.sort(keys);
        for (Iterator<String> i = keys.iterator(); i.hasNext();) {
            String key = i.next();
    %>
    <option><%=key%></option>
    <%
        }
    %>
</select><input class="form-control" type="text" name="key" /><input
        class="form-control btn btn-primary btn-sm" type="submit" value="Get" />
</form>

<%
    if (!CFG.isNoDb()) {
%>
<h3>Add Configuration</h3>
<p>
    Where Ctx is one of the following schemes (in order of precedence):
    CTX (leave empty for a GLOBAL), CTX.<%=CFG.getAppGroup() != null ? "CFG.getAppGroup()" : "${app.group} (not currently specified)"%>,
    <%=Util.getSimpleHostName()%>, CTX.<%=Util.getSimpleHostName()%></p>
<form class="form-inline">
    <div class="form-group">
        <input name="action" value="add" type="hidden" />
        <table class="table">
            <thead>
            <tr>
                <th>Ctx</th>
                <th>Key</th>
                <th>Value</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input class="form-control" type="text" name="ctx" /></td>
                <td><input class="form-control" type="text" name="key" /></td>
                <td><input class="form-control" type="text" name="value" /></td>
                <td><input class="btn btn-primary btn-s" type="submit"
                           value="Add" /></td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
<%
} else {
%>
<font color="red">WARNING: No DB connection!</font>
<%
    }
%>

<%-- show all known congiurations contexts --%>
<h3>Active Contexts</h3>
<ul class="nav nav-pills">
    <%
        List keys2 = new ArrayList(CFG.getConfigsMap().keySet());
        Collections.sort(keys2);
        for (Iterator<String> i = keys2.iterator(); i.hasNext();) {
            String key = i.next();
    %>
    <li role="presentation"><a href="#<%=key%>"><%=key%></a></li>
    <%
        }
    %>
</ul>
<p>If the context your looking for is not listed here, that's
    because it hasen't been programmatically used yet and is not active.
    You can manually get it with the following. Also note that code
    defaults appear with usage and have a location of "CODE DEFAULT".</p>
<form class="form-inline">
    <div class="form-group">
        <input name="action" value="getinstance" type="hidden" /><input
            class="form-control" type="text" name="ctx" /><input
            class="btn btn-primary btn-s" type="submit"
            value="CFG.getInstance(ctx)" />
    </div>
</form>

<%-- show all global congiurations --%>
<h3>Globals</h3>
<a class="btn btn-warning btn-xs"
   href="<%=request.getContextPath()%>/cfg.jsp?action=reloadGlobals">Reload
    Globals</a>
<p />
<table class="table table-striped table-hover table-condensed">
    <thead>
    <tr>
        <th>Key</th>
        <th>Value</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        int id = 0;
        for (Map.Entry<String, CFG.InfoWrapper> cfg : CFG.getGlobalConfigs().entrySet()) {
            id++;
    %>
    <tr>
        <td><%=cfg.getKey()%></td>
        <td><form class="form-inline">
            <input class="form-control" size="60" type="text" id="g_<%=id%>"
                   value="<%=cfg.getValue().getValue()%>" />
        </form></td>
        <td>
            <%--update --%> <a class="btn btn-primary"
                               href="<%=request.getContextPath()%>/cfg.jsp?action=update&dbId=<%=cfg.getValue().getDbId()%>"
                               onclick="appendValue(this, 'g_<%=id%>')">Update</a> <%--remove --%>
            <a class="btn btn-danger"
               href="<%=request.getContextPath()%>/cfg.jsp?action=delete&dbId=<%=cfg.getValue().getDbId()%>"
               onclick="return confirm('Are you sure you want to delete this configuration from the DB?')">Delete</a>
        </td>
    </tr>
    </tbody>
    <%
        }
    %>
</table>

<%-- show all known congiurations for each context --%>
<%
    for (Map.Entry<String, CFG> e : CFG.getConfigsMap().entrySet()) {
%>
<a name="<%=e.getKey()%>"></a>
<h3><%=e.getKey()%></h3>
<a class="btn btn-warning btn-xs"
   href="<%=request.getContextPath()%>/cfg.jsp?action=reload&ctx=<%=e.getKey()%>">Reload
    <%=e.getKey()%></a>
<p />
<table class="table table-striped table-hover table-condensed">
    <thead>
    <tr>
        <th>Key</th>
        <th>Value</th>
        <th>Location</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Map.Entry<String, CFG.InfoWrapper> cfg : e.getValue().getConfigs().entrySet()) {
            if (!cfg.getValue().getLocation().equals("DB null")) {
                id++;
    %>
    <tr>
        <td><%=cfg.getKey()%></td>
        <td><form class="form-inline">
            <input class="form-control" size="60" type="text"
                   id="v_e.<%=e.getKey()%>_<%=id%>"
                   value="<%=cfg.getValue().getValue()%>" />
        </form></td>
        <td><%=cfg.getValue().getLocation().equals("DB null") ? "DB GLOBAL" : cfg.getValue().getLocation()%></td>
        <td>
            <%
                if (!cfg.getValue().getLocation().startsWith("DB ")) {
            %> <%--set --%> <a class="btn btn-primary"
                               href="<%=request.getContextPath()%>/cfg.jsp?action=set&ctx=<%=e.getKey()%>&key=<%=cfg.getKey()%>"
                               onclick="appendValue(this, 'v_e.<%=e.getKey()%>_<%=id%>')">Set</a>
            <%--remove --%> <a class="btn btn-danger"
                               href="<%=request.getContextPath()%>/cfg.jsp?action=remove&ctx=<%=e.getKey()%>&key=<%=cfg.getKey()%>"
                               onclick="return confirm('Are you sure you want to remove this configuration?')">Remove</a>
            <%
            } else {
            %> <%--update --%> <a class="btn btn-primary"
                                  href="<%=request.getContextPath()%>/cfg.jsp?action=update&dbId=<%=cfg.getValue().getDbId()%>"
                                  onclick="appendValue(this, 'v_e.<%=e.getKey()%>_<%=id%>')">Update</a>
            <%--remove --%> <a class="btn btn-danger"
                               href="<%=request.getContextPath()%>/cfg.jsp?action=delete&dbId=<%=cfg.getValue().getDbId()%>"
                               onclick="return confirm('Are you sure you want to delete this configuration from the DB?')">Delete</a>
            <%
                }
            %>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
    <%
        }
    %>
</table>
<%
    }
%>


</body>
</html>