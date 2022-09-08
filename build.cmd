@echo off
if not exist target mkdir target
if not exist target\classes mkdir target\classes


echo compile classes
javac -nowarn -d target\classes -sourcepath jvm -cp "c:\users\admin\ideaprojects\adminsmartbox\jni4net\lib\jni4net.j-0.8.8.0.jar"; "jvm\myjni\MyJni.java" 
IF %ERRORLEVEL% NEQ 0 goto end


echo MyJni.j4n.jar 
jar cvf MyJni.j4n.jar  -C target\classes "myjni\MyJni.class"  > nul 
IF %ERRORLEVEL% NEQ 0 goto end


echo MyJni.j4n.dll 
csc /nologo /warn:0 /t:library /out:MyJni.j4n.dll /recurse:clr\*.cs  /reference:"C:\Users\Admin\IdeaProjects\adminSmartbox\MyJni.dll" /reference:"C:\Users\Admin\IdeaProjects\adminSmartbox\jni4net\lib\jni4net.n-0.8.8.0.dll"
IF %ERRORLEVEL% NEQ 0 goto end


:end
