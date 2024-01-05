<!DOCTYPE html>
<html>
<head>
    <title>Báo cáo</title>
</head>
<body>
    <h1>Báo cáo thống kê</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Fullname</th>
                <th>Age</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <td>${user.fullname}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
