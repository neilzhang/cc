<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Language" content="zh-cn" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CC</title>
<script type="text/javascript" src="resources/js/comet4j.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="resources/js/cc.js"></script>
</head>
<body >
    <div id="room_creater">
        <form>
            <label>Name</label><input type="text" id="room_name" /><br/>
            <label>Description</label><input type="text" id="room_description" /><br/>
            <input type="button" onclick="createAndJoin();" value="Create" />
        </form>
    </div>
	<div id="room_selecter">
	    <div id="top_list_rooms"></div>
	    <div id="search_room">
		    <label>Room</label><input type="text" id="search_name" />
	        <input type="button" onclick="join();" value="Join" />
	    </div>
	</div>
	<div id="room_panel">
		<div id="message_panel"></div>
		<div id="input_panel">
			<input type="text" id="input_message" />
			<input type="button" onclick="send();" value="Send" />
		</div>
	</div>
</body>
</html>